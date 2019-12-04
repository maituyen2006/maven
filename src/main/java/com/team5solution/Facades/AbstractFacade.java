package com.team5solution.Facades;

import com.team5solution.Entities.Product;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractFacade<T> implements Serializable {

    public Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }


    public AbstractFacade() {

    }

    public List list() {
        Session session = null;
        List list = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                Criteria criteria = session.createCriteria(entityClass);
                list = criteria.list();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            HibernateAction.getInstance().closeSession(session);
        }
        return list;
    }


    public T create(T entity) throws Exception {
        Session session = null;
        Transaction tran = null;
        T result = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                tran = session.beginTransaction();
                if (entity == null) {
                    throw new NullPointerException();
                }
                Serializable id = session.save(entity);
                session.flush();
                result = session.get(entityClass, id);
                HibernateAction.getInstance().commitTransaction(tran);
            }
        } catch (Exception e) {
            HibernateAction.getInstance().rollbackTransaction(tran);
            throw e;
        } finally {
            HibernateAction.getInstance().closeSession(session);
        }
        return result;
    }

    public void update(T entity) throws Exception {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                transaction = session.beginTransaction();
                session.update(entity);
                HibernateAction.getInstance().commitTransaction(transaction);
            }
        } catch (Exception ex) {
            HibernateAction.getInstance().rollbackTransaction(transaction);
            ex.printStackTrace();
        } finally {
            HibernateAction.getInstance().closeSession(session);
        }
    }

    public void delete(T entity) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                transaction = session.beginTransaction();
                session.delete(entity);
            }
        } catch (Exception ex) {
            HibernateAction.getInstance().rollbackTransaction(transaction);
            ex.printStackTrace();
        } finally {
            HibernateAction.getInstance().closeSession(session);
        }
    }

    public void delete(String id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                transaction = session.beginTransaction();
                T result = find(id);
                session.delete(result);
                HibernateAction.getInstance().commitTransaction(transaction);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            HibernateAction.getInstance().rollbackTransaction(transaction);
        } finally {
            HibernateAction.getInstance().closeSession(session);
        }
    }

    public T find(String id) {
        Session session = null;
        T obj = null;
        try {
            session = HibernateAction.getInstance().openSession();
            obj = session.get(entityClass, id);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            HibernateAction.getInstance().closeSession(session);
        }
        return obj;
    }


//


}
