package by.sokhaeduard.eighthhw.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
	private static final ConnectionPool instance = new ConnectionPool();
	private String driver;
	private String url;
	private String user;
	private String password;
	private int size;
	private BlockingQueue<Connection> connections;

	public ConnectionPool() {
		connections = new ArrayBlockingQueue<Connection>(5);
		DBResourceManager db = DBResourceManager.getInstance();
		driver = db.getValue(DBParameters.DB_DRIVER);
		url = db.getValue(DBParameters.DB_URL);
		user = db.getValue(DBParameters.DB_USER);
		password = db.getValue(DBParameters.DB_PASSWORD);
		size = Integer.parseInt(db.getValue(DBParameters.DB_SIZE));

		try {
			Class.forName(driver);
			for (int i = 0; i < size; i++) {
				Connection сonnection = DriverManager.getConnection(url, user, password);
				connections.add(сonnection);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static ConnectionPool getInstance() {
		return instance;
	}

	public Connection getConnection() throws InterruptedException {
		return connections.take();
	}

	public void release(Connection con) {
		try {
			if (con != null) {
				con.setAutoCommit(true);
				connections.add(con);
			} else {
				// log
			}
		} catch (SQLException e) {
			//log
		}
	}
	
	public void releaseDbResourses(Connection con, Statement statement, ResultSet resultSet) {
		releaseResultSet(resultSet);
		releaseStatement(statement);
		release(con);
	}

	public void releaseStatement(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				//log
			}
		}
	}

	public void releaseResultSet(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				//log
			}
		}
	}
}
