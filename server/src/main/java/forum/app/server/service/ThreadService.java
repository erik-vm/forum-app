package forum.app.server.service;

import forum.app.server.exception.ThreadNotFoundException;
import forum.app.server.exception.ThreadTitleExistsException;
import forum.app.server.model.Thread;

import java.util.List;

public interface ThreadService {

    Thread saveThread(Thread thread) throws ThreadNotFoundException, ThreadTitleExistsException;

    Thread findThreadById(Integer id) throws ThreadNotFoundException;

    List<Thread> findAllThreads() throws ThreadNotFoundException;
}
