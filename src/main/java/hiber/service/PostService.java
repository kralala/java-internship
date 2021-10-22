package hiber.service;

import hiber.model.Post;
import hiber.model.User;
import hiber.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    @Autowired
    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public Post findById(UUID id) {
        return postRepository.getById(id);
    }

    public Post createPost(String body, UUID id) {
        User user  = userService.findById(id);
        Post post = new Post(body, user);
        return post;
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public void deletePostById(UUID id) {
        postRepository.deleteById(id);
    }

}
