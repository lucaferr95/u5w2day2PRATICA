package it.epicode.u5w2day2PRATICA.Repository;

import it.epicode.u5w2day2PRATICA.Model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Integer> {
}
