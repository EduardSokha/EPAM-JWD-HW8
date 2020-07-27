package by.sokhaeduard.eighthhw.service;

import java.util.List;

import by.sokhaeduard.eighthhw.entity.Book;

public interface BookService {

	void addBook(String title, String author, String numberPages, String typography) throws ServiceException;

	void removeBook(String id) throws ServiceException;

	Book findBookById(String id) throws ServiceException;

	List<Book> findByTitle(String title) throws ServiceException;

	List<Book> sortBooksById() throws ServiceException;

	List<Book> sortBooksByTitle() throws ServiceException;
	
	void updateTitle(String title, String authors, String numberPages, String typography) throws ServiceException;
	
}
