package forum.app.server.service.implementation;

import forum.app.server.exception.PostNotFoundException;
import forum.app.server.model.Post;
import forum.app.server.model.Thread;
import forum.app.server.repository.PostRepository;
import forum.app.server.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImp implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post findPostById(Integer id) throws PostNotFoundException {
        Optional<Post> postOptional = postRepository.findById(id);
        if (postOptional.isEmpty()){
            throw new PostNotFoundException(id);
        }
        return postOptional.get();
    }

    @Override
    public List<Post> findAllByThread(Thread thread) throws PostNotFoundException {
        if (postRepository.findAllByThread(thread).isEmpty()){
            throw new PostNotFoundException(thread.getId());
        }
        return postRepository.findAllByThread(thread);
    }
}
