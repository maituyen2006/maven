package com.team5solution.Facades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team5solution.Entities.Category;
import com.team5solution.Entities.Product;
import com.team5solution.Entities.SalesOrderItem;
import org.hibernate.*;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

public class CategoryFacade extends AbstractFacade implements Serializable {


    public CategoryFacade() {
        super(Category.class);
    }

    @Override
    public List list() {
        Session session = null;
        List list = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                Criteria criteria = session.createCriteria(Category.class);
                criteria.createAlias("products", "categoryId", JoinType.LEFT_OUTER_JOIN);
                criteria.setFetchMode("products", FetchMode.JOIN);
                criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
                list = criteria.list();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            HibernateAction.getInstance().closeSession(session);
        }
        return list;
    }

    public Category productsByCategoryId(String id) {
        Session session = null;
        Category list = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                Criteria criteria = session.createCriteria(Category.class);
                criteria.createAlias("products", "categoryId", JoinType.LEFT_OUTER_JOIN);
                criteria.setFetchMode("products", FetchMode.JOIN);
                criteria.add(Restrictions.eq("categoryId", id));
                criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
                list = (Category) criteria.uniqueResult();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            HibernateAction.getInstance().closeSession(session);
        }
        return list;
    }

    @Override
    public Category find(String id) {
        Session session = null;
        Category category = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                Criteria criteria = session.createCriteria(Category.class);
                criteria.createAlias("products", "products", JoinType.LEFT_OUTER_JOIN);
                criteria.setFetchMode("products", FetchMode.JOIN);
                criteria.add(Restrictions.eq("categoryId", id));
                category = (Category) criteria.uniqueResult();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            HibernateAction.getInstance().closeSession(session);
        }
        return category;
    }


    public List available() {
        Session session = null;
        List list = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                Criteria criteria = session.createCriteria(Category.class);
                criteria.createAlias("products", "categoryId", JoinType.LEFT_OUTER_JOIN);
                criteria.setFetchMode("products", FetchMode.JOIN);
                criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
                criteria.add(Restrictions.eq("active", true));
                criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
                list = criteria.list();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            HibernateAction.getInstance().closeSession(session);
        }
        return list;
    }

    @Override
    public void delete(String id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                transaction = session.beginTransaction();
                String hql = "update from Category set isActive=:active where CategoryId=:id ";
                Query query = session.createQuery(hql);
                query.setParameter("active", false);
                query.setParameter("id", id);
                query.executeUpdate();
                HibernateAction.getInstance().commitTransaction(transaction);
            }
        } catch (Exception ex) {
            HibernateAction.getInstance().commitTransaction(transaction);
            ex.printStackTrace();
        } finally {
            HibernateAction.getInstance().closeSession(session);
        }
    }

}
