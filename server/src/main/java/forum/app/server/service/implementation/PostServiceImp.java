package forum.app.server.service.implementation;

import forum.app.server.exception.PostContainsBannedWordsException;
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
    public Post savePost(Post post) throws PostContainsBannedWordsException {
        bannedWordChecker(post.getBody());
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
    public List<Post> findAll() throws PostNotFoundException {
        if (postRepository.findAll().isEmpty()){
            throw new PostNotFoundException();
        }
        return postRepository.findAll();
    }


    @Override
    public List<Post> findAllByThread(Thread thread) throws PostNotFoundException {
        if (postRepository.findAllByThread(thread).isEmpty()){
            throw new PostNotFoundException(thread.getId());
        }
        return postRepository.findAllByThread(thread);
    }

    private void bannedWordChecker(String body) throws PostContainsBannedWordsException {
        String[] bannedWords = {"shit", "fuck", "cunt", "dick"};

        for (int i = 0; i < bannedWords.length; i++){
            if (body.toLowerCase().contains(bannedWords[i])){
                throw new PostContainsBannedWordsException();
            }
        }
    }
}
