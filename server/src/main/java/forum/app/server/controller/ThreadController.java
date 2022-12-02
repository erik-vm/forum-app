package forum.app.server.controller;

import forum.app.server.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thread")
public class ThreadController {

    @Autowired
    private ThreadService threadService;
}
