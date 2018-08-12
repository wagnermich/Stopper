package at.michael.stopper.views.ergebnis;

import at.michael.stopper.views.main.MainPresenter;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class ErgebnisPresenter {

	@FXML // fx:id="baseAnchor"
    private AnchorPane baseAnchor; // Value injected by FXMLLoader
	
	private MainPresenter mainPresenter;
	
	public void injectMainPresenter(MainPresenter main) {
		this.mainPresenter=main;
	}
	
	
}
