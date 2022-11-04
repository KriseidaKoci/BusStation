package org.example.repositories;

import org.example.entities.Station;
import org.hibernate.Session;

public class StationRepository extends Repository<Station> {

    public StationRepository (Session session){
        super(session, Station.class);
    }
}
