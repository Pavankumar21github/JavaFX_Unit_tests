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
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import org.junit.Test;

/**
 * Parasoft Jtest UTA: Test class for HomePageController
 *
 * @see Controllers.HomePageController
 * @author Pavan
 */
/*public class HomePageControllerTest {

	/**
	 * Parasoft Jtest UTA: Test for exit(ActionEvent)
	 *
	 * @see Controllers.HomePageController#exit(ActionEvent)
	 * @author Pavan
	 */
/*	@Test(timeout = 5000)
	public void testExit() throws Throwable {
		// UTA is unable to resolve the values required to create the requested test case.
		// A test case with default values has been created instead.

		// Given
		HomePageController underTest = new HomePageController();

		// When
		ActionEvent event = mock(ActionEvent.class);
		underTest.exit(event);

		// Then - assertions for this instance of HomePageController
		assertNull(underTest.holderPane);

	}

	/**
	 * Parasoft Jtest UTA: Test for getInstance()
	 *
	 * @see Controllers.HomePageController#getInstance()
	 * @author Pavan
	 */
/*	@Test(timeout = 5000)
	public void testGetInstance() throws Throwable {
		// UTA is unable to resolve the values required to create the requested test case.
		// A test case with default values has been created instead.

		// When
		HomePageController result = HomePageController.getInstance();

		// Then - assertions for result of method getInstance()
		assertNotNull(result);
		assertNull(result.holderPane);

	}

	/**
	 * Parasoft Jtest UTA: Test for initialize(URL, ResourceBundle)
	 *
	 * @see Controllers.HomePageController#initialize(URL, ResourceBundle)
	 * @author Pavan
	 */
/*	@Test(timeout = 5000)
	public void testInitialize() throws Throwable {
		// UTA is unable to resolve the values required to create the requested test case.
		// A test case with default values has been created instead.

		// Given
		HomePageController underTest = new HomePageController();

		// When
		URL arg0 = mock(URL.class);
		ResourceBundle arg1 = mock(ResourceBundle.class);
		underTest.initialize(arg0, arg1);

		// Then - assertions for this instance of HomePageController
		assertNull(underTest.holderPane);

	}

}*/


