package forum.app.server.controller;

import forum.app.server.exception.ThreadNotFoundException;
import forum.app.server.exception.ThreadTitleExistsException;
import forum.app.server.model.Thread;
import forum.app.server.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/thread")
public class ThreadController {

    @Autowired
    private ThreadService threadService;

    @PostMapping("/")
    Thread saveThread(@RequestBody Thread thread) throws ThreadNotFoundException, ThreadTitleExistsException {
        return threadService.saveThread(thread);
    }

    @PutMapping("/all")
    List<Thread> findAllThreads() throws ThreadNotFoundException {
        return threadService.findAllThreads();
    }

    @PutMapping("/id:{id}")
    Thread findThreadById(@PathVariable("id") Integer id) throws ThreadNotFoundException {
        return threadService.findThreadById(id);
    }

    ;

    @PostMapping("/name:{title}")
    Thread findThreadByTitle(@PathVariable("title") String title) throws ThreadNotFoundException {
        return threadService.findThreadByTitle(title);
    }

    ;
}
