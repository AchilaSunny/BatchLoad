package com.achila.ETLloadservice.repository;

import com.achila.ETLloadservice.model.WCL;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WCLDTO extends CrudRepository<WCL,Integer> {
}
