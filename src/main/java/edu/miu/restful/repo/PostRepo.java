package edu.miu.restful.repo;

import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.Product;
import edu.miu.restful.entity.Review;
import edu.miu.restful.entity.Post;

import java.util.List;

public interface PostRepo {
    public List<Post> findAllPosts();

    public Post getPostById(int id);

    public void savePost(Post p);

    public void deletePost(int id);

    public void updatePost(int id, Post p);

    public List<Post> findAllPostsByAuthorName(String authorName);
}
