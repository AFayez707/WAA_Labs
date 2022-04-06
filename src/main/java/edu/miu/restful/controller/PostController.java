package edu.miu.restful.controller;

import edu.miu.restful.entity.dto.CommentDto;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = {"http://localhost:3000"})
public class PostController {

    @Autowired
    PostService postService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(headers = "X-API-VERSION=1")
    public List<PostDto> getAllPostsV1() {
        return postService.findAllPosts();
    }

//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping(headers = "X-API-VERSION=2")
//    public List<PostDto> getAllPostsV2() {
//        return postService.findAllPosts();
//    }

//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping(headers = "X-API-VERSION=2")
//    public List<PostDto> getAll(@RequestParam(value = "filter" ,required = false) String authorName) {
//        return authorName==null?postService.findAllPosts():postService.findAllPostsByAuthorName(authorName);
//    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(headers = "X-API-VERSION=3")
    public List<PostDto> getAllWithTitle(@RequestParam(value = "title" ,required = false) String title) {
        return title==null?postService.findAllPosts():postService.findAllPostsByTitle(title);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void savePost(@RequestBody PostDto p) {
        postService.savePost(p);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable int id) {
        var post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id) {
        postService.deletePost(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updatePost(@PathVariable int id, @RequestBody PostDto p) {
        postService.updatePost(id, p);
    }

    @PostMapping("/{id}/comment")
    public void addComment(@PathVariable("id") long postId, @RequestBody CommentDto commentDto) {
        postService.addComment(postId, commentDto);
    }


}
