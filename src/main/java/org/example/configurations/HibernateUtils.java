package org.example.configurations;

import org.example.entities.Bus;
import org.example.entities.Station;
import org.example.repositories.Itineraries;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            Configuration configuration=new Configuration();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            configuration.addAnnotatedClass(Station.class);
            configuration.addAnnotatedClass(Bus.class);
            configuration.addAnnotatedClass(Itineraries.class);
            sessionFactory=configuration.buildSessionFactory(serviceRegistry);


        }
        return sessionFactory;
    }
}