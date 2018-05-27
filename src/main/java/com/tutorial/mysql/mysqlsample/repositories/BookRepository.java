package com.tutorial.mysql.mysqlsample.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tutorial.mysql.mysqlsample.model.Book;

public interface BookRepository extends CrudRepository<Book, Long>  {

}
