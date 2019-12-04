package com.team5solution.Facades;


import com.team5solution.Entities.Product;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class ProductFacade extends AbstractFacade implements Serializable {

    public ProductFacade() {
        super(Product.class);
    }


    @Override
    public List list() {
        Session session = null;
        List list = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                Criteria criteria = session.createCriteria(Product.class);
                criteria.createAlias("categoryId", "CategoryId", JoinType.LEFT_OUTER_JOIN);
                criteria.setFetchMode("categoryId", FetchMode.JOIN);
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

    public List find(String id) {
        Session session = null;
        List product = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                Criteria criteria = session.createCriteria(Product.class);
                criteria.createAlias("categoryId", "CategoryId", JoinType.LEFT_OUTER_JOIN);
                criteria.setFetchMode("categoryId", FetchMode.JOIN);
                criteria.add(Restrictions.eq("productId", id));
                criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
                product = criteria.list();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return product;
    }

    public List Available() {
        Session session = null;
        List list = null;
        try {
            session = HibernateAction.getInstance().openSession();
            Criteria criteria = session.createCriteria(Product.class);
            criteria.add(Restrictions.eq("productStatus", true));
            list = criteria.list();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            HibernateAction.getInstance().closeSession(session);
        }
        return list;
    }


    public List findByName(String name) {
        Session session = null;
        List list = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                Criteria criteria = session.createCriteria(Product.class);
                criteria.add(Restrictions.eq("name", name));
                list = criteria.list();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            HibernateAction.getInstance().closeSession(session);
        }
        return list;
    }

    public void delete(String id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                transaction = session.beginTransaction();
                String hql = "update Product set ProductStatus=:status where ProductId=:id";
                Query query = session.createQuery(hql);
                query.setParameter("id", id);
                query.setParameter("status", false);
                query.executeUpdate();
                HibernateAction.getInstance().commitTransaction(transaction);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            HibernateAction.getInstance().rollbackTransaction(transaction);
        } finally {
            HibernateAction.getInstance().closeSession(session);
        }
    }
}
