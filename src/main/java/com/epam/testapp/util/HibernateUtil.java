package com.epam.testapp.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public final class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private HibernateUtil() {
    }

    private static SessionFactory buildSessionFactory() {

        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception ex) {

            throw new ExceptionInInitializerError(ex);
        }

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
