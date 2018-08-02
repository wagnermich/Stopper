/**
 * Sample Skeleton for 'Test.fxml' Controller Class
 */

package at.michael.stopper.views.test;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class TestPresenter {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="baseAnchor"
    private AnchorPane baseAnchor; // Value injected by FXMLLoader

    @FXML // fx:id="borderPane"
    private BorderPane borderPane; // Value injected by FXMLLoader

    @FXML // fx:id="centerAnchor"
    private AnchorPane centerAnchor; // Value injected by FXMLLoader
    
    @FXML // fx:id="scrollPane"
    private ScrollPane scrollPane; // Value injected by FXMLLoader

    @FXML // fx:id="tabAnchor"
    private AnchorPane tabAnchor; // Value injected by FXMLLoader

    @FXML // fx:id="tabPane"
    private TabPane tabPane; // Value injected by FXMLLoader

    public void setAnchors(Node pane, double insets) {
    	AnchorPane.setBottomAnchor(pane, insets);
    	AnchorPane.setRightAnchor(pane, insets);
    	AnchorPane.setTopAnchor(pane, insets);
    	AnchorPane.setLeftAnchor(pane, insets);
    }
    
 
    
    @FXML // fx:id="addButton"
    private Button addButton; // Value injected by FXMLLoader

    @FXML
    void newTab(ActionEvent event) {
    	final Tab tab = new Tab("Tab " + (tabPane.getTabs().size() + 1));
        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().select(tab);
    }
    
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	
    	
    	
    	setAnchors(borderPane, 0.0);//verankert im Übergeordneten AnchorPane
    	setAnchors(tabPane, 0.0);
    	
    	
    	
    	

    }
}
