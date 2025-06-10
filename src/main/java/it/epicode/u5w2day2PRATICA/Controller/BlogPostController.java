package it.epicode.u5w2day2PRATICA.Controller;


import it.epicode.u5w2day2PRATICA.Model.BlogPost;
import it.epicode.u5w2day2PRATICA.Service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @PostMapping
    public BlogPost creaPost(@RequestBody BlogPost post) {
        return blogPostService.savePost(post);
    }

    @GetMapping
    public List<BlogPost> getAllPosts() {
        return blogPostService.getAllPosts();
    }
}