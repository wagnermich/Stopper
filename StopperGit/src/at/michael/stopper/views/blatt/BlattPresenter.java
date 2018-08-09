package at.michael.stopper.views.blatt;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import at.michael.stopper.handler.Inject;
import at.michael.stopper.services.GUIService;
import at.michael.stopper.views.main.MainPresenter;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class BlattPresenter implements Initializable{

	
	@Inject
	GUIService guiService;
	
	 @FXML
	 private Tab blatt;
	 
	 @FXML
	 private HBox blattHBox;
	 
	 //@FXML
	 //private ListView<HBox> stackList;
	 
	 private BlattPresenter presenter;
		 
	 private MainPresenter mainPresenter;
	 private TabPane tabPane;

	 public Tab getBlatt() {
		 return blatt;
	 }
	 
	 private void closeRequester(Tab tab,TabPane tabPane,Event e) {
	 	   tabPane.getSelectionModel().select(tabPane.getTabs().size()-1); // setzte beim löschen immer aufs letzte element
	 	   schiessenDialog(tab,e);
	 	   setClosePolicy(tabPane,false); // closable neu organisieren // Woher bist du? add = true delete = false
	    }
	 	private void schiessenDialog(Tab tab,Event e) {
	 		ButtonType type=closeDialog("Tab schließen?","Wollen Sie wirklich "+tab.getText()+" schließen? Alle Daten gehen verloren.");
	        	if(type==ButtonType.CANCEL) e.consume();
	 		
	 	}	
	 	public ButtonType closeDialog(String title, String header){
	 	    Alert alert = new Alert(AlertType.CONFIRMATION);
	 	    alert.setTitle(title);
	 	    alert.setHeaderText(header);
	 	    Optional<ButtonType> option = alert.showAndWait();
	 	    return option.get();
	 	}
	 	public void setClosePolicy(TabPane tabPane,boolean addOrDelete) {
			int anzahl=tabPane.getTabs().size();
			if(!addOrDelete)anzahl--;	//Tab wird erst am Ende des Request gelöscht also Anzahl - 1
			boolean answer=true;
			if(anzahl<=2) answer=false; //wenn nur noch "+" und ein Tab übrig sind -> not closable Tabs
			for(Tab tab:tabPane.getTabs()) tab.setClosable(answer);  //alle setzten. "+" implementiert eigene select methode
				
		}
	 
	 @FXML private void tabClosing(Event event) {
		 	tabPane=mainPresenter.getAnchorTab();
		 	Tab aktuellerTab=tabPane.getSelectionModel().getSelectedItem();
		 	closeRequester(aktuellerTab,tabPane,event);
	    }

	    @FXML private void tabSelected() {
	    	 if(guiService.getAktuellerTabPane()!=null) {
				 //TabPane pane=guiService.getAktuellerTabPane();
				 //Tab tab=pane.getSelectionModel().getSelectedItem();
				 guiService.setAktuellerTab(blatt);
			 }
	    }
	    public Tab getNewTab(int index){
			blatt.setId("blatt"+index);
			blatt.setText("Blatt "+index);
			blattHBox.setId("blattHbox"+index);
	    	return blatt;
	    }
	    public HBox getAnchor() {
	    	return this.blattHBox;
	    }
	   
	    
	    public void injectMainPresenter(MainPresenter main) {
	    	this.mainPresenter=main;
	    }	
	    /*public void injectTab(ObservableList<AnchorPane> box) {
	    	blattHBox.getChildren().addAll(box);
	    }*/
   	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		guiService=GUIService.getInstance();
		this.presenter=this;
		tabPane=new TabPane();
				
	}
    
    
}
