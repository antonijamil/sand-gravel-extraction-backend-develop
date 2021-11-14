package be.fgov.economie.sge.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="concession_holder", schema = "sand_gravel")
public class ConcessionHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "number")
    private Integer concessionHolderNumber;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "concessionHolder")
    private List<RegisterEntry> registerEntries;

}
