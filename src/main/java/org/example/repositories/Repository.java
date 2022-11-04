package org.example.repositories;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Repository <T> {

    private final Session session;
    private final Class<? extends T> aClass;

    public Repository(Session session, Class<? extends T> aClass) {
        this.session = session;
        this.aClass = aClass;
    }

    public T findbyId(Long Id) {             // kerkon ne tabele ne baze te id
        return session.get(aClass, Id);

    }

    public T save(T obj) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(obj); // mundohemi ta ruajme ne databaze
            transaction.commit();
            return obj;
        } catch (Exception e) {
            if (transaction != null)
          e.printStackTrace();
          transaction.rollback();
        }


        return null;
    }
    public T update (T obj){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(obj);
            transaction.commit();
            return obj;
        } catch (Exception e) {
            if (transaction != null)
                e.printStackTrace();
            transaction.rollback();
        }

        return null;
    }



    public void delete(T obj){
        session.remove(obj);
    }

}
