package forum.app.server.service;

import forum.app.server.model.Post;

public interface PostService {

    Post savePost(Post post);
    Post findPostById(Integer id);
}
