package edu.miu.restful.service.impl;

import edu.miu.restful.entity.Comment;
import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.dto.CommentDto;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.helper.ListMapper;
import edu.miu.restful.repo.CommentRepo;
import edu.miu.restful.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Comment, CommentDto> listMapperCommentToDto;

    @Override
    public List<CommentDto> findAll() {
        return (List<CommentDto>) listMapperCommentToDto.mapList((List<Comment>) commentRepo.findAll(), new CommentDto());
    }

    @Override
    public CommentDto findCommentById(long id) {
        return modelMapper.map(commentRepo.findById(id), CommentDto.class);
    }

    @Override
    public void save(CommentDto comment) {
        commentRepo.save(modelMapper.map(comment, Comment.class));
    }

    @Override
    public void update(CommentDto comment, long id) {
        commentRepo.save(modelMapper.map(comment, Comment.class));
    }

    @Override
    public void delete(long commentId) {
        commentRepo.deleteById(commentId);
    }


}
