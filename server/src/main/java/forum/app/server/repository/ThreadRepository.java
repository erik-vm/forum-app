package forum.app.server.repository;

import forum.app.server.model.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ThreadRepository extends JpaRepository<Thread, Integer> {

    Optional<Thread> findByTitle(String title);
}
