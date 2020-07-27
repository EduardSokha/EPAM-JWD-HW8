package by.sokhaeduard.eighthhw.controller.command;

import by.sokhaeduard.eighthhw.dao.BookDao;
import by.sokhaeduard.eighthhw.dao.DaoException;
import by.sokhaeduard.eighthhw.dao.impl.BookDaoImpl;
import by.sokhaeduard.eighthhw.entity.Book;

public class TestData {

	public static void loadData() throws DaoException {
		BookDao bookListDao = BookDaoImpl.getBookDaoInstance();
		Book book = new Book(1, "War and Peace", "Lev", 500, "Konica Minolta");
		Book book2 = new Book(2, "Evgeniy Onegin", "Pushkin", 250, "Moscow");
		Book book3 = new Book(3, "Hunter's Notes", "Tyrgenev", 125, "Contemporary");
		Book book4 = new Book(4, "Master and Margarita", "Bylgokov", 350, "Tver");
		bookListDao.addBook(book);
		bookListDao.addBook(book2);
		bookListDao.addBook(book3);
		bookListDao.addBook(book4);
	}
}
