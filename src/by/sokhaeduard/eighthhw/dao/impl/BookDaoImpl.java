package by.sokhaeduard.eighthhw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.sokhaeduard.eighthhw.connectionpool.ConnectionPool;
import by.sokhaeduard.eighthhw.dao.BookDao;
import by.sokhaeduard.eighthhw.dao.DaoException;
import by.sokhaeduard.eighthhw.dao.InsertsToSQL;
import by.sokhaeduard.eighthhw.entity.Book;

public class BookDaoImpl implements BookDao {
	private final ConnectionPool cp = ConnectionPool.getInstance();
	private static BookDao INSTANCE_DAO;

	private BookDaoImpl() {
	}

	public static BookDao getBookDaoInstance() {
		if (INSTANCE_DAO == null) {
			INSTANCE_DAO = new BookDaoImpl();
		}
		return INSTANCE_DAO;
	}

    @Override
    public void addBook(Book book) throws DaoException {
    	Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		String query = InsertsToSQL.ADD_BOOK_TO_BD;

		try {
			con = cp.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthors());			
			ps.setInt(3, book.getNumberPages());
			ps.setString(4, book.getTypography());
			ps.executeUpdate();
		} catch (SQLException | InterruptedException e) {
			throw new DaoException(e);
		} finally {
			cp.releaseDbResourses(con, ps, rs);
		}
    }

    @Override
    public void removeBook(Book anotherBook) throws DaoException{
    	Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		String query = InsertsToSQL.DELETE_BOOK_FROM_BD;
		
		try {
			con = cp.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, anotherBook.getId());
			ps.executeUpdate();
			
		} catch (SQLException | InterruptedException e) {
			throw new DaoException(e);
		} finally {
			cp.releaseDbResourses(con, ps, rs);
		}
    }

    @Override
    public Book findById(String id) throws DaoException {
    	Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		String query = InsertsToSQL.GET_BOOK_BY_ID_FROM_DB + id;

		try {
			con = cp.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery(query);

			if (rs.next()) {
				Book book = createBook(rs);
				return book;
			}
		} catch (SQLException | InterruptedException e) {
			throw new DaoException(e);
		} finally {
			cp.releaseDbResourses(con, ps, rs);
		}
		
		return null;
    }

	@Override
	public List<Book> getAllBooks() throws DaoException {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Book> books = new ArrayList<>();
		String querry = InsertsToSQL.GET_ALL_BOOKS_FROM_DB;

		try {
			con = cp.getConnection();
			ps = con.prepareStatement(querry);
			rs = ps.executeQuery(querry);

			while (rs.next()) {
				Book book = createBook(rs);
				books.add(book);
			}
		} catch (SQLException | InterruptedException e) {
			throw new DaoException(e);
		} finally {
			cp.releaseDbResourses(con, ps, rs);
		}

		return books;
	}

	@Override
	public List<Book> sortBooksById() throws DaoException {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Book> books = new ArrayList<>();
		String querry = InsertsToSQL.SORT_BY_ID;

		try {
			con = cp.getConnection();
			ps = con.prepareStatement(querry);
			rs = ps.executeQuery(querry);

			while (rs.next()) {
				Book book = createBook(rs);
				books.add(book);
			}
		} catch (SQLException | InterruptedException e) {
			throw new DaoException(e);
		} finally {
			cp.releaseDbResourses(con, ps, rs);
		}

		return books;
	}

	@Override
	public List<Book> sortBooksByTitle() throws DaoException {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		List<Book> books = new ArrayList<>();
		String querry = InsertsToSQL.SORT_BY_TITLE;

		try {
			con = cp.getConnection();
			ps = con.prepareStatement(querry);
			rs = ps.executeQuery(querry);

			while (rs.next()) {
				Book book = createBook(rs);
				books.add(book);
			}
		} catch (SQLException | InterruptedException e) {
			throw new DaoException(e);
		} finally {
			cp.releaseDbResourses(con, ps, rs);
		}

		return books;
	}

	@Override
	public void updateTitle(Book book) throws DaoException {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sq1 = InsertsToSQL.UPDATE_TITLE_BOOK_IN_BD;

		try {
			con = cp.getConnection();
			ps = con.prepareStatement(sq1);
			ps.setString(1, book.getTitle());
			ps.setInt(2, book.getId());
			ps.executeUpdate();
			
		} catch (SQLException | InterruptedException e) {
			throw new DaoException(e);
		} finally {
			cp.releaseDbResourses(con, ps, rs);
		}
	}
	
	private Book createBook(ResultSet rs) throws SQLException {
		Book book = new Book();
		
		book.setId(rs.getInt("id"));
		book.setTitle(rs.getString("title"));
		book.setAuthors(rs.getString("authors"));
		book.setNumberPages(rs.getInt("number_pages"));
		book.setTypography(rs.getString("typography"));
		
		return book;
	}
}
