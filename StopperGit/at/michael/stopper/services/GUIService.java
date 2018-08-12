package at.michael.stopper.services;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import at.michael.stopper.handler.PostConstruct;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.web.WebView;

public class GUIService {

	//Vorsicht der Contructor löst fehler aus.
	
	private TabPane aktuellerTabPane;
	private Tab aktuellerTab;
	private boolean test=true;
	private WebView aktuellerTabView;
	private LocalTime startPoint;
	
	private static GUIService guiService;

	   public static synchronized GUIService getInstance( ) {
	      if (guiService == null)
	          guiService=new GUIService();
	      return guiService;
	   }
	
	 @PostConstruct
	 public void init() {
	     }

	public String antworte() {return "der Test ist: ";}
	
	
	public boolean getTest() {
		return test;
	}
	public void setTest(boolean test) {
		this.test = test;
	}
	public TabPane getAktuellerTabPane() {
		return aktuellerTabPane;
	}
	public void setAktuellerTabPane(TabPane aktuellerTabPane) {
		this.aktuellerTabPane = aktuellerTabPane;
	}
	public Tab getAktuellerTab() {
		return aktuellerTab;
	}
	public void setAktuellerTab(Tab aktuellerTab) {
		this.aktuellerTab = aktuellerTab;
	}

	public WebView getAktuellerTabView() {
		return aktuellerTabView;
	}

	public void setAktuellerTabView(WebView aktuellerTabView) {
		this.aktuellerTabView = aktuellerTabView;
	}
	
	public void setStartTime() {
		this.startPoint=LocalTime.now();
	}
	public LocalTime getStartTime() {
		return this.startPoint;
	}
	
	
	
}
