/**
 * 
 */
/*package Controllers;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import org.junit.Test;

/**
 * Parasoft Jtest UTA: Test class for LoginController
 *
 * @see Controllers.LoginController
 * @author Pavan
 */
/*public class LoginControllerTest {

	/**
	 * Parasoft Jtest UTA: Test for getInstance()
	 *
	 * @see Controllers.LoginController#getInstance()
	 * @author Pavan
	 */
/*	@Test(timeout = 5000)
	public void testGetInstance() throws Throwable {
		// UTA is unable to resolve the values required to create the requested test case.
		// A test case with default values has been created instead.

		// When
		LoginController result = LoginController.getInstance();

		// Then - assertions for result of method getInstance()
		assertNotNull(result);
		assertNull(result.username);

	}

	/**
	 * Parasoft Jtest UTA: Test for initialize(URL, ResourceBundle)
	 *
	 * @see Controllers.LoginController#initialize(URL, ResourceBundle)
	 * @author Pavan
	 */
/*	@Test(timeout = 5000)
	public void testInitialize() throws Throwable {
		// UTA is unable to resolve the values required to create the requested test case.
		// A test case with default values has been created instead.

		// Given
		LoginController underTest = new LoginController();

		// When
		URL arg0 = mock(URL.class);
		ResourceBundle arg1 = mock(ResourceBundle.class);
		underTest.initialize(arg0, arg1);

		// Then - assertions for this instance of LoginController
		assertNull(underTest.username);

	}

}*/




package Controllers;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import DBConnection.DBHandler;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

    private LoginController underTest;
    private DBHandler mockHandler;
    private Connection mockConnection;
    private PreparedStatement mockPreparedStatement;
    private ResultSet mockResultSet;

    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        // Initialize JavaFX toolkit
        if (!Platform.isFxApplicationThread()) {
            Platform.startup(() -> {});
        }

        underTest = new LoginController();

        // Inject mocked dependencies
        mockHandler = mock(DBHandler.class);
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);

        setField(underTest, "handler", mockHandler);
        setField(underTest, "username", new JFXTextField());
        setField(underTest, "password", new JFXPasswordField());
        setField(underTest, "progress", new ImageView());
        setField(underTest, "login", mock(JFXButton.class));
    }

    private void setField(Object target, String fieldName, Object value) throws Exception {
        var field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    @Test
    public void testInitialize() throws Exception {
        // Given
        URL arg0 = mock(URL.class);
        ResourceBundle arg1 = mock(ResourceBundle.class);

        // When
        Platform.runLater(() -> underTest.initialize(arg0, arg1));

        // Wait for JavaFX thread to complete
        Thread.sleep(1000);

        // Then - assertions for private fields of this instance of LoginController
        assertFieldInitialized("username", JFXTextField.class);
        assertFieldInitialized("password", JFXPasswordField.class);
        assertFieldInitialized("progress", ImageView.class);
    }

    @Test
    public void testLoginAction_ValidCredentials() throws SQLException {
        // Mock valid database interaction
        when(mockHandler.getConnection()).thenReturn(mockConnection);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);

        // Trigger login action
        Platform.runLater(() -> underTest.loginAction(mock(ActionEvent.class)));

        // Verify behavior
        verify(mockHandler).getConnection();
        verify(mockPreparedStatement).setString(1, "");
        verify(mockPreparedStatement).setString(2, "");
        verify(mockResultSet, atLeastOnce()).next();
    }

    @Test
    public void testLoginAction_InvalidCredentials() throws SQLException {
        // Mock invalid database interaction
        when(mockHandler.getConnection()).thenReturn(mockConnection);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(false);

        // Trigger login action
        Platform.runLater(() -> underTest.loginAction(mock(ActionEvent.class)));

        // Verify behavior
        verify(mockHandler).getConnection();
        verify(mockPreparedStatement).setString(1, "");
        verify(mockPreparedStatement).setString(2, "");
        verify(mockResultSet, atLeastOnce()).next();
    }

    @Test
    public void testSignUp() throws Exception {
        // Mock sign-up action
        Stage mockStage = mock(Stage.class);
        setField(underTest, "login", mock(JFXButton.class));

        Platform.runLater(() -> {
            try {
                underTest.signUp(mock(ActionEvent.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Verify behavior
        assertNotNull(mockStage);
    }
        private void assertFieldInitialized(String fieldName, Class<?> expectedType) {
            try {
                Field field = LoginController.class.getDeclaredField(fieldName);
                field.setAccessible(true);
                Object value = field.get(underTest);
                assertNotNull("Expected field " + fieldName + " to be initialized", value);
                assert expectedType.isInstance(value) : "Field " + fieldName + " is not of expected type";
            } catch (Exception e) {
                throw new AssertionError("Reflection failed for field: " + fieldName, e);
            }
        
    
    }
}




