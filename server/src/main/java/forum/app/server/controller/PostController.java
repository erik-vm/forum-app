package forum.app.server.controller;

import forum.app.server.exception.PostContainsBannedWordsException;
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

    @PostMapping("/")
    Post savePost(@RequestBody Post post) throws PostContainsBannedWordsException {
        return postService.savePost(post);
    }

    @PutMapping("/thread")
    List<Post> findPostByThread(@RequestBody Thread thread) throws PostNotFoundException {
        return postService.findAllByThread(thread);
    }

    @PutMapping("/all")
    List<Post> findAllPosts() throws PostNotFoundException {
        return postService.findAll();
    }

    @PutMapping("/id:{id}")
    Post findPostById(@PathVariable("id") Integer id) throws PostNotFoundException{
        return postService.findPostById(id);
    };
}
