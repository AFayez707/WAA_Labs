package edu.miu.restful.repo.impl;

import edu.miu.restful.entity.Post;
import edu.miu.restful.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo {
    private static List<Post> posts;
    private static int nextPostId = 1;

    static {
        posts = new ArrayList<>();

        Post post1 = new Post(nextPostId++, "Post 1", "Content of Post 1", "Author of Post 1");
        Post post2 = new Post(nextPostId++, "Post 2", "Content of Post 2", "Author of Post 2");

        posts.add(post1);
        posts.add(post2);
    }

    @Override
    public List<Post> findAllPosts() {
        return posts;
    }

    @Override
    public Post getPostById(int id) {
        return posts
                .stream()
                .filter(post -> post.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void savePost(Post p) {
        p.setId(nextPostId++);
        posts.add(p);
    }

    @Override
    public void deletePost(int id) {
        var post = posts.stream().filter(p -> p.getId() == id).findFirst().get();
        posts.remove(post);
    }

    @Override
    public void updatePost(int id, Post p) {
        Post postToBeUpdated = getPostById(id);

        postToBeUpdated.setAuthor(p.getAuthor());
        postToBeUpdated.setContent(p.getContent());
        postToBeUpdated.setTitle(p.getTitle());
    }

    @Override
    public List<Post> findAllPostsByAuthorName(String authorName) {
        return (List<Post>) posts
                .stream()
                .filter(post -> post.getAuthor().toLowerCase().equals(authorName.toLowerCase()))
                .collect(Collectors.toList());
    }
}
