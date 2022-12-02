package forum.app.server.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    private Thread thread;
    private Category category;
    private String body;
    private String imageUrl;
    private boolean isPublic;
}
