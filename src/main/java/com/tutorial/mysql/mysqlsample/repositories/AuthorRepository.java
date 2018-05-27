package com.tutorial.mysql.mysqlsample.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tutorial.mysql.mysqlsample.model.Author;



public interface AuthorRepository extends CrudRepository<Author, Long> {
}