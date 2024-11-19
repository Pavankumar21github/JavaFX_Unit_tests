/**
 * 
 */
/*package Controllers;

import static org.mockito.Mockito.mock;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import org.junit.Test;

/**
 * Parasoft Jtest UTA: Test class for SignupController
 *
 * @see Controllers.SignupController
 * @author Pavan
 */
/*public class SignupControllerTest {

	/**
	 * Parasoft Jtest UTA: Test for getGender()
	 *
	 * @see Controllers.SignupController#getGender()
	 * @author Pavan
	 */
/*	@Test(timeout = 5000)
	public void testGetGender() throws Throwable {
		// UTA is unable to resolve the values required to create the requested test case.
		// A test case with default values has been created instead.

		// Given
		SignupController underTest = new SignupController();

		// When
		String result = underTest.getGender();

	}

}*/


package Controllers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javafx.application.Platform;
import javafx.scene.control.ToggleGroup;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import DBConnection.DBHandler;

import com.jfoenix.controls.JFXPasswordField;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RunWith(MockitoJUnitRunner.class)
public class SignupControllerTest {

    @Mock
    private DBHandler dbHandlerMock;

    @Mock
    private Connection connectionMock;

    @Mock
    private PreparedStatement preparedStatementMock;

    @Mock
    private ActionEvent actionEventMock;

    @InjectMocks
    private SignupController underTest;

    private JFXTextField name;
    private JFXPasswordField password;
    private JFXTextField location;
    private ImageView progress;
    private JFXRadioButton male;
    private JFXRadioButton female;
    private JFXRadioButton other;
    private ToggleGroup genderGroup;
    private JFXButton signup;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        // Ensure that JavaFX platform is initialized
        if (!Platform.isFxApplicationThread()) {
            Platform.startup(() -> {});
        }

        // Initialize the controller and its components
        underTest = new SignupController();

        // Real JavaFX components
        name = new JFXTextField();
        password = new JFXPasswordField();
        location = new JFXTextField();
        progress = new ImageView();
        signup = new JFXButton();

        male = new JFXRadioButton();
        female = new JFXRadioButton();
        other = new JFXRadioButton();

        genderGroup = new ToggleGroup();
        male.setToggleGroup(genderGroup);
        female.setToggleGroup(genderGroup);
        other.setToggleGroup(genderGroup);

        // Set fields in the controller
        setField(underTest, "name", name);
        setField(underTest, "password", password);
        setField(underTest, "location", location);
        setField(underTest, "progress", progress);
        setField(underTest, "male", male);
        setField(underTest, "female", female);
        setField(underTest, "other", other);
        setField(underTest, "signup", signup);

        when(dbHandlerMock.getConnection()).thenReturn(connectionMock);
        when(connectionMock.prepareStatement(anyString())).thenReturn(preparedStatementMock);
    }

    private void setField(Object target, String fieldName, Object value) throws Exception {
        var field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    /**
     * Test for the getGender() method of SignupController.
     */
    @Test
    public void testGetGender() {
        // Test when male is selected
        male.setSelected(true);
        assertEquals("Male", underTest.getGender());

        // Test when female is selected
        male.setSelected(false);
        female.setSelected(true);
        assertEquals("Female", underTest.getGender());

        // Test when other is selected
        female.setSelected(false);
        other.setSelected(true);
        assertEquals("Other", underTest.getGender());

        // Test when no gender is selected
        other.setSelected(false);
        assertEquals("", underTest.getGender());
    }

    /**
     * Test for the signupAction method of SignupController.
     */
    @Test
    public void testSignupAction() throws SQLException {
        // Set up the input data
        name.setText("TestUser");
        password.setText("TestPassword");
        location.setText("TestLocation");
        male.setSelected(true);

        // Simulate the signup action
        underTest.signupAction(actionEventMock);

        // Verify that the progress bar becomes visible
        assertTrue(progress.isVisible());

        // Simulate the delay for the PauseTransition
        Platform.runLater(() -> {
            try {
                // Verify the database interaction
                verify(preparedStatementMock).setString(1, "TestUser");
                verify(preparedStatementMock).setString(2, "TestPassword");
                verify(preparedStatementMock).setString(3, "Male");
                verify(preparedStatementMock).setString(4, "TestLocation");
                verify(preparedStatementMock).executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                fail("Database interaction failed");
            }
        });

        // Wait for the Platform.runLater to execute
        try {
            Thread.sleep(1000); // Adjust the sleep time if necessary
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test for the loginAction method of SignupController.
     */
    @Test
    public void testLoginAction() {
        try {
            underTest.loginAction(actionEventMock);

            // Verify that the progress bar is hidden after login
            assertFalse(progress.isVisible());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Login action failed");
        }
    }
}



