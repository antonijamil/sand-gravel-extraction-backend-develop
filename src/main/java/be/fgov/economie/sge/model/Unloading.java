package be.fgov.economie.sge.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="unloading", schema = "sand_gravel")
public class Unloading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "destination_country")
    private String destinationCountry;
    @Column(name = "destination")
    private String destination;
    @Column(name = "unloaded_volume")
    private Long unloadedVolume;
    @Column(name = "unloading_place")
    private String unloadingPlace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "register_entry_id")
    private RegisterEntry registerEntry;

}
