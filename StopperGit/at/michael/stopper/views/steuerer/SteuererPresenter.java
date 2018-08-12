package at.michael.stopper.views.steuerer;

import java.util.Date;

import at.michael.stopper.views.main.MainPresenter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class SteuererPresenter {

	
	@FXML // fx:id="baseAnchor"
    private AnchorPane baseAnchor; // Value injected by FXMLLoader

    @FXML // fx:id="labelSteuerung"
    private Label labelSteuerung; // Value injected by FXMLLoader
    
    @FXML
    private GridPane grid;


    @FXML
     public void steuerungClicked(MouseEvent e) {
		 if(e.getButton().equals(MouseButton.PRIMARY)){
	            if(e.getClickCount() == 2){
	               TextField steuerung = new TextField();
	               steuerung.setOnAction(ev->{
	            	   			if(steuerung.getText().length()==1) {
	            	   				labelSteuerung.setText(steuerung.getText());
	            	   				grid.getChildren().remove(steuerung);
	            	   				labelSteuerung.setVisible(true);
	            	   			}
								});
	               labelSteuerung.setVisible(false);
	               grid.add(steuerung,0,0);
	            }
	        }
		
	}

	public Character getSteuerungsKey() {
		return labelSteuerung.getText().charAt(0);//liefert immer nur das erste Zeichen (man kann auch nur eine eingeben)
	}
	
	
	
	private MainPresenter mainPresenter;
	
	public void injectMainPresenter(MainPresenter main) {
		this.mainPresenter=main;
	}
	
	
}
