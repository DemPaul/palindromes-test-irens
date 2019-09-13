package com.dempaul.irens.test.palindromes.dao;

import com.dempaul.irens.test.palindromes.entity.ParentNumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentNumberDao extends CrudRepository<ParentNumber, Long> {
}
