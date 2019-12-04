package com.team5solution.Facades;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateAction {
    private static final HibernateAction INSTANCE = new HibernateAction();

    private static SessionFactory sessionFactory = HibernateAction.INSTANCE.buildSessionFactory();

    private HibernateAction() {
    }

    public static HibernateAction getInstance() {
        return INSTANCE;
    }


    private SessionFactory buildSessionFactory() {
        try {
            if (sessionFactory == null) {
                Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
                sessionFactory = cfg.buildSessionFactory();
            }
        } catch (Throwable ex) {
            System.err.println(" Failed to create sessionFactory object." + ex);
            ex.printStackTrace();
        }
        return sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session openSession() {
        Session session = null;
        try {
            if (sessionFactory == null || sessionFactory.isClosed()) {
                sessionFactory = HibernateAction.INSTANCE.buildSessionFactory();
            }
            session = sessionFactory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }

    public void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
            sessionFactory = null;
        }
    }

    public void open() {
        if (sessionFactory == null) {
            sessionFactory = HibernateAction.INSTANCE.buildSessionFactory();
        }
    }

    public void flushSession(Session session) {
        if (session != null) {
            session.flush();
            session.clear();
        }
    }

    public void closeSession(Session session) {
        try {
            if (session != null) {
                session.close();
            }
        } catch (Exception e) {

        }
    }

    public void rollbackTransaction(Transaction tran) {
        if (tran != null) {
            try {
                tran.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void commitTransaction(Transaction tran) {
        tran.commit();
    }


}
