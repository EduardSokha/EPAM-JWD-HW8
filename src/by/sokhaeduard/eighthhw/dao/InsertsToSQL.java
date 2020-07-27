package by.sokhaeduard.eighthhw.dao;

public class InsertsToSQL {
	
	private InsertsToSQL() {
	}
	 
	 public static final String GET_ALL_BOOKS_FROM_DB = "SELECT `id`, `title`, `authors`, `number_pages`, `typography` FROM `book`";
	 public static final String ADD_BOOK_TO_BD = "INSERT INTO `book` (`title`, `authors`, `number_pages`, `typography`) VALUES (?, ?, ?, ?)";
	 public static final String DELETE_BOOK_FROM_BD = "DELETE FROM `book` WHERE `id` = ?";	 
	 public static final String GET_BOOK_BY_ID_FROM_DB ="SELECT `id`, `title`, `authors`, `number_pages`, `typography` FROM `book` WHERE `id` = ";
	 public static final String UPDATE_TITLE_BOOK_IN_BD = "UPDATE `book` SET `title` = ? WHERE `id` = ?";
	 
	 public static final String SORT_BY_ID = "SELECT `id`, `title`, `authors`, `number_pages`, `typography` FROM `book` ORDER BY `id`";
	 public static final String SORT_BY_TITLE = "SELECT `id`, `title`, `authors`, `number_pages`, `typography` FROM `book` ORDER BY `title`";

}
