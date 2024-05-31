package unimi.redmerska.anna;

import java.util.List;

public class Measurement {
    private int robotId;
    private String timestamp;
    private List<Float> measurements;

    public Measurement(int robotId, String timestamp, List<Float> measurements){
        this.robotId = robotId;
        this.timestamp = timestamp;
        this.measurements = measurements;
    }

    public int getRobotId() {
        return robotId;
    }

    public String getTimestamp(){
        return timestamp;
    }

    public List<Float> getMeasurements(){
        return measurements;
    }
}
