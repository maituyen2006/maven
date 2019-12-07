package com.team5solution.Facades;

import com.team5solution.Entities.Comment;
import com.team5solution.Entities.Product;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import java.util.List;

public class CommentFacade extends AbstractFacade {

    public CommentFacade() {
        super(Comment.class);
    }

    @Override
    public List list() {
        Session session = null;
        List list = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                Criteria criteria = session.createCriteria(Comment.class);
                criteria.setFetchMode("account", FetchMode.JOIN);
                criteria.setFetchMode("product", FetchMode.JOIN);
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

    public List commentsByProduct(String id) {
        Session session = null;
        List list = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                Criteria criteria = session.createCriteria(Product.class);
                criteria.createAlias("comments", "comment", JoinType.LEFT_OUTER_JOIN);
                criteria.setFetchMode("comments", FetchMode.JOIN);
                criteria.add(Restrictions.eq("productId", id));
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


    public void delete(String id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                transaction = session.beginTransaction();
                String hql = "Delete From Comment where CommentId=:id";
                Query query = session.createQuery(hql).setParameter("id", id);
                query.executeUpdate();
                HibernateAction.getInstance().commitTransaction(transaction);
            }
        } catch (Exception ex) {
            HibernateAction.getInstance().rollbackTransaction(transaction);
            ex.printStackTrace();
        } finally {
            HibernateAction.getInstance().closeSession(session);
        }
    }


}
