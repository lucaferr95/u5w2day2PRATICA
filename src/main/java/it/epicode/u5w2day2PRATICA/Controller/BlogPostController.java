package it.epicode.u5w2day2PRATICA.Controller;

import it.epicode.u5w2day2PRATICA.Exception.NotFoundException;
import it.epicode.u5w2day2PRATICA.Model.BlogPost;
import it.epicode.u5w2day2PRATICA.Service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogposts")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost saveBlogPost(@RequestBody BlogPost blogPost) {
        return blogPostService.saveBlogPost(blogPost);
    }

    @GetMapping
    public List<BlogPost> getAllBlogPosts() {
        return blogPostService.getBlogPosts();
    }

    @GetMapping("/{id}")
    public BlogPost getBlogPost(@PathVariable int id) throws NotFoundException {
        return blogPostService.getBlogPost(id);
    }

    @PutMapping("/{id}")
    public BlogPost updateBlogPost(@PathVariable int id, @RequestBody BlogPost blogPost) throws NotFoundException {
        return blogPostService.updateBlogPost(id, blogPost);
    }

    @DeleteMapping("/{id}")
    public void deleteBlogPost(@PathVariable int id) throws NotFoundException {
        blogPostService.deleteBlogPost(id);
    }
}
