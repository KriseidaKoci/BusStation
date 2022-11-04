package org.example.repositories;

import org.hibernate.Session;

public class ItinerariesRepositories extends Repository<Itineraries>{
    private final Session session;
    public ItinerariesRepositories (Session session){
        super(session, Itineraries.class);
        this.session = session;
    }





}
