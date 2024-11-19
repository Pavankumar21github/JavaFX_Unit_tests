package Controllers;

import static org.mockito.Mockito.*;

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
public class ChevroletControllerTest {

    @Mock
    private AnchorPane mockCarInfo;

    @Mock
    private ActionEvent mockEvent;

    @Mock
    private HomePageController mockHomePageController;

    @InjectMocks
    private ChevroletController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller.CarInfo = mockCarInfo;

        // Mock the static method getInstance() to return the mockHomePageController
        HomePageController.setInstance(mockHomePageController);
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
