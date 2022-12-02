package forum.app.server.service.implementation;

import forum.app.server.model.Post;
import forum.app.server.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements PostService {
    @Override
    public Post savePost(Post post) {
        return null;
    }

    @Override
    public Post findPostById(Integer id) {
        return null;
    }
}
