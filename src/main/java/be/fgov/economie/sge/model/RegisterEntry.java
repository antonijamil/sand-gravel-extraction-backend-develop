package be.fgov.economie.sge.model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Data
@Entity
//@NamedEntityGraph(name = "graph.RegisterEntryUnloading", attributeNodes = @NamedAttributeNode(value = "unloadings"))
@NoArgsConstructor
@Table(name="register_entry", schema = "sand_gravel")
public class RegisterEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "trip_number")
    private Long tripNumber;
    @Column(name = "start_date_time")
    private LocalDateTime startDateTime;
    @Column(name = "stop_date_time")
    private LocalDateTime stopDateTime;
    @Column(name = "quantity")
    private Integer loadedQuantity;
    @Column(name = "deviant_volume")
    private String deviantVolume;

    @ManyToOne
    @JoinColumn(name = "captain_id")
    private Captain captain;

    @ManyToOne
    @JoinColumn(name = "concession_holder_id")
    private ConcessionHolder concessionHolder;

    @ManyToOne
    @JoinColumn(name = "loading_site_id")
    private LoadingSite loadingSite;

    @ManyToOne
    @JoinColumn(name = "ship_id")
    private Ship ship;

    @OneToMany (mappedBy = "registerEntry", cascade = CascadeType.ALL)
    private List<Unloading> unloadings;





    /*public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTripNumber(Long tripNumber) {
        this.tripNumber = tripNumber;
    }

    public Long getTripNumber() {
        return tripNumber;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStopTime(Time stopTime) {
        this.stopTime = stopTime;
    }

    public Time getStopTime() {
        return stopTime;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setDeviantVolume(String deviantVolume) {
        this.deviantVolume = deviantVolume;
    }

    public String getDeviantVolume() {
        return deviantVolume;
    }

    public void setCaptain(Captain captain) {
        this.captain = captain;
    }

    public Captain getCaptain() {
        return captain;
    }

    public void setConcessionHolder(ConcessionHolder concessionHolder) {
        this.concessionHolder = concessionHolder;
    }

    public ConcessionHolder getConcessionHolder() {
        return concessionHolder;
    }

    public void setLoadingSiteID(LoadingSite loadingSiteID) {
        this.loadingSite = loadingSite;
    }

    public LoadingSite getLoadingSiteID() {
        return loadingSite;
    }
*/
}
