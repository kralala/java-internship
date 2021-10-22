package hiber.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;

import java.util.UUID;

@Data
@Entity
@Table(name = "posts")
@NoArgsConstructor
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id)
    private UUID id;

    @Column(name = "body")
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Post(String body, User user) {
        this.id = UUID.randomUUID();
        this.body = body;
        this.user = user;
    }
}
