package at.michael.stopper.views.blatt;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import at.michael.stopper.handler.Inject;
import at.michael.stopper.services.GUIService;
import at.michael.stopper.views.main.MainPresenter;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

public class BlattPresenter implements Initializable{

	
	@Inject
	GUIService guiService;
	
	 @FXML
	 private Tab blatt;
	 
		 
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
	    	
	    	zeige();
	    	//tabPane=;
	    	//mainPresenter.setAktuellerTab(tabPane.getSelectionModel().getSelectedItem());
	    	
	    	
	    }
	    public Tab getNewTab(int index){
			final Tab newTab=new Tab();
			newTab.setId("blatt"+index);
			newTab.setText("Blatt "+index);
			newTab.setOnCloseRequest(e->{tabClosing(e);});
			newTab.setOnSelectionChanged(e->{tabSelected();});
			return newTab;
	    }
	    
	    public void injectMainPresenter(MainPresenter main) {
	    	this.mainPresenter=main;
	    }
	 public void zeige() {
		 if(guiService.getAktuellerTabPane()!=null) {
			 TabPane pane=guiService.getAktuellerTabPane();
			 Tab tab=pane.getSelectionModel().getSelectedItem();
			 System.out.println(tab.getId());
			 AnchorPane selectedBorderPane = (AnchorPane) tab.getContent();
			System.out.println(selectedBorderPane);
			 
		 }
		 //else System.out.println("  hier passiert was anderes");
	 }
   	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		guiService=GUIService.getInstance();
		tabPane=new TabPane();
				
	}
    
    
}
