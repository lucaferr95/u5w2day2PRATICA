package it.epicode.u5w2day2PRATICA.Service;

import it.epicode.u5w2day2PRATICA.Dto.BlogPostDto;
import it.epicode.u5w2day2PRATICA.Exception.NotFoundException;
import it.epicode.u5w2day2PRATICA.Model.Autore;
import it.epicode.u5w2day2PRATICA.Model.BlogPost;
import it.epicode.u5w2day2PRATICA.Repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BlogPostService {
    @Autowired
    BlogPostRepository blogPostRepository;

    @Autowired
    private AutoreService autoreService;

    public BlogPost saveBlogPost(BlogPostDto blogPostDto) throws NotFoundException {
        Autore autore = autoreService.getAutore(blogPostDto.getAutoreId());
        BlogPost blogPost = new BlogPost();

        blogPost.setCategoria(blogPostDto.getCategoria());
        blogPost.setTitolo(blogPostDto.getTitolo());
        blogPost.setContenuto(blogPostDto.getContenuto());
        blogPost.setTempoDiLettura(blogPostDto.getTempoDiLettura());
        blogPost.setAutore(autore);
        blogPost.setCover("https://picsum.photos/200/300");

        return blogPostRepository.save(blogPost);
    }



    public Page<BlogPost> GetAllBlogPosts(int page, int size, String sortBy) {

        PageRequest pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return blogPostRepository.findAll(pageable);
    }

    public BlogPost getBlogPost(int id) throws NotFoundException {
        return blogPostRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("BlogPost con id: " + id + " non trovato"));
    }

    public BlogPost updateBlogPost(int id, BlogPostDto blogPostDto) throws NotFoundException {
        BlogPost blogPostToUpdate = getBlogPost(id);
        Autore autore = autoreService.getAutore(blogPostDto.getAutoreId());
        blogPostToUpdate.setCategoria(blogPostDto.getCategoria());
        blogPostToUpdate.setTitolo(blogPostDto.getTitolo());
        blogPostToUpdate.setContenuto(blogPostDto.getContenuto());
        blogPostToUpdate.setTempoDiLettura(blogPostDto.getTempoDiLettura());
        blogPostToUpdate.setAutore(autore);

        return blogPostRepository.save(blogPostToUpdate);
    }

    public void deleteBlogPost(int id) throws NotFoundException {
        BlogPost blogPostToRemove = getBlogPost(id);
        blogPostRepository.delete(blogPostToRemove);
    }
}
