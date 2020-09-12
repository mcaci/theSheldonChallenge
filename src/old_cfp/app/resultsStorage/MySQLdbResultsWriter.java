/**
 * 
 */
package app.resultsStorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import app.gameSession.GameSession;
import resultsStorage.IResultsStorage;

/**
 * @author nikiforos
 *
 */
public class MySQLdbResultsWriter implements IResultsStorage {

	private Connection connect = null;
	private Statement statement = null;
	
	public MySQLdbResultsWriter(){}
	
	/* (non-Javadoc)
	 * @see resultsStorage.IResultsStorage#writeResults(app.gameSession.GameSession)
	 */
	@Override
	public void writeResults(GameSession g) throws Exception{
		
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			// TODO: ask for user and password
			connect = DriverManager.getConnection("jdbc:mysql://localhost/sakila?user=root&password=root");
			
			//schema creation: TODO
			//table creation: TODO
			
			//adding information to the database
			statement = connect.createStatement();
			statement.executeUpdate("INSERT INTO sakila.outcomes (WINNER, SCOREp1, SCOREp2)" +
					" VALUES ('" + g.getWinner().getID() + "', " + g.getP1().getPunti() + ", " + g.getP2().getPunti() + ")");
			
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}
	
	// You need to close the resultSet
	private void close() {
		try {
			/*if (resultSet != null) {
				resultSet.close();
			}*/

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

}
