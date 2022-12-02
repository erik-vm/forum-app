package forum.app.server.repository;

import forum.app.server.model.Post;
import forum.app.server.model.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findAllByThread(Thread thread);
}
