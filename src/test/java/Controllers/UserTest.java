/**
 * 
 */
package Controllers;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javafx.beans.property.StringProperty;
import org.junit.Test;

/**
 * Parasoft Jtest UTA: Test class for User
 *
 * @see Controllers.User
 * @author Pavan
 */
public class UserTest {

	/**
	 * Parasoft Jtest UTA: Test for getText()
	 *
	 * @see Controllers.User#getText()
	 * @author Pavan
	 */
	@Test(timeout = 5000)
	public void testGetText() throws Throwable {
		// UTA is unable to resolve the values required to create the requested test case.
		// A test case with default values has been created instead.

		// Given
		User underTest = new User();

		// When
		String result = underTest.getText();

		// Then - assertions for result of method getText()
		assertNull(result);

		// Then - assertions for this instance of User
		assertNotNull(underTest.textProperty());

	}

	/**
	 * Parasoft Jtest UTA: Test for setText(String)
	 *
	 * @see Controllers.User#setText(String)
	 * @author Pavan
	 */
	@Test(timeout = 5000)
	public void testSetText() throws Throwable {
		// UTA is unable to resolve the values required to create the requested test case.
		// A test case with default values has been created instead.

		// Given
		User underTest = new User();

		// When
		String text = "text"; // UTA: default value
		underTest.setText(text);

		// Then - assertions for this instance of User
		assertNotNull(underTest.textProperty());

	}

}
