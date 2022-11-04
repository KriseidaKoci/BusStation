package org.example.entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Station {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column // krijon nje kolone te re, mund edhe mos ta bejme
private Long stationId;
@Column (name="station_name", nullable = false,length = 20)
private String name;

@OneToMany (mappedBy = "station")// station eshte emri i objektit dhe jo i kolones qe beme join
    List<Bus> buses;

public Station (){};

    public Station(Long stationId, String name) {
        this.stationId = stationId;
        this.name = name;
    }

    public Station(String s) {
    }

    public Long getStationId() {
        return stationId;
    }

    public String getName() {
        return name;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationId=" + stationId +
                ", name='" + name + '\'' +
                '}';
    }
}
