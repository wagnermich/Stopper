/**
 * Sample Skeleton for 'Stoppung.fxml' Controller Class
 */

package at.michael.stopper.views.stoppung;

import java.net.URL;
import java.util.ResourceBundle;

import at.michael.stopper.views.main.MainPresenter;
//import at.michael.stopper.handler.Inject;
//import at.michael.stopper.handler.InjectionHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
//import javafx.scene.layout.AnchorPane;

public class StoppungPresenter implements Initializable{

	 @FXML
	    private AnchorPane baseAnchorStoppung;

	    @FXML
	    private HBox hBox; 
	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    
	    
	    @FXML
	    private VBox slot1;

	    
	    
	    private MainPresenter mainPresenter;
   
	@FXML
	    void handel(MouseEvent event) {System.out.println("blabla");}

	  public HBox  getAnchor() {
		  return hBox;
	  }
	  
	  public void injectMainPresenter(MainPresenter main) {
		  this.mainPresenter=main;
	  }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//System.out.println(hBox); 
		//System.out.println(bindParent.getId());
		//System.out.println("drinn bin i");
        assert baseAnchorStoppung != null : "fx:id=\"baseAnchorStoppung\" was not injected: check your FXML file 'Stoppung.fxml'.";
        assert hBox != null : "fx:id=\"hBox\" was not injected: check your FXML file 'Stoppung.fxml'.";
        assert slot1 != null : "fx:id=\"slot1\" was not injected: check your FXML file 'Stoppung.fxml'.";

	}

}
