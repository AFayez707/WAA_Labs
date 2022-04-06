package edu.miu.restful.service.impl;

import edu.miu.restful.entity.Logger;
import edu.miu.restful.repo.LoggerRepo;
import edu.miu.restful.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerServiceImpl implements LoggerService {

    @Autowired
    private LoggerRepo loggerRepo;

    @Override
    public void save(Logger logger) {
        loggerRepo.save(logger);
    }
}
