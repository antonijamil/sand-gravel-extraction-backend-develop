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
//@NamedEntityGraph(name = "graph.RegisterEntryUnloading", attributeNodes = @NamedAttributeNode(value = "unloadings"))

@Data
@Entity
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
    @JoinColumn(name = "user_id")
    private User user;

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

}
