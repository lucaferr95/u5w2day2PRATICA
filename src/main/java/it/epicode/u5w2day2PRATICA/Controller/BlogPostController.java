package it.epicode.u5w2day2PRATICA.Controller;

import it.epicode.u5w2day2PRATICA.Dto.BlogPostDto;
import it.epicode.u5w2day2PRATICA.Exception.NotFoundException;
import it.epicode.u5w2day2PRATICA.Model.BlogPost;
import it.epicode.u5w2day2PRATICA.Service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public BlogPost saveBlogPost(@RequestBody BlogPostDto blogPostDto) throws NotFoundException {
        return blogPostService.saveBlogPost(blogPostDto);
    }

    @GetMapping
    public Page<BlogPost> getAllBlogPosts(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size,
                                          @RequestParam(defaultValue = "id")String sortBy) {
        return blogPostService.GetAllBlogPosts(page, size, sortBy);
    }

    @GetMapping("/{id}")
    public BlogPost getBlogPost(@PathVariable int id) throws NotFoundException {
        return blogPostService.getBlogPost(id);
    }

    @PutMapping("/{id}")
    public BlogPost updateBlogPost(@PathVariable int id, @RequestBody BlogPostDto blogPostDto) throws NotFoundException {
        return blogPostService.updateBlogPost(id, blogPostDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBlogPost(@PathVariable int id) throws NotFoundException {
        blogPostService.deleteBlogPost(id);
    }
}
