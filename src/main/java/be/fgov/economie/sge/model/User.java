package be.fgov.economie.sge.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Entity
@Table(name="user", schema = "sand_gravel")
public class User {

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
    private int active;
    @OneToMany(mappedBy = "user")
    private List<RegisterEntry> registerEntries;

    public User (String username, String password) {
        this.username = username;
        this.password = password;
        this.active = 1;
    }

    public User() {}

}
