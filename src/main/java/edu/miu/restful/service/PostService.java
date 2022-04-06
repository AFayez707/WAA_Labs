package edu.miu.restful.service;

import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.dto.CommentDto;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.entity.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAllPosts();

//    List<PostDto> findAllPostsByAuthorName(String authorName);

    List<PostDto> findAllPostsByTitle(String title);

    PostDto getPostById(int id);

    void savePost(PostDto p);

    void deletePost(int id);

    void updatePost(int id, PostDto p);

    void addComment(long postId, CommentDto cDto);

}
