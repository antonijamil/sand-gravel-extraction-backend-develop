package be.fgov.economie.sge.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="ship", schema = "sand_gravel")
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "imo")
    private Integer imo;
    @Column(name = "name")
    private String name;
    @Column(name = "hopper_volume")
    private Integer hopperVolume;

    @OneToMany(mappedBy = "ship")
    private List<RegisterEntry> registerEntries;

    /*public void setId(Long id) {
        this.id = id;
    }

    public void setImo(Long imo) {
        this.imo = imo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHopperVolume(Long hopperVolume) {
        this.hopperVolume = hopperVolume;
    }

    public Long getId() {
        return id;
    }

    public Long getImo() {
        return imo;
    }

    public String getName() {
        return name;
    }

    public Long getHopperVolume() {
        return hopperVolume;
    }*/
}
