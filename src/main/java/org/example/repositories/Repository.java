package org.example.repositories;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Repository <T> { // klasa repository ka vetem konstruktor me parametra

    final Session session;
    private final Class<? extends T> aClass;

    public Repository(Session session, Class<? extends T> aClass) {
        this.session = session;
        this.aClass = aClass;
    }

    public T findbyId(Long Id) {             // kerkon ne tabele ne baze te id
        return session.get(aClass, Id);

    }

    public T save(T obj) {
        Transaction transaction = null;// per aq kohe sa nuk  kemi asnje transaksion ne progres
        try {
            transaction = session.beginTransaction();// fillojme nje transaksion te ri
            session.persist(obj); // mundohemi ta ruajme objektin ne databaze
            transaction.commit();// e ruajme me sukses
            return obj;
        } catch (Exception e) {
            if (transaction != null) //nqs transaksioni nuk eshte bosh, pra po kryhet dicja tjeter bejm rollback
          e.printStackTrace();
          transaction.rollback();
        }


        return null;
    }
    public T update (T obj){
        // update eshte identike si save por duhet te kontrolloje qe id qe po updaton duhet te ekzistoje,
        // perndryshe e ruan objektin me nje id te autogjeneruar

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
