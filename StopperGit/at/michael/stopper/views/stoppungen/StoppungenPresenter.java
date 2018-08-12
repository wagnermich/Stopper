package at.michael.stopper.views.stoppungen;

import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.Date;
import java.util.ResourceBundle;

import at.michael.stopper.handler.Inject;
import at.michael.stopper.model.Stoppung;
import at.michael.stopper.services.GUIService;
import at.michael.stopper.views.main.MainPresenter;
import at.michael.stopper.views.slot.SlotPresenter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;

public class StoppungenPresenter implements Initializable{

	@Inject	GUIService guiService;
	
	   @FXML private AnchorPane baseAnchor; // Value injected by FXMLLoader
	   @FXML private TableView<Stoppung> tableView; // Value injected by FXMLLoader
	   @FXML private TableColumn<Stoppung, String> zeitCol; // Value injected by FXMLLoader
	   @FXML  private TableColumn<Stoppung, String> dauerCol; // Value injected by FXMLLoader


	
	final ObservableList<Stoppung> data = FXCollections.observableArrayList(
			 new Stoppung("Jacob", "Smith"),
	            new Stoppung("Isabella", "Johnson"),
	            new Stoppung("Ethan", "Williams"),
	            new Stoppung("Emma", "Jones"),
	            new Stoppung("Michael", "Brown"));
	
	
	//final ObservableMap<Date,BigDecimal> stopItems = FXCollections.observableHashMap();
	private LocalTime lastTime=null;
	
	
	private MainPresenter mainPresenter;
	
	public void injectMainPresenter(MainPresenter main) {
		this.mainPresenter=main;
	}
	
	private String getText(Duration dur,boolean inMillis) {
		if(inMillis) return String.valueOf(dur.toMillis());
		else return ""+dur.toHours()+":"+dur.toMinutes()+":"+dur.toSeconds();
	}
	
	public void addStoppung(LocalTime now) {
		Duration timeSinceStart=Duration.between(guiService.getStartTime(), LocalTime.now());
		Duration duration=null;
		if(lastTime!=null) duration=Duration.between(lastTime, now);
		
		if(duration==null) {
			lastTime=now;
		}
		else {
			Stoppung stoppi=new Stoppung(getText(timeSinceStart,false),getText(duration,true));
			tableView.getItems().add(0,stoppi);
			data.add(stoppi);
			duration=null;
			lastTime=null;
		}
	
	}
	public void editCommit() {
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		 guiService=GUIService.getInstance();
	      
		
	        tableView.setEditable(true);
		this.zeitCol.setCellValueFactory(new PropertyValueFactory<Stoppung,String>("date"));
		this.zeitCol.setCellFactory(TextFieldTableCell.forTableColumn());
		this.dauerCol.setCellValueFactory(new PropertyValueFactory<Stoppung,String>("duration"));
		this.dauerCol.setCellFactory(TextFieldTableCell.forTableColumn());
		//tableView.getItems().setAll(data);
		
	}
	
	
}
