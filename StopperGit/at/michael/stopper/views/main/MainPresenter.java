package at.michael.stopper.views.main;

import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import XX.michael.stopper.views.stoppung.StoppungPresenter;
import XX.michael.stopper.views.stoppung.StoppungView;
import at.michael.stopper.handler.Inject;
import at.michael.stopper.services.GUIService;
import at.michael.stopper.views.benenner.BenennerPresenter;
import at.michael.stopper.views.benenner.BenennerView;
import at.michael.stopper.views.blatt.BlattPresenter;
import at.michael.stopper.views.blatt.BlattView;
import at.michael.stopper.views.ergebnis.ErgebnisPresenter;
import at.michael.stopper.views.ergebnis.ErgebnisView;
import at.michael.stopper.views.slot.SlotPresenter;
import at.michael.stopper.views.slot.SlotView;
import at.michael.stopper.views.steuerer.SteuererPresenter;
import at.michael.stopper.views.steuerer.SteuererView;
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
import javafx.scene.input.KeyEvent;
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
	  
	   	BlattView blattView=new BlattView();
		BlattPresenter blattPresenter =(BlattPresenter) blattView.getPresenter();
		blattPresenter.injectMainPresenter(this);
		tabPane.getTabs().add(1,blattPresenter.getNewTab(tabCounter++)); 
		blattPresenter.setClosePolicy(tabPane,true); // Woher bist du? add = true delete = false
		tabPane.getSelectionModel().select(1);
		tabItems.put(blattPresenter.getBlatt().getId(), blattPresenter);
		newStop();
	
   		
   }
   @FXML //Mouse click
   void dragMe(MouseEvent event) {
	   
	   
   }
   @FXML	//No Event needed
   void newStop() {
	   BlattPresenter blattPresenter=tabItems.get(tabPane.getSelectionModel().getSelectedItem().getId());//TabPresenter holen
	   blattPresenter.getAnchor().getChildren().add( blattPresenter.getNewStop()); //neues Stoppfeld einfügen
	   
   }
   public void showMeYourKey(KeyEvent e) {
	   BlattPresenter blatt=tabItems.get(tabPane.getSelectionModel().getSelectedItem().getId());
	   LocalTime now=LocalTime.now();
	   for (Entry<Integer, SlotPresenter> entry : blatt.getPresenters().entrySet()) {
		   if(e.getCharacter().equals(entry.getValue().getSteuerungsKey().toString())) {
			   entry.getValue().addStoppung(now);
		   }
	   }
	   
	   
	   
   }
    
	
	@FXML private void initialize() {
		
		//stoppungView = new StoppungView();
        //stoppungPresenter = (StoppungPresenter) stoppungView.getPresenter();
        //stoppungPresenter.injectMainPresenter(this);
        
        addNewTab();
        guiService=GUIService.getInstance();
        guiService.setAktuellerTabPane(tabPane);
        guiService.setStartTime(); // Bei Programmstart aktuelle Zeit
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
