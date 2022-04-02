package edu.miu.restful.repo;

import edu.miu.restful.entity.UserModel;
import edu.miu.restful.entity.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UserModel, Long> {
}
