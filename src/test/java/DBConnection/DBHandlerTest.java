/**
 * 
 */
package DBConnection;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import org.junit.Test;

/**
 * Parasoft Jtest UTA: Test class for DBHandler
 *
 * @see DBConnection.DBHandler
 * @author Pavan
 */
public class DBHandlerTest {

	/**
	 * Parasoft Jtest UTA: Test for getConnection()
	 *
	 * @see DBConnection.DBHandler#getConnection()
	 * @author Pavan
	 */
	@Test(timeout = 5000)
	public void testGetConnection() throws Throwable {
		// UTA is unable to resolve the values required to create the requested test case.
		// A test case with default values has been created instead.

		// Given
		DBHandler underTest = new DBHandler();

		// When
		Connection result = underTest.getConnection();

		// Then - assertions for result of method getConnection()
		assertNotNull(result);

	}
}
