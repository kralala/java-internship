package hiber.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "schools")
@Getter
@Setter
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "name")
    private int name;

    @Column(name = "address")
    private String address;

    public School(int name, String address) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.address = address;
    }
}