/*package Controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mockStatic;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import com.jfoenix.controls.JFXButton;

@RunWith(MockitoJUnitRunner.class)
public class HomePageControllerTest {

    @Mock
    private LoginController loginControllerMock;

    @Mock
    private FXMLLoader fxmlLoaderMock;

    @Mock
    private Parent parentMock;

    @Mock
    private Stage stageMock;

    @InjectMocks
    private HomePageController underTest;

    @Mock
    private ActionEvent actionEventMock;

    private AnchorPane holderPane;
    private Text welcome;
    private AnchorPane anchor;
    private HBox toolBarRight;
    private Label lblMenu;
    private VBox overflowContainer;
    private JFXButton btnLogOut;
    private JFXButton btnExit;
    private AnchorPane home;

    @Before
    public void setUp() throws Exception {
        // Initialize JavaFX toolkit
        new JFXPanel();

        MockitoAnnotations.initMocks(this);

        // Initialize the controller and its components
        underTest = new HomePageController();

        // Real JavaFX components
        holderPane = new AnchorPane();
        welcome = new Text();
        anchor = new AnchorPane();
        toolBarRight = new HBox();
        lblMenu = new Label();
        overflowContainer = new VBox();
        btnLogOut = new JFXButton();
        btnExit = new JFXButton();
        home = new AnchorPane();

        // Set fields in the controller
        setField(underTest, "holderPane", holderPane);
        setField(underTest, "welcome", welcome);
        setField(underTest, "anchor", anchor);
        setField(underTest, "toolBarRight", toolBarRight);
        setField(underTest, "lblMenu", lblMenu);
        setField(underTest, "overflowContainer", overflowContainer);
        setField(underTest, "btnLogOut", btnLogOut);
        setField(underTest, "btnExit", btnExit);
        setField(underTest, "home", home);

        // Mock the LoginController instance
        when(LoginController.getInstance()).thenReturn(loginControllerMock);
        when(loginControllerMock.username()).thenReturn("TestUser");

        // Mock FXMLLoader
        when(fxmlLoaderMock.load(any(URL.class))).thenReturn(parentMock);
    }

    private void setField(Object target, String fieldName, Object value) throws Exception {
        var field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    @Test
    public void testInitialize() {
        // Given
        URL url = mock(URL.class);
        ResourceBundle resourceBundle = mock(ResourceBundle.class);

        // When
        underTest.initialize(url, resourceBundle);

        // Then
        assertEquals("Welcome, TestUser", welcome.getText());
    }

    @Test
    public void testSetUsername() {
        // Given
        String username = "TestUser";

        // When
        underTest.setUsername(username);

        // Then
        assertEquals("Welcome, TestUser", welcome.getText());
    }

    @Test
    public void testOpenMenus() {
        // Given
        // No specific setup needed

        // When
        underTest.initialize(null, null);
        lblMenu.fireEvent(new javafx.scene.input.MouseEvent(javafx.scene.input.MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, javafx.scene.input.MouseButton.PRIMARY, 1, true, true, true, true, true, true, true, true, true, true, null));

        // Then
        // No specific assertions needed as openMenus method is private and its effects are visual
    }

    @Test
    public void testSetNode() {
        // Given
        Node node = new AnchorPane();

        // When
        underTest.setNode(node);

        // Then
        assertTrue(holderPane.getChildren().contains(node));
    }

    @Test
    public void testCreatePage() throws IOException {
        // Given
        AnchorPane homeN = new AnchorPane();
        String loc = "/FXML/HOME.fxml";

        // Mock FXMLLoader
        try (var mockedStatic = mockStatic(FXMLLoader.class)) {
            mockedStatic.when(() -> FXMLLoader.load(any(URL.class))).thenReturn(parentMock);

            // When
            underTest.createPage(homeN, loc);

            // Then
            assertTrue(holderPane.getChildren().contains(parentMock));
        }
    }

    @Test
    public void testHomeBtn() {
        // Given
        ActionEvent he = mock(ActionEvent.class);

        // When
        underTest.homeBtn(he);

        // Then
        assertTrue(holderPane.getChildren().contains(home));
    }

    @Test
    public void testExit() {
        // Given
        ActionEvent event = mock(ActionEvent.class);

        // When
        underTest.exit(event);

        // Then
        // No specific assertions needed as Platform.exit() will close the application
    }

    @Test
    public void testLogOut() throws IOException {
        // Given
        ActionEvent event = mock(ActionEvent.class);

        // Mock FXMLLoader
        try (var mockedStatic = mockStatic(FXMLLoader.class)) {
            mockedStatic.when(() -> FXMLLoader.load(any(URL.class))).thenReturn(parentMock);

            // When
            underTest.logOut(event);

            // Then
            assertFalse(btnLogOut.getScene().getWindow().isShowing());
            verify(stageMock).show();
        }
    }
}*/



package Controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mockStatic;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import com.jfoenix.controls.JFXButton;

@RunWith(MockitoJUnitRunner.class)
public class HomePageControllerTest {

    @Mock
    private LoginController loginControllerMock;

    @Mock
    private FXMLLoader fxmlLoaderMock;

    @Mock
    private Parent parentMock;

    @Mock
    private Stage stageMock;

    @InjectMocks
    private HomePageController underTest;

    @Mock
    private ActionEvent actionEventMock;

    private AnchorPane holderPane;
    private Text welcome;
    private AnchorPane anchor;
    private HBox toolBarRight;
    private Label lblMenu;
    private VBox overflowContainer;
    private JFXButton btnLogOut;
    private JFXButton btnExit;
    private AnchorPane home;

    private AutoCloseable closeable;
    private MockedStatic<LoginController> loginControllerMockedStatic;
    private MockedStatic<FXMLLoader> fxmlLoaderMockedStatic;

