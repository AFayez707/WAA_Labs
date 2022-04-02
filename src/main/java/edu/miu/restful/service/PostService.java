package edu.miu.restful.service;

import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.entity.dto.PostDto;

import java.util.List;

public interface PostService {
    public List<PostDto> findAllPosts();

    public List<PostDto> findAllPostsByAuthorName(String authorName);

    public PostDto getPostById(int id);

    public void savePost(PostDto p);

    public void deletePost(int id);

    public void updatePost(int id, PostDto p);
}
