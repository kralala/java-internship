package hiber.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "body")
    private String body;

    @ManyToOne
    @Column(name = "user_id")
    private User user;

    public Post(String body, User user) {
        this.id = UUID.randomUUID();
        this.body = body;
        this.user = user;
    }
}
