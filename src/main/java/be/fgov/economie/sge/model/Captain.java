package be.fgov.economie.sge.model;

import lombok.Data;

import javax.persistence.*;
import be.fgov.economie.sge.model.RegisterEntry;

import java.util.List;

@Data
@Entity
@Table(name="captain", schema = "sand_gravel")
public class Captain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "captain")
    private List<RegisterEntry> registerEntries;


   /* public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }*/
}

