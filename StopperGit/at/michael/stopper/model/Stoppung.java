package at.michael.stopper.model;

import javafx.beans.property.SimpleStringProperty;

public class Stoppung {
    private final SimpleStringProperty time;
    private final SimpleStringProperty duration;
   
 
    public Stoppung(String time, String duration) {
        this.time = new SimpleStringProperty(time);
        this.duration = new SimpleStringProperty(duration);
     }
 
    public String getTime() {
        return time.get();
    }
    public void setTime(String time) {
        this.time.set(time);
    }
        
    public String getDuration() {
        return duration.get();
    }
    public void setDuration(String duration) {
        this.duration.set(duration);
    }
    
    
        
}