package it.epicode.u5w2day2PRATICA.Service;

import it.epicode.u5w2day2PRATICA.Exception.NotFoundException;
import it.epicode.u5w2day2PRATICA.Model.BlogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {
    private List<BlogPost> blogPosts = new ArrayList<>();

    public BlogPost saveBlogPost(BlogPost post) {
        post.setId(new Random().nextInt(1, 10000));
        post.setCover("https://picsum.photos/200/300");
        blogPosts.add(post);
        return post;
    }


    public List<BlogPost> getBlogPosts() {
        return blogPosts;
    }

    public BlogPost getBlogPost(int id) throws NotFoundException {
        return blogPosts.stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("BlogPost con id: " + id + " non trovato"));
    }

    public BlogPost updateBlogPost(int id, BlogPost updatedPost) throws NotFoundException {
        BlogPost postToUpdate = getBlogPost(id);

        postToUpdate.setTitolo(updatedPost.getTitolo());
        postToUpdate.setCategoria(updatedPost.getCategoria());
        postToUpdate.setCover(updatedPost.getCover());
        postToUpdate.setContenuto(updatedPost.getContenuto());
        postToUpdate.setTempoDiLettura(updatedPost.getTempoDiLettura());
        postToUpdate.setCover("https://picsum.photos/200/300");

        return postToUpdate;
    }

    public void deleteBlogPost(int id) throws NotFoundException {
        BlogPost postToRemove = getBlogPost(id);
        blogPosts.remove(postToRemove);
    }
}
