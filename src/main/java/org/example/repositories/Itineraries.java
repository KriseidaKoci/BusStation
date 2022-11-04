package org.example.repositories;
import jakarta.persistence.*;
import org.example.entities.Bus;
import java.time.LocalDateTime;
import java.util.List;

@Entity

public class Itineraries {
    public void setItId(Long itId) {
        this.itId = itId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }

    public Long getItId() {
        return itId;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public String getDestination() {
        return destination;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long itId;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String startLocation;
    private String destination;
    @ManyToMany()
    @JoinTable (name="bus itineraries ",
    joinColumns = {
            @JoinColumn(name="bus")},
            inverseJoinColumns = {
            @JoinColumn(name="itinerary")})

    List<Bus> buses;


}
