package at.michael.stopper.views.tab;

/**
 * Sample Skeleton for 'Tab.fxml' Controller Class
 */


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

public class TabPresenter {

	 @FXML // ResourceBundle that was given to the FXMLLoader
	    private ResourceBundle resources;

	    @FXML // URL location of the FXML file that was given to the FXMLLoader
	    private URL location;

	    @FXML // fx:id="anchorTabView"
	    private AnchorPane anchorTabView; // Value injected by FXMLLoader

	    @FXML // fx:id="tabScrollPane"
	    private ScrollPane tabScrollPane; // Value injected by FXMLLoader

	    @FXML // fx:id="anchorTab"
	    private AnchorPane anchorTab; // Value injected by FXMLLoader

	    @FXML // fx:id="tabPane"
	    private TabPane tabPane; // Value injected by FXMLLoader

	    @FXML // fx:id="blatt1"
	    private Tab blatt1; // Value injected by FXMLLoader

	    @FXML // fx:id="addTab"
	    private Tab addTab; // Value injected by FXMLLoader
	    
    @FXML
    void addNewTab(ActionEvent event) {
    	System.out.println("hier was machen");
    }
    

    @FXML
    void closeRequest(ActionEvent event) {

    }

    @FXML
    void never(ActionEvent event) {

    }
    public AnchorPane getAnchor() {
    	return this.anchorTabView;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	
    	
    	

    }
}
