package org.example.repositories;
import org.example.entities.Bus;
import org.hibernate.Session;

import org.hibernate.query.Query;
import org.hibernate.query.QueryParameter;

import java.security.PublicKey;
import java.util.List;

public class BusRepository extends Repository<Bus> {
    private final Session session;
    public BusRepository(Session session) {

        super(session, Bus.class);
        this.session=session;
    }

    public Bus findByName(String name){
try {
        String hql ="select bus from Bus bus where bus.name=: busName order by  bus.busId asc";
        Query<Bus> query=session.createQuery(hql);
        query.setParameter("busName", name);
    return query.getResultList().get(0);

    }

    catch (Exception e ){
        e.printStackTrace();
        return null;
    }

    }
 public List<Bus> findAll (){
        String hql="select b from Bus b";
        Query<Bus> query= session.createQuery(hql, Bus.class);
        return query.getResultList();

    }

}



