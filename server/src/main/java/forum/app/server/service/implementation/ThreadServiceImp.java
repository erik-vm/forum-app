package forum.app.server.service.implementation;

import forum.app.server.model.Thread;
import forum.app.server.service.ThreadService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ThreadServiceImp implements ThreadService {
    @Override
    public Thread saveThread(Thread thread) {
        return null;
    }

    @Override
    public Thread findThreadById(Integer id) {
        return null;
    }

    @Override
    public Thread findThreadByTitle(String title) {
        return null;
    }

    @Override
    public List<Thread> findAllThreads() {
        return null;
    }
}
