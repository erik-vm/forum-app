package forum.app.server.service;

import forum.app.server.model.Thread;

import java.util.List;

public interface ThreadService {

    Thread saveThread(Thread thread);
    Thread findThreadById(Integer id);
    Thread findThreadByTitle(String title);
    List<Thread> findAllThreads();
}
