package com.achila.ETLloadservice.repository;

import com.achila.ETLloadservice.model.PEP;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PEPDTO extends CrudRepository<PEP,Integer> {
}
