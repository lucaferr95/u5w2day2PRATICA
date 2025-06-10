package it.epicode.u5w2day2PRATICA.Service;


import it.epicode.u5w2day2PRATICA.Model.BlogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {
    private List<BlogPost> postList = new ArrayList<>();

    public BlogPost savePost(BlogPost post) {
        post.setId(new Random().nextInt(1, 10000));

        if (post.getCover() == null || post.getCover().isBlank()) {
            post.setCover("https://picsum.photos/200/300");
        }

        postList.add(post);
        return post;
    }

    public List<BlogPost> getAllPosts() {
        return postList;
    }
}