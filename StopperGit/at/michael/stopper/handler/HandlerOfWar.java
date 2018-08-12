package at.michael.stopper.handler;

import java.util.Optional;

import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class HandlerOfWar {

	
		public static void closeRequester(Tab tab,TabPane tabPane,Event e) {
	 	   tabPane.getSelectionModel().select(tabPane.getTabs().size()-1); // setzte beim löschen immer aufs letzte element
	 	   schiessenDialog(tab,e);
	 	   setClosePolicy(tabPane,false); // closable neu organisieren // Woher bist du? add = true delete = false
	    }
	 	private static void schiessenDialog(Tab tab,Event e) {
	 		ButtonType type=closeDialog("Tab schließen?","Wollen Sie wirklich "+tab.getText()+" schließen? Alle Daten gehen verloren.");
	        	if(type==ButtonType.CANCEL) e.consume();
	 		
	 	}	
	 	public static ButtonType closeDialog(String title, String header){
	 	    Alert alert = new Alert(AlertType.CONFIRMATION);
	 	    alert.setTitle(title);
	 	    alert.setHeaderText(header);
	 	    Optional<ButtonType> option = alert.showAndWait();
	 	    return option.get();
	 	}
	 	private static void setClosePolicy(TabPane tabPane,boolean addOrDelete) {
			int anzahl=tabPane.getTabs().size();
			if(!addOrDelete)anzahl--;	//Tab wird erst am Ende des Request gelöscht also Anzahl - 1
			boolean answer=true;
			if(anzahl<=2) answer=false; //wenn nur noch "+" und ein Tab übrig sind -> not closable Tabs
			for(Tab tab:tabPane.getTabs()) tab.setClosable(answer);  //alle setzten. "+" implementiert eigene select methode
				
		}



}
