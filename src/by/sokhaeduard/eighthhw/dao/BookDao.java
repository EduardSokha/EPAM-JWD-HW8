package by.sokhaeduard.eighthhw.dao;

import java.util.List;

import by.sokhaeduard.eighthhw.entity.Book;

public interface BookDao {
	void addBook(Book anotherBook) throws DaoException;

	void removeBook(Book anotherBook) throws DaoException;

	Book findById(String id) throws DaoException;

	List<Book> getAllBooks() throws DaoException;
	
	List<Book> sortBooksById() throws DaoException;

	List<Book> sortBooksByTitle() throws DaoException;
	
	void updateTitle(Book book) throws DaoException;

}
