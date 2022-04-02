package edu.miu.restful.service.impl;

import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.UserModel;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.entity.dto.UserDto;
import edu.miu.restful.helper.ListMapper;
import edu.miu.restful.repo.UserRepo;
import edu.miu.restful.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ListMapper<UserModel, UserDto> listMapperUserToDto;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToDto;

    @Override
    public List<UserDto> findAll() {
        return (List<UserDto>) listMapperUserToDto.mapList((List<UserModel>) userRepo.findAll(), new UserDto());
    }

    @Override
    public void save(UserDto u) {
        userRepo.save(modelMapper.map(u, UserModel.class));
    }

    @Override
    public void delete(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void update(long id, UserDto u) {
        // Todo to implement update
        userRepo.save(modelMapper.map(u, UserModel.class));
    }

    @Override
    public UserDto getUserById(long id) {
        return modelMapper.map(userRepo.findById(id).get(), UserDto.class);
    }

    @Override
    public List<PostDto> getPostsByUserId(long id) {
        return (List<PostDto>) listMapperPostToDto.mapList(userRepo.findById(id).get().getPosts(), new PostDto());
    }
}
