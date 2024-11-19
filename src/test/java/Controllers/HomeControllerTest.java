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
 * Parasoft Jtest UTA: Test class for HomeController
 *
 * @see Controllers.HomeController
 * @author Pavan
 */
/*public class HomeControllerTest {

	/**
	 * Parasoft Jtest UTA: Test for chevroletAction(ActionEvent)
	 *
	 * @see Controllers.HomeController#chevroletAction(ActionEvent)
	 * @author Pavan
	 */
/*	@Test(timeout = 5000)
	public void testChevroletAction() throws Throwable {
		// UTA is unable to resolve the values required to create the requested test case.
		// A test case with default values has been created instead.

		// Given
		HomeController underTest = new HomeController();

		// When
		ActionEvent event = mock(ActionEvent.class);
		underTest.chevroletAction(event);

	}*/

	/**
	 * Parasoft Jtest UTA: Test for initialize(URL, ResourceBundle)
	 *
	 * @see Controllers.HomeController#initialize(URL, ResourceBundle)
	 * @author Pavan
	 */
/*	@Test(timeout = 5000)
	public void testInitialize() throws Throwable {
		// UTA is unable to resolve the values required to create the requested test case.
		// A test case with default values has been created instead.

		// Given
		HomeController underTest = new HomeController();

		// When
		URL arg0 = mock(URL.class);
		ResourceBundle arg1 = mock(ResourceBundle.class);
		underTest.initialize(arg0, arg1);

	}

}*/


package Controllers;

import static org.mockito.Mockito.*;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ResourceBundle;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {

    @Mock
    private AnchorPane mockCarsAnchor;

    @Mock
    private ActionEvent mockEvent;

    @Mock
    private HomePageController mockHomePageController;

    @InjectMocks
    private HomeController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = new HomeController(mockHomePageController);
        setField(controller, "CarsAnchor", mockCarsAnchor);

        // Mock the static method getInstance() to return the mockHomePageController
        HomePageController.setInstance(mockHomePageController);
    }

    private void setField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    @Test
    public void testInitialize() {
        URL url = null;
        ResourceBundle resourceBundle = null;
        controller.initialize(url, resourceBundle);
        // Add assertions if there are any post-initialization checks
    }

    @Test
    public void testMarutiAction() {
        controller.marutiAction(mockEvent);
        verify(mockHomePageController, times(1)).createPage(mockCarsAnchor, "/FXML/Maruti.fxml");
    }

    @Test
    public void testChevroletAction() {
        controller.chevroletAction(mockEvent);
        verify(mockHomePageController, times(1)).createPage(mockCarsAnchor, "/FXML/Chevrolet.fxml");
    }

    @Test
    public void testHyundaiAction() {
        controller.hyundaiAction(mockEvent);
        verify(mockHomePageController, times(1)).createPage(mockCarsAnchor, "/FXML/Hyundai.fxml");
    }

    @Test
    public void testTataMotorsAction() {
        controller.tataMotorsAction(mockEvent);
        verify(mockHomePageController, times(1)).createPage(mockCarsAnchor, "/FXML/TataMotors.fxml");
    }
}






