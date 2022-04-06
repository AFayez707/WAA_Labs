package edu.miu.restful.repo;

import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.Product;
import edu.miu.restful.entity.Review;
import edu.miu.restful.entity.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {
//    public List<Post> findAllPosts();
//
//    public Post getPostById(int id);
//
//    public void savePost(Post p);
//
//    public void deletePost(int id);
//
//    public void updatePost(int id, Post p);

//    public List<Post> findAllPostsByAuthorName(String authorName);

    @Query(value = "SELECT p FROM Post p WHERE p.title = :title")
    public List<Post> findAllPostsByTitle(String title);
}
