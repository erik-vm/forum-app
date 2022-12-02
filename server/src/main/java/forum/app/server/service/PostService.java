package forum.app.server.service;

import forum.app.server.exception.PostContainsBannedWordsException;
import forum.app.server.exception.PostNotFoundException;
import forum.app.server.model.Post;
import forum.app.server.model.Thread;

import java.util.List;

public interface PostService {

    Post savePost(Post post) throws PostContainsBannedWordsException;
    Post findPostById(Integer id) throws PostNotFoundException;

    List<Post> findAll() throws PostNotFoundException;

    List<Post> findAllByThread(Thread thread) throws PostNotFoundException;
}
