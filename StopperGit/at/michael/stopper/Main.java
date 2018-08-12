package at.michael.stopper;

	
import at.michael.stopper.handler.InjectionHandler;
import at.michael.stopper.views.main.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	 public void start(Stage stage) throws Exception {
	        MainView appView = new MainView();
	        Scene scene = new Scene(appView.getView());
	        stage.setTitle("Stopper");
	        final String uri = getClass().getResource("application.css").toExternalForm();
	        scene.getStylesheets().add(uri);
	        stage.setScene(scene);
	        stage.show();
	    }

	   @Override
	   public void stop() throws Exception {
	       InjectionHandler.forgetAll();
	    }
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
