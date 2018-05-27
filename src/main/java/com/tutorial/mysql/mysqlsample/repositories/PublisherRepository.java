package com.tutorial.mysql.mysqlsample.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tutorial.mysql.mysqlsample.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
