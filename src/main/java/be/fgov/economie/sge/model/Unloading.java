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

    /*public void setId(Long id) {
        this.id = id;
    }

    public void setUnloadedVolume(Long unloadedVolume) {
        this.unloadedVolume = unloadedVolume;
    }

    public void setUnloadingPlace(String unloadingPlace) {
        this.unloadingPlace = unloadingPlace;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRegisterEntry(RegisterEntry registerEntry) {
        this.registerEntry = registerEntry;
    }

    public Long getId() {
        return id;
    }

    public Long getUnloadedVolume() {
        return unloadedVolume;
    }

    public String getUnloadingPlace() {
        return unloadingPlace;
    }

    public String getDestination() {
        return destination;
    }

    public String getCountry() {
        return country;
    }

    public RegisterEntry getRegisterEntry() {
        return registerEntry;
    }*/
}
