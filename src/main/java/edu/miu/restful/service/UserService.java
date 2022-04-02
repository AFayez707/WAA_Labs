package edu.miu.restful.service;

import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.entity.dto.UserDto;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.entity.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    void save(UserDto u);
    void delete(long id);
    void update(long id, UserDto u);
    UserDto getUserById(long id);
    List<PostDto> getPostsByUserId(long id);
}
