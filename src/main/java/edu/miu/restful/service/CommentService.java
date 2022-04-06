package edu.miu.restful.service;

import edu.miu.restful.entity.Comment;
import edu.miu.restful.entity.dto.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> findAll();
    CommentDto findCommentById(long id);
    void save(CommentDto comment);
    void update(CommentDto comment, long id);
    void delete(long commentId);
}
