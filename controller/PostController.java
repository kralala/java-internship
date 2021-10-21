package hiber.controller;

import hiber.model.Post;
import hiber.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/get_post/{id}")
    public Post findPostById(@PathVariable("id") UUID id) {
        return postService.findById(id);
    }

    @PostMapping("/create_post/{user_id}")
    public void savePostById(@PathVariable("body") String body,
                             @PathVariable("user_id") UUID id) {
        Post post = postService.createPost(body, id);
        postService.savePost(post);
    }

    @PostMapping("/delete_post/{id}")
    public void deletePostById(@PathVariable("id") UUID id) {
        postService.deletePostById(id);
    }

}
