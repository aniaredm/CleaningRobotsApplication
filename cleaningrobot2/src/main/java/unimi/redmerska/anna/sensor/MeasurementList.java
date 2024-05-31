package unimi.redmerska.anna.sensor;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class MeasurementList implements Buffer {
    private List<Measurement> measurements;
    private List<Measurement> avgList;
    private int counter = 8;

    public MeasurementList(){
        measurements = new ArrayList<>();
        avgList = new ArrayList<>();
    }

    private Measurement calculateAvg(List<Measurement> ml){
        if (ml.size() == 0){
            return null;
        }
        double sum = 0;
        for (Measurement m : ml){
            sum += m.getValue();
        }
        String id = ml.get(0).getId();
        String type = ml.get(0).getType();
        double avg = sum/ml.size();
        long currTime = System.currentTimeMillis();
        return new Measurement(id, type, avg, currTime);
    }

    @Override
    public void addMeasurement(Measurement m) {
        measurements.add(m);
        if (measurements.size() == 8){
            Measurement avg = calculateAvg(measurements);
            avgList.add(avg);
            measurements = measurements.subList(4,8);
        }
    }

    @Override
    public List<Measurement> readAllAndClean() {
        List<Measurement> avgListCopy = new ArrayList<>(avgList);
        avgList.clear();
        return avgListCopy;
    }
}
