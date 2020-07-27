package by.sokhaeduard.eighthhw.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import by.sokhaeduard.eighthhw.dao.BookDao;
import by.sokhaeduard.eighthhw.dao.DaoException;
import by.sokhaeduard.eighthhw.dao.impl.BookDaoImpl;
import by.sokhaeduard.eighthhw.entity.Book;
import by.sokhaeduard.eighthhw.service.BookService;
import by.sokhaeduard.eighthhw.service.ServiceException;
import by.sokhaeduard.eighthhw.util.DataValidator;

public class BookServiceImpl implements BookService {
	private static BookService INSTANCE_SERVICE;
	private BookDao bookDao;

	private BookServiceImpl() {
		bookDao = BookDaoImpl.getBookDaoInstance();
	}

	public static BookService getBookServiceInstance() {
		if (INSTANCE_SERVICE == null) {
			INSTANCE_SERVICE = new BookServiceImpl();
		}
		return INSTANCE_SERVICE;
	}

	@Override
	public void addBook(String title, String authors, String numberPages, String typography) throws ServiceException {
		if (title == null || authors == null || typography == null || numberPages == null) {
			throw new ServiceException("incorrect param");
		}

		if (!DataValidator.isNumberPagesValid(numberPages)) {
			throw new ServiceException("incorrect param");
		}
		Book book = new Book(title, authors, Integer.parseInt(numberPages), typography);
		try {
			bookDao.addBook(book);
		} catch (DaoException e) {
			throw new ServiceException("the book is not added");
		}
	}

	@Override
	public Book findBookById(String id) throws ServiceException {
		if (id == null) {
			throw new ServiceException("incorrect param");
		}

		if (!DataValidator.isIdValid(id)) {
			throw new ServiceException("incorrect id");
		}

		Book findById = null;
		try {
			findById = bookDao.findById(id);
		} catch (DaoException e) {
			throw new ServiceException("can't find it");
		}
		if (findById == null) {
			throw new ServiceException("no such book in bd");
		}
		return findById;
	}

	@Override
	public void removeBook(String id) throws ServiceException {
		Book findBookById = findBookById(id);
		try {
			bookDao.removeBook(findBookById);
		} catch (DaoException e) {
			throw new ServiceException("can't remove it");
		}
	}

	@Override
	public List<Book> findByTitle(String title) throws ServiceException {
		try {
			return bookDao.getAllBooks().stream().filter(b -> b.getTitle().equals(title)).collect(Collectors.toList());
		} catch (DaoException e) {
			throw new ServiceException("can't find it");
		}
	}

	@Override
	public List<Book> sortBooksById() throws ServiceException {		
		try {
			return bookDao.sortBooksById();
		} catch (DaoException e) {
			throw new ServiceException("can't sort it");
		}

	}

	@Override
	public List<Book> sortBooksByTitle() throws ServiceException {
		try {
			return bookDao.sortBooksByTitle();
		} catch (DaoException e) {
			throw new ServiceException("can't sort it");
		}
	}

	@Override
	public void updateTitle(String title, String authors, String numberPages, String typography) throws ServiceException {
		if (title == null || authors == null || typography == null || numberPages == null) {
			throw new ServiceException("incorrect param");
		}

		if (!DataValidator.isNumberPagesValid(numberPages)) {
			throw new ServiceException("incorrect param");
		}
		Book book = new Book(title, authors, Integer.parseInt(numberPages), typography);
		try {
			bookDao.updateTitle(book);
		} catch (DaoException e) {
			throw new ServiceException("can't update it");
		}
	}

}