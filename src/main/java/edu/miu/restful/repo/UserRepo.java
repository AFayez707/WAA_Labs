package edu.miu.restful.repo;

import edu.miu.restful.entity.UserModel;
import edu.miu.restful.entity.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<UserModel, Long> {

    @Query(value = "SELECT u from UserModel u where u.posts.size > :numOfPosts")
    List<UserModel> getUsersWithPostsMoreThan(int numOfPosts);

}
