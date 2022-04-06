package edu.miu.restful.repo;

import edu.miu.restful.entity.Logger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepo extends CrudRepository<Logger, Long> {

}