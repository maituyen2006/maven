package com.team5solution.Facades;

import com.team5solution.Entities.Account;
import com.team5solution.Entities.SalesOrder;
import com.team5solution.Entities.SalesOrderItem;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Component
public class SalesOrderFacade extends AbstractFacade implements Serializable {

    @Autowired
    ProductFacade productDTO;

    public SalesOrderFacade() {
        super(SalesOrder.class);
    }

    @Override
    public List list() {
        Session session = null;
        List list = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                Criteria criteria = session.createCriteria(SalesOrder.class);
                criteria.createAlias("accountId", "accountId", JoinType.LEFT_OUTER_JOIN);
                criteria.createAlias("detailId", "detailId", JoinType.LEFT_OUTER_JOIN);
                criteria.createAlias("items", "items", JoinType.LEFT_OUTER_JOIN);
                criteria.setFetchMode("accountId", FetchMode.JOIN);
                criteria.setFetchMode("detailId", FetchMode.JOIN);
                criteria.setFetchMode("items", FetchMode.JOIN);
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

//    public SalesOrderItem insertItem(){
//
//    }


    public SalesOrder getDetailSalesOrderById(String id) {
        Session session = null;
        SalesOrder list = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                Criteria criteria = session.createCriteria(SalesOrder.class);
                criteria.createAlias("accountId", "Account_Id", JoinType.LEFT_OUTER_JOIN);
                criteria.createAlias("detailId", "Detail_Id", JoinType.LEFT_OUTER_JOIN);
                criteria.createAlias("items", "orderId", JoinType.LEFT_OUTER_JOIN);
                criteria.setFetchMode("accountId", FetchMode.JOIN);
                criteria.setFetchMode("detailId", FetchMode.JOIN);
                criteria.setFetchMode("items", FetchMode.JOIN);
                criteria.add(Restrictions.eq("orderId", id));
                list = (SalesOrder) criteria.uniqueResult();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            HibernateAction.getInstance().closeSession(session);
        }
        return list;
    }


    public SalesOrder find(String id) {
        Session session = null;
        SalesOrder order = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                Criteria criteria = session.createCriteria(SalesOrder.class);
                criteria.createAlias("accountId", "accountId", JoinType.LEFT_OUTER_JOIN);
                criteria.createAlias("detailId", "detailId", JoinType.LEFT_OUTER_JOIN);
                criteria.createAlias("products", "productId", JoinType.LEFT_OUTER_JOIN);
                criteria.setFetchMode("accountId", FetchMode.JOIN);
                criteria.setFetchMode("detailId", FetchMode.JOIN);
                criteria.setFetchMode("products", FetchMode.JOIN);
                criteria.add(Restrictions.eq("orderId", id));
                criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
                order = (SalesOrder) criteria.uniqueResult();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            HibernateAction.getInstance().closeSession(session);
        }
        return order;
    }

//    public void saveOrder(Product product,  Account account){
//        Session session=null;
//        SalesOrder order=new SalesOrder();
//
//        Product prod=new Product();
//        Account acc=new Account();
//
//        try {
//            session=HibernateAction.getInstance().openSession();
//            if(session!=null){
//
//                acc.setLastName(account.getLastName());
//                acc.setFirstName(account.getFirstName());
//                acc.setAccountId(account.getAccountId());
//
//                order.setCreatedOn(new Date(System.currentTimeMillis()));
//                order.setCreatedBy(acc.getLastName()+" "+acc.getFirstName());
//                order.setAccountId(acc);
//                order.setProductId(prod);
//            }
//        }
//    }


    public void delete(String id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                transaction = session.beginTransaction();
                String hql = "Delete From SalesOrder where OrderId=:id";
                Query query = session.createQuery(hql);
                query.setParameter("id", id);
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
