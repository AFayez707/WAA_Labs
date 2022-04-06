package edu.miu.restful.controller;

import edu.miu.restful.entity.dto.CommentDto;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.entity.dto.UserDto;
import edu.miu.restful.service.UserService;
import edu.miu.restful.entity.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    // TODO

    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping
    public void save(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable long id) {
        var user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<PostDto>> gePostsByUserId(@PathVariable long id) {
        var posts = userService.getPostsByUserId(id);
        return ResponseEntity.ok(posts);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int postId, @RequestBody UserDto userDto) {
        userService.update(postId, userDto);
    }

    @GetMapping("/{id}/posts/{postId}")
    public ResponseEntity<List<CommentDto>> getCommentsByUserIdAndPostId(@PathVariable int userId, @PathVariable int postId) {
        var comments = userService.getCommentsByUserIdAndPostId(userId, postId);
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getUsersWithPostsMoreThan(@RequestParam(value = "numOfPosts", required = false) int numOfPosts) {
        var users = userService.getUsersWithPostsMoreThan(numOfPosts);
        return ResponseEntity.ok(users);
    }

}
