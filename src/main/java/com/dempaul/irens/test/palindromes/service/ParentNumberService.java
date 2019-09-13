package com.dempaul.irens.test.palindromes.service;

import com.dempaul.irens.test.palindromes.dao.ParentNumberDao;
import com.dempaul.irens.test.palindromes.entity.ParentNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

@Service
public class ParentNumberService {

    @Autowired
    ParentNumberDao parentNumberDao;

    @Transactional
    public Flux<ParentNumber> findAll() {
        return Flux.fromIterable(parentNumberDao.findAll());
    }

    @Transactional
    public void save(ParentNumber parentNumber) {
        parentNumberDao.save(parentNumber);
    }
}
