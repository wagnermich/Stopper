package at.michael.stopper.views.main;

import java.util.Collection;
import java.util.List;

import at.michael.stopper.handler.Inject;
import at.michael.stopper.services.GUIService;
import at.michael.stopper.views.blatt.BlattPresenter;
import at.michael.stopper.views.blatt.BlattView;
import at.michael.stopper.views.slot.SlotPresenter;
import at.michael.stopper.views.slot.SlotView;
import at.michael.stopper.views.stoppung.StoppungPresenter;
import at.michael.stopper.views.stoppung.StoppungView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;


public class MainPresenter {

	@Inject
	GUIService guiService;
	
	@FXML private AnchorPane baseAnchor;

    @FXML private VBox vBox;

    @FXML private AnchorPane menuAnchor;

    @FXML private ToolBar toolBar;

    @FXML private AnchorPane tabAnchor;

    @FXML private TabPane tabPane;
    
    
    @FXML private Button neuesBlattButton; // Value injected by FXMLLoader

    @FXML private Tab addTab;
    
    @FXML private AnchorPane blatt1Anchor;
    
    @FXML private Button neueStoppungButton;
    
   @FXML private StoppungView stoppungView;
    
    @FXML private StoppungPresenter stoppungPresenter;
    
    @FXML private BlattView blattView;
    
    @FXML private BlattPresenter blattPresenter;
    
    private int tabCounter=1;  //Erstes Blatt heißt 1
    private Tab aktuellerTab;
    final ObservableMap<String,BlattPresenter> tabItems = FXCollections.observableHashMap();

    private void bindAnchors() {
    	//verankern(vBox);
    	//verankern(toolBar);
    	//verankern(tabPane);
    	tabAnchor.prefHeightProperty().bind(vBox.heightProperty());  //ein bißchen extra binding
    	
    }
    private void verankern(Node node, double padding) {
	   	AnchorPane.setBottomAnchor(node, padding);
   		AnchorPane.setRightAnchor(node, padding);
   		AnchorPane.setTopAnchor(node, padding);
   		AnchorPane.setLeftAnchor(node, padding);
   }
   private void verankern(Node node) {
	   	verankern(node, 0.0);
  	
  }
   
	
//	final private void setClosePolicy(boolean addOrDelete) {
//		int anzahl=tabPane.getTabs().size();
//		if(!addOrDelete)anzahl--;	//Tab wird erst am Ende des Request gelöscht also Anzahl - 1
//		boolean answer=true;
//		if(anzahl<=2) answer=false; //wenn nur noch "+" und ein Tab übrig sind -> not closable Tabs
//		for(Tab tab:tabPane.getTabs()) tab.setClosable(answer);  //alle setzten. "+" implementiert eigene select methode
//			
//	}
	
	
	public TabPane getAnchorTab() {
		return tabPane;
	}
	public void setAktuellerTab(Tab tab) {
		aktuellerTab=tab;
	}
	
	
	/**
	 * get new Tab by File!!!!!!!! selection model kann so nicht funktieren!!!!!
	 */
	
   private void addNewTab() {
	  
	   	blattView=new BlattView();
		blattPresenter =(BlattPresenter) blattView.getPresenter();
		blattPresenter.injectMainPresenter(this);
		tabPane.getTabs().add(1,blattPresenter.getNewTab(tabCounter++)); 
		blattPresenter.setClosePolicy(tabPane,true); // Woher bist du? add = true delete = false
		tabPane.getSelectionModel().select(1);
		tabItems.put(blattPresenter.getBlatt().getId(), blattPresenter);
		//blattPresenter.injectTab(stoppItems);
		//blattPresenter.getBlatt(),(HBox)blattPresenter.getAnchor());
		
   		
   }
   @FXML //Mouse click
   void dragMe(MouseEvent event) {
	   
	   
   }
   @FXML	//No Event needed
   void newStop() {
	   SlotView slot=new SlotView();
	   SlotPresenter presenter =(SlotPresenter) slot.getPresenter();
	   presenter.injectMainPresenter(this);
	   BlattPresenter blattPresenter=tabItems.get(tabPane.getSelectionModel().getSelectedItem().getId());
	   blattPresenter.getAnchor().getChildren().add(slot.getView());
	   //System.out.println(blattPresenter.getAnchor());
	   
	   
	   //stoppItems.addAll(tabCounter,(AnchorPane) slot.getView());
	   
	   //System.out.println(tabPane.getSelectionModel().getSelectedItem().getId());
	   //TabPane tempPane=guiService.getAktuellerTabPane();
	   //System.out.println(tempPane);
	   //System.out.println(guiService.getAktuellerTab());
	   //AnchorPane anchor=new AnchorPane();
	   //anchor.setId("newView");
	   //anchor.getChildren().add(view.getView());
	   //HBox hbox=(HBox)stoppungPresenter.getAnchor();
	   //Tab tempTab=tempPane.getSelectionModel().getSelectedItem();
	   //tempTab.setContent(view.getView());
	   //if(tempTab!=null)
		   ;//System.out.println(((Pane) tempTab.getContent()).getChildren().get(0));
	   //System.out.println(((WebView) tempTab.getContent()));
	   
	   //for(Node node : ((AnchorPane) tempTab.getContent()).getChildren())
		//   System.out.println(node);
	   
	   //hbox.getChildren().add(anchor);
	   //System.out.println("binde: "+anchor.getId()+" an: "+hbox.getId());
	   
   }
    
	
	@FXML private void initialize() {
		
		stoppungView = new StoppungView();
        stoppungPresenter = (StoppungPresenter) stoppungView.getPresenter();
        //stoppungPresenter.injectMainPresenter(this);
        
        addNewTab();
        guiService=GUIService.getInstance();
        guiService.setAktuellerTabPane(tabPane);
        bindAnchors();
		addTab.setOnSelectionChanged(e->{if(addTab.isSelected()) {addNewTab();}});//new TabRequester //Bug Key Select löst aus
		//tabPane.getSelectionModel().select(1);//blatt1 Select
		
		//verankern(stoppungView.getView());//Verankern in dieser Dimension
		/*
         * Properties of any type can be easily injected.
         */
        //Map<Object, Object> customProperties = new HashMap<>();
        //customProperties.put("bindParent", blatt1Anchor);
        /*
         * any function which accepts an Object as key and returns
         * and return an Object as result can be used as source.
         */
        //InjectionHandler.setConfigurationSource(customProperties::get);
		
        //aktuellerTab.getChildren().add(stoppungView.getView());
	}	
}
