package forum.app.server.controller;

import forum.app.server.exception.PostNotFoundException;
import forum.app.server.model.Post;
import forum.app.server.model.Thread;
import forum.app.server.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PutMapping("/")
    Post savePost(@RequestBody Post post){
        return postService.savePost(post);
    }

    @PostMapping
    List<Post> findPostByThread(@RequestBody Thread thread) throws PostNotFoundException {
        return postService.findAllByThread(thread);
    }

    @PostMapping("/id:{id}")
    Post findPostById(@PathVariable("id") Integer id) throws PostNotFoundException{
        return postService.findPostById(id);
    };
}
