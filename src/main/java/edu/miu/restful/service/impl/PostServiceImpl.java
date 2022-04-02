package edu.miu.restful.service.impl;

import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.helper.ListMapper;
import edu.miu.restful.repo.PostRepo;
import edu.miu.restful.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToDto;

    public List<PostDto> findAllPosts() {
        return (List<PostDto>) listMapperPostToDto.mapList(postRepo.findAllPosts(), new PostDto());
    }

    @Override
    public List<PostDto> findAllPostsByAuthorName(String authorName) {
        return (List<PostDto>) listMapperPostToDto.mapList(postRepo.findAllPostsByAuthorName(authorName), new PostDto());
    }

    @Override
    public PostDto getPostById(int id) {
        return modelMapper.map(postRepo.getPostById(id), PostDto.class);
    }

    @Override
    public void savePost(PostDto p) {
        postRepo.savePost(modelMapper.map(p, Post.class));
    }

    @Override
    public void deletePost(int id) {
        postRepo.deletePost(id);
    }

    @Override
    public void updatePost(int id, PostDto p) {
        postRepo.updatePost(id, modelMapper.map(p, Post.class));
    }

}
