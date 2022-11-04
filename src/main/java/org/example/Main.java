package org.example;

import org.example.configurations.HibernateUtils;
import org.example.entities.Bus;
import org.example.entities.Station;
import org.example.repositories.BusRepository;
import org.example.repositories.Itineraries;
import org.example.repositories.ItinerariesRepositories;
import org.example.repositories.StationRepository;
import org.hibernate.Session;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        BusRepository busRepository = new BusRepository(session);
        StationRepository stationRepository = new StationRepository(session);
//        Bus bus = new Bus("Bus 1", true);
//        busRepository.save(bus);
//
//        Station station = null;
//        if (bus == null) {
//
//            System.out.printf("Nuk ka autobus me kete emer");
//        } else {
//            station = new Station("Station 1");
//            stationRepository.save(station);
//            bus.setStation(station);
//            busRepository.update(bus);
//
//        }
        ItinerariesRepositories itinerariesRepositories= new ItinerariesRepositories(session);
        Itineraries itineraries= new Itineraries();
        itineraries.setName("Tirane-Paris");
        itineraries.setStartLocation("Tirane");
        itineraries.setDestination("Paris");
        itineraries.setStartTime(LocalDateTime.of(2022,11,4,11,30,30));
        itineraries.setEndTime(LocalDateTime.of(2022, 11, 4, 13,30,30));
        List<Bus> buses= busRepository.findAll();
        List<Bus> itineraryBuses= new ArrayList<>();
        buses.forEach(bus -> {

            if (bus.getStatus()&& itineraryBuses.size()<2){
                itineraryBuses.add(bus);
            }

        itineraries.setBuses(itineraryBuses);
         itinerariesRepositories.save(itineraries);
            System.out.println(itineraries);



        });
    }}