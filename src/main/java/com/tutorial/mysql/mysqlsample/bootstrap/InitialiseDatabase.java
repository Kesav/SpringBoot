package com.tutorial.mysql.mysqlsample.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.tutorial.mysql.mysqlsample.model.Author;
import com.tutorial.mysql.mysqlsample.model.Book;
import com.tutorial.mysql.mysqlsample.model.Publisher;
import com.tutorial.mysql.mysqlsample.repositories.AuthorRepository;
import com.tutorial.mysql.mysqlsample.repositories.BookRepository;
import com.tutorial.mysql.mysqlsample.repositories.PublisherRepository;

@Component
public class InitialiseDatabase implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	public InitialiseDatabase(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initData();
	}

	private void initData() {

		Publisher publisher = new Publisher();
		publisher.setName("P1");
		publisher.setAddress("12th Street, LA");
		publisherRepository.save(publisher);

		Author kb = new Author("Kathy", "Sierra");
		Book ddd = new Book("K & B", "1234", publisher);
		kb.getBooks().add(ddd);
		ddd.getAuthors().add(kb);

		authorRepository.save(kb);
		bookRepository.save(ddd);

		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development  EJB", "5678", publisher);
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);

		authorRepository.save(rod);
		bookRepository.save(noEJB);
	}

}
