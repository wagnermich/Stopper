package at.michael.stopper.views.slot;

import java.net.URL;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;

import at.michael.stopper.views.benenner.BenennerPresenter;
import at.michael.stopper.views.benenner.BenennerView;
import at.michael.stopper.views.blatt.BlattPresenter;
import at.michael.stopper.views.ergebnis.ErgebnisPresenter;
import at.michael.stopper.views.ergebnis.ErgebnisView;
import at.michael.stopper.views.main.MainPresenter;
import at.michael.stopper.views.steuerer.SteuererPresenter;
import at.michael.stopper.views.steuerer.SteuererView;
import at.michael.stopper.views.stoppungen.StoppungenPresenter;
import at.michael.stopper.views.stoppungen.StoppungenView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class SlotPresenter implements Initializable{

	  @FXML // fx:id="anchorTop"
	    private VBox anchorTop; // Value injected by FXMLLoader

	    @FXML // fx:id="anchorBottom"
	    private AnchorPane anchorBottom; // Value injected by FXMLLoader

	    @FXML // fx:id="baseAnchor"
	    private AnchorPane baseAnchor; // Value injected by FXMLLoader
	
	private BlattPresenter previousPresenter;
	private SlotPresenter presenter;
	private BenennerPresenter bPresenter;
	private SteuererPresenter sPresenter;
	private ErgebnisPresenter ePresenter;
	private StoppungenPresenter stoppung;
	
	public VBox getAnchorTop() {
		return this.anchorTop;
	}
	public AnchorPane getAnchorBottom() {
		return this.anchorBottom;
	}
	public Parent getNewStop()
	{
		BenennerView benenner=new BenennerView();
 	   	bPresenter =(BenennerPresenter) benenner.getPresenter();
 		SteuererView steuerer=new SteuererView();
 		sPresenter =(SteuererPresenter) steuerer.getPresenter();   
 		ErgebnisView ergebnis=new ErgebnisView();
 		ePresenter =(ErgebnisPresenter) ergebnis.getPresenter();
 		
 	   anchorTop.getChildren().addAll(benenner.getView(),steuerer.getView(),ergebnis.getView());
 	    StoppungenView stopp=new StoppungenView();
	  stoppung =(StoppungenPresenter) stopp.getPresenter();
	  anchorBottom.getChildren().add(stopp.getView());
 	   
		
		return this.baseAnchor;
	}
	
	public Character getSteuerungsKey() {
		return sPresenter.getSteuerungsKey();
	}
	
	public void addStoppung(LocalTime now) {
		this.stoppung.addStoppung(now);
	}
	
	
	public void injectPreviousPresenter(BlattPresenter main) {
		this.previousPresenter=main;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.presenter=this;
		
	}
	
	
}