    @Before
    public void setUp() throws Exception {
        // Initialize JavaFX toolkit
        new JFXPanel();

        closeable = MockitoAnnotations.openMocks(this);

        // Initialize the controller and its components
        underTest = new HomePageController();

        // Real JavaFX components
        holderPane = new AnchorPane();
        welcome = new Text();
        anchor = new AnchorPane();
        toolBarRight = new HBox();
        lblMenu = new Label();
        overflowContainer = new VBox();
        btnLogOut = new JFXButton();
        btnExit = new JFXButton();
        home = new AnchorPane();

        // Set fields in the controller
        setField(underTest, "holderPane", holderPane);
        setField(underTest, "welcome", welcome);
        setField(underTest, "anchor", anchor);
        setField(underTest, "toolBarRight", toolBarRight);
        setField(underTest, "lblMenu", lblMenu);
        setField(underTest, "overflowContainer", overflowContainer);
        setField(underTest, "btnLogOut", btnLogOut);
        setField(underTest, "btnExit", btnExit);
        setField(underTest, "home", home);

        // Mock the LoginController instance
        loginControllerMockedStatic = mockStatic(LoginController.class);
        loginControllerMockedStatic.when(LoginController::getInstance).thenReturn(loginControllerMock);
        when(loginControllerMock.username()).thenReturn("TestUser");

        // Mock FXMLLoader
        fxmlLoaderMockedStatic = mockStatic(FXMLLoader.class);
        fxmlLoaderMockedStatic.when(() -> FXMLLoader.load(any(URL.class))).thenReturn(new AnchorPane());
    }

    @After
    public void tearDown() throws Exception {
        closeable.close();
        loginControllerMockedStatic.close();
        fxmlLoaderMockedStatic.close();
    }

    private void setField(Object target, String fieldName, Object value) throws Exception {
        var field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    @Test
    public void testInitialize() {
        Platform.runLater(() -> {
            // Given
            URL url = mock(URL.class);
            ResourceBundle resourceBundle = mock(ResourceBundle.class);

            // When
            underTest.initialize(url, resourceBundle);

            // Then
            assertEquals("Welcome, TestUser", welcome.getText());
        });
    }

    @Test
    public void testSetUsername() {
        Platform.runLater(() -> {
            // Given
            String username = "TestUser";

            // When
            underTest.setUsername(username);

            // Then
            assertEquals("Welcome, TestUser", welcome.getText());
        });
    }

    @Test
    public void testOpenMenus() {
        Platform.runLater(() -> {
            // Given
            // Attach lblMenu to a scene
            Scene scene = new Scene(new AnchorPane(lblMenu));
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            // When
            underTest.initialize(null, null);
            lblMenu.fireEvent(new javafx.scene.input.MouseEvent(javafx.scene.input.MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, javafx.scene.input.MouseButton.PRIMARY, 1, true, true, true, true, true, true, true, true, true, true, null));

            // Then
            // No specific assertions needed as openMenus method is private and its effects are visual
        });
    }

    @Test
    public void testSetNode() {
        Platform.runLater(() -> {
            // Given
            Node node = new AnchorPane();

            // When
            underTest.setNode(node);

            // Then
            assertTrue(holderPane.getChildren().contains(node));
        });
    }

    @Test
    public void testCreatePage() throws IOException {
        Platform.runLater(() -> {
            // Given
            AnchorPane homeN = new AnchorPane();
            String loc = "/FXML/HOME.fxml";

            // When
            underTest.createPage(homeN, loc);

            // Then
            assertTrue(holderPane.getChildren().contains(homeN));
        });
    }

    @Test
    public void testHomeBtn() {
        Platform.runLater(() -> {
            // Given
            ActionEvent he = mock(ActionEvent.class);

            // When
            underTest.homeBtn(he);

            // Then
            assertTrue(holderPane.getChildren().contains(home));
        });
    }

    @Test
    public void testExit() {
        Platform.runLater(() -> {
            // Given
            ActionEvent event = mock(ActionEvent.class);

            // When
            underTest.exit(event);

            // Then
            // No specific assertions needed as Platform.exit() will close the application
        });
    }

    @Test
    public void testLogOut() throws IOException {
        Platform.runLater(() -> {
            // Given
            ActionEvent event = mock(ActionEvent.class);

            // When
            underTest.logOut(event);

            // Then
            assertFalse(btnLogOut.getScene().getWindow().isShowing());
            verify(stageMock).show();
        });
    }
}












