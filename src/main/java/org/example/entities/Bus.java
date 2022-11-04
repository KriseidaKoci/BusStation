package org.example.entities;
import jakarta.persistence.*;

@Entity
@Table(name="roi_bus")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long busId;
    private String name;
    private Boolean status;
    @ManyToOne
    @JoinColumn(name="station")

    private Station station;

    public Long getBusId() {
        return busId;
    }

    public String getName() {
        return name;
    }

    public Boolean getStatus() {
        return status;
    }

    public Station getStation() {
        return station;
    }

    public void setBusId(Long busId) {
        this.busId = busId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setStation(Station station) {
        this.station = station;
    }


    public  Bus (String name, Boolean status){

        this.name=name;
        this.status=status;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "busId=" + busId +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", station=" + station +
                '}';
    }

    public Bus (){}
}
