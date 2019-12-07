package com.team5solution.Facades;

import com.team5solution.Entities.Account;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Repository
@Transactional
public class AccountFacade extends AbstractFacade implements Serializable {

    public AccountFacade() {
        super(Account.class);
    }


    @Override
    public List list() {
        Session session = null;
        List list = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                Criteria criteria = session.createCriteria(Account.class);
                criteria.createAlias("orders", "orders", JoinType.LEFT_OUTER_JOIN);
                criteria.setFetchMode("orders", FetchMode.JOIN);
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

    public List active() {
        Session session = null;
        List list = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                Criteria criteria = session.createCriteria(Account.class);
                criteria.add(Restrictions.eq("deleted", false));
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

    public Account getAccountById(String id) {
        Session session = null;
        Account account = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                Criteria criteria = session.createCriteria(Account.class);
                criteria.createAlias("orders", "orders", JoinType.LEFT_OUTER_JOIN);
                criteria.setFetchMode("orders", FetchMode.JOIN);
                criteria.add(Restrictions.eq("accountId", id));
                criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
                account = (Account) criteria.uniqueResult();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            HibernateAction.getInstance().closeSession(session);
        }
        return account;
    }

    public Account getByUsername(String username) {
        Session session = null;
        Account account = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                Criteria criteria = session.createCriteria(Account.class);
                criteria.add(Restrictions.eq("username", username));
                account = (Account) criteria.uniqueResult();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            HibernateAction.getInstance().closeSession(session);
        }
        return account;
    }


    public boolean isAdmin(String id) {
        Session session = null;
        Account obj = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                String hql = "From Account A where A.accountId=:id";
                Query query = session.createQuery(hql).setParameter("id", id);

                obj = (Account) query.uniqueResult();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            HibernateAction.getInstance().closeSession(session);
        }
        return obj.getRole();
    }

    public Account create(Account account) throws Exception {
        Session session = null;
        Transaction transaction = null;
        Account account1 = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                Account acc = new AccountFacade().getByUsername(account.getUsername());
                transaction = session.beginTransaction();
                if (acc == null) {
                    Serializable id = session.save(account);
                    session.flush();
                    account1 = session.get(Account.class, id);
                } else {
                    account1 = null;
                }
                HibernateAction.getInstance().commitTransaction(transaction);
            }
        } catch (Exception ex) {
            HibernateAction.getInstance().rollbackTransaction(transaction);
            ex.printStackTrace();
        } finally {
            HibernateAction.getInstance().closeSession(session);
        }
        return account1;
    }

    public String getAccountCartJsonById(String id) {
        Session session = null;
        String account = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                String hql = "select A.cartJson From Account A where A.accountId=:id";
                Query query = session.createQuery(hql);
                query.setParameter("id", id);
                account = (String) query.uniqueResult();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            HibernateAction.getInstance().closeSession(session);
        }
        return account;
    }

    public void block(String id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                transaction = session.beginTransaction();
                String hql = "Update Account set isActive=:active where Account_Id=:id";
                Query query = session.createQuery(hql);
                query.setParameter("id", id);
                query.setParameter("active", false);
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

    public void unlock(String id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                transaction = session.beginTransaction();
                String hql = "Update Account set isActive=:active where Account_Id=:id";
                Query query = session.createQuery(hql);
                query.setParameter("id", id);
                query.setParameter("active", true);
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


    @Override
    public void delete(String id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateAction.getInstance().openSession();
            if (session != null) {
                transaction = session.beginTransaction();
                String hql = "update Account set isDeleted=:deleted where Account_Id=:id";
                Query query = session.createQuery(hql);
                query.setParameter("id", id);
                query.setParameter("deleted", true);
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
