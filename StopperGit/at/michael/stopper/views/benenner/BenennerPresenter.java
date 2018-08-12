package at.michael.stopper.views.benenner;

import at.michael.stopper.handler.IPresenter;
import at.michael.stopper.views.main.MainPresenter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class BenennerPresenter{

	 @FXML // fx:id="grid"
	    private GridPane grid; // Value injected by FXMLLoader

	    @FXML // fx:id="baseAnchor"
	    private AnchorPane baseAnchor; // Value injected by FXMLLoader

	    @FXML // fx:id="labelWerbeflaeche"
	    private Label labelWerbeflaeche; // Value injected by FXMLLoader

	    @FXML // fx:id="labelSponsor"
	    private Label labelSponsor; // Value injected by FXMLLoader

	  
	private MainPresenter mainPresenter;
	
	public void sponsorName(MouseEvent e) {
		 if(e.getButton().equals(MouseButton.PRIMARY)){
	            if(e.getClickCount() == 2){
	               TextField sponsor = new TextField();
	               sponsor.setOnAction(ev->{
	            	   			labelSponsor.setText(sponsor.getText());
	            	   			grid.getChildren().remove(sponsor);
	            	   			labelSponsor.setVisible(true);
								});
	               labelSponsor.setVisible(false);
	               grid.add(sponsor,0,0);
	            }
	        }
		
	}
	
	public void werbeflaecheName(MouseEvent e) {
		 if(e.getButton().equals(MouseButton.PRIMARY)){
	            if(e.getClickCount() == 2){
	               TextField werbe = new TextField();
	               werbe.setOnAction(ev->{
	            	   			labelWerbeflaeche.setText(werbe.getText());
	            	   			grid.getChildren().remove(werbe);
	            	   			labelWerbeflaeche.setVisible(true);
								});
	               labelWerbeflaeche.setVisible(false);
	               grid.add(werbe,0,1);
	            }
	        }
		
	}
	
	public void injectMainPresenter(MainPresenter main) {
		this.mainPresenter=main;
	}

	
	
	
	
}
