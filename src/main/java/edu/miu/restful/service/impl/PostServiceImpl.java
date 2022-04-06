package edu.miu.restful.service.impl;

import edu.miu.restful.entity.Comment;
import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.dto.CommentDto;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.helper.ListMapper;
import edu.miu.restful.repo.CommentRepo;
import edu.miu.restful.repo.PostRepo;
import edu.miu.restful.service.PostService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToDto;

    @Autowired
    CommentRepo commentRepo;

    public List<PostDto> findAllPosts() {
        return (List<PostDto>) listMapperPostToDto.mapList((List<Post>) postRepo.findAll(), new PostDto());
    }

//    @Override
//    public List<PostDto> findAllPostsByAuthorName(String authorName) {
//        return (List<PostDto>) listMapperPostToDto.mapList(postRepo.findAllPostsByAuthorName(authorName), new PostDto());
//    }

    @Override
    public List<PostDto> findAllPostsByTitle(String title) {
        return (List<PostDto>) listMapperPostToDto.mapList(postRepo.findAllPostsByTitle(title), new PostDto());
    }

    @Override
    public PostDto getPostById(int id) {
        return modelMapper.map(postRepo.findById((long) id), PostDto.class);
    }

    @Override
    public void savePost(PostDto p) {
        postRepo.save(modelMapper.map(p, Post.class));
    }

    @Override
    public void deletePost(int id) {
        postRepo.deleteById((long) id);
    }

    @Override
    public void updatePost(int id, PostDto p) {
        postRepo.save(modelMapper.map(p, Post.class));
    }

    @Override
    public void addComment(long postId, CommentDto cDto) {
        var fetchedPost = postRepo.findById(postId).get();
        var comment = modelMapper.map(cDto, Comment.class);
        comment.setPost(fetchedPost);
        commentRepo.save(comment);
    }

}
