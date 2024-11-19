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
 * Parasoft Jtest UTA: Test class for MarutiController
 *
 * @see Controllers.MarutiController
 * @author Pavan
 */
/*public class MarutiControllerTest {

	/**
	 * Parasoft Jtest UTA: Test for backAction(ActionEvent)
	 *
	 * @see Controllers.MarutiController#backAction(ActionEvent)
	 * @author Pavan
	 */
/*	@Test(timeout = 5000)
	public void testBackAction() throws Throwable {
		// UTA is unable to resolve the values required to create the requested test case.
		// A test case with default values has been created instead.

		// Given
		MarutiController underTest = new MarutiController();

		// When
		ActionEvent e = mock(ActionEvent.class);
		underTest.backAction(e);

	}

	/**
	 * Parasoft Jtest UTA: Test for initialize(URL, ResourceBundle)
	 *
	 * @see Controllers.MarutiController#initialize(URL, ResourceBundle)
	 * @author Pavan
	 */
/*	@Test(timeout = 5000)
	public void testInitialize() throws Throwable {
		// UTA is unable to resolve the values required to create the requested test case.
		// A test case with default values has been created instead.

		// Given
		MarutiController underTest = new MarutiController();

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
public class MarutiControllerTest {

    @Mock
    private AnchorPane mockCarInfo;

    @Mock
    private ActionEvent mockEvent;

    @Mock
    private HomePageController mockHomePageController;

    @InjectMocks
    private MarutiController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller.CarInfo = mockCarInfo;

        // Mock the static method getInstance() to return the mockHomePageController
        setStaticField(HomePageController.class, "instance", mockHomePageController);
    }

    private void setStaticField(Class<?> clazz, String fieldName, Object value) throws Exception {
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(null, value);
    }

    @Test
    public void testInitialize() {
        URL url = null;
        ResourceBundle resourceBundle = null;
        controller.initialize(url, resourceBundle);
        // Add assertions if there are any post-initialization checks
    }

    @Test
    public void testBackAction() {
        controller.backAction(mockEvent);
        verify(mockHomePageController, times(1)).createPage(mockCarInfo, "/FXML/HOME.fxml");
    }
}

