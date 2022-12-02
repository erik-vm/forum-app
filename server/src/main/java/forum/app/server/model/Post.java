package forum.app.server.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.EnumType.*;

@Entity
@Data
@Setter
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    private Thread thread;
    @Enumerated(STRING)
    private Category category;
    private String body;
    private String imageUrl;
    private boolean isPublic;
}
