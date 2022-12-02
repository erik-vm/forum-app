package forum.app.server.service.implementation;

import forum.app.server.exception.ThreadNotFoundException;
import forum.app.server.exception.ThreadTitleExistsException;
import forum.app.server.model.Thread;
import forum.app.server.repository.ThreadRepository;
import forum.app.server.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThreadServiceImp implements ThreadService {

    @Autowired
    private ThreadRepository threadRepository;


    @Override
    public Thread saveThread(Thread thread) throws ThreadNotFoundException, ThreadTitleExistsException {
        doesTitleExist(thread.getTitle());
        return threadRepository.save(thread);
    }

    @Override
    public Thread findThreadById(Integer id) throws ThreadNotFoundException {
        Optional<Thread> threadOptional = threadRepository.findById(id);
        if (threadOptional.isEmpty()){
            throw new ThreadNotFoundException(id);
        }
        return threadOptional.get();
    }

    @Override
    public Thread findThreadByTitle(String title) throws ThreadNotFoundException {
        Optional<Thread> threadOptional = threadRepository.findByTitle(title);
        if (threadOptional.isEmpty()){
            throw new ThreadNotFoundException(title);
        }
        return threadOptional.get();
    }

    @Override
    public List<Thread> findAllThreads() throws ThreadNotFoundException {
        if (threadRepository.findAll().isEmpty()){
            throw new ThreadNotFoundException();
        }
        return threadRepository.findAll();
    }

    private void doesTitleExist(String tile) throws ThreadNotFoundException, ThreadTitleExistsException {
        for (Thread thread : findAllThreads()){
            if (thread.getTitle().equals(tile)){
                throw new ThreadTitleExistsException(tile);
            }
        }
    }
}
