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
 * Parasoft Jtest UTA: Test class for TataMotorsController
 *
 * @see Controllers.TataMotorsController
 * @author Pavan
 */
/*public class TataMotorsControllerTest {

	/**
	 * Parasoft Jtest UTA: Test for backAction(ActionEvent)
	 *
	 * @see Controllers.TataMotorsController#backAction(ActionEvent)
	 * @author Pavan
	 */
/*	@Test(timeout = 5000)
	public void testBackAction() throws Throwable {
		// UTA is unable to resolve the values required to create the requested test case.
		// A test case with default values has been created instead.

		// Given
		TataMotorsController underTest = new TataMotorsController();

		// When
		ActionEvent e = mock(ActionEvent.class);
		underTest.backAction(e);

	}

	/**
	 * Parasoft Jtest UTA: Test for initialize(URL, ResourceBundle)
	 *
	 * @see Controllers.TataMotorsController#initialize(URL, ResourceBundle)
	 * @author Pavan
	 */
/*	@Test(timeout = 5000)
	public void testInitialize() throws Throwable {
		// UTA is unable to resolve the values required to create the requested test case.
		// A test case with default values has been created instead.

		// Given
		TataMotorsController underTest = new TataMotorsController();

		// When
		URL arg0 = mock(URL.class);
		ResourceBundle arg1 = mock(ResourceBundle.class);
		underTest.initialize(arg0, arg1);

	}
}*/


package Controllers;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mockStatic;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.mockito.*;

public class TataMotorsControllerTest {

    @Mock
    private HomePageController homePageControllerMock;

    @InjectMocks
    private TataMotorsController underTest;

    private AnchorPane carInfo;

    private AutoCloseable closeable;

    @Before
    public void setUp() throws Exception {
        closeable = MockitoAnnotations.openMocks(this);

        // Initialize the controller and its components
        underTest = new TataMotorsController();

        // Real JavaFX components
        carInfo = new AnchorPane();

        // Set fields in the controller
        setField(underTest, "CarInfo", carInfo);

        // Mock the HomePageController instance
        try (var mockedStatic = mockStatic(HomePageController.class)) {
            mockedStatic.when(HomePageController::getInstance).thenReturn(homePageControllerMock);
        }
    }

    @After
    public void tearDown() throws Exception {
        closeable.close();
    }

    private void setField(Object target, String fieldName, Object value) throws Exception {
        var field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    /**
     * Test for the backAction(ActionEvent) method of TataMotorsController.
     */
    @Test
    public void testBackAction() {
        // Given
        ActionEvent e = mock(ActionEvent.class);

        // Mock the HomePageController instance again for this test
        try (var mockedStatic = mockStatic(HomePageController.class)) {
            mockedStatic.when(HomePageController::getInstance).thenReturn(homePageControllerMock);

            // When
            underTest.backAction(e);

            // Then
            verify(homePageControllerMock).createPage(carInfo, "/FXML/HOME.fxml");
        }
    }

    /**
     * Test for the initialize(URL, ResourceBundle) method of TataMotorsController.
     */
    @Test
    public void testInitialize() {
        // Given
        URL arg0 = mock(URL.class);
        ResourceBundle arg1 = mock(ResourceBundle.class);

        // When
        underTest.initialize(arg0, arg1);

        // Then
        // No specific assertions needed as initialize method is empty
    }
}
