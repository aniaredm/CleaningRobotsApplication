package unimi.redmerska.anna;

import java.util.*;

public class MeasurementsManager{
    private static final MeasurementsManager MEASUREMENTS_MANAGER = new MeasurementsManager();

    public static MeasurementsManager getInstance(){
        return MEASUREMENTS_MANAGER;
    }

    private List<Measurement> measurements;
    private MeasurementsManager(){
        measurements = new ArrayList<>();
    }

    public void addMeasurement(Measurement measurement){
        measurements.add(measurement);
    }

    private Float getAverage(int id, int n){
        List<Float> m = new ArrayList<Float>();
        int initialN = n;
        boolean validId = false;
        for (Measurement measurement : measurements){
            System.out.println(id + " " + measurement.getRobotId());
            if (measurement.getRobotId() == id){
                validId = true;
                List<Float> copy = measurement.getMeasurements();
                if (copy.size() < n){
                    m.addAll(copy);
                    n -= copy.size();
                }
                else{
                    for (int i = 0; i < n; i++) {
                        m.add(copy.get(i));
                    }
                    break;
                }
            }
        }
        if (!validId){
            return -1.0f;
        }
        return computeAvg(m, initialN);
    }

    private float computeAvg(List<Float> m, int n){
        float sum = 0.0f;
        for (Float f : m) sum += f;
        return sum/(float)n;
    }

    public String toString(int id, int n){
        String s = "";
        s += String.valueOf(getAverage(id, n));
        return s;
    }

    private List<Float> getMeasurementsInTimestampList(long t1, long t2){
        List<Measurement> measurementsCopy = measurements;
        Collections.sort(measurementsCopy, new Comparator<Measurement>(){
            public int compare(Measurement m1, Measurement m2) {
                // compare two instance of `Score` and return `int` as result.
                return m2.getTimestamp().compareTo(m1.getTimestamp());
            }
        });
        List<List<Float>> measurementsInTimestamp = new ArrayList<>();
        for (Measurement m : measurementsCopy){
            System.out.println(m.getTimestamp());
            System.out.println(Long.parseLong(m.getTimestamp()));
            if (Long.parseLong(m.getTimestamp())>=t1 && Long.parseLong(m.getTimestamp())<=t2){
                measurementsInTimestamp.add(m.getMeasurements());
            }
        }
        List<Float> list = new ArrayList<>();
        for (List<Float> floatList : measurementsInTimestamp){
            list.addAll(floatList);
        }
        return list;
    }

    public String getMessage(long t1, long t2){
        List<Float> measurementsInTimestamp = getMeasurementsInTimestampList(t1, t2);
        int n = measurementsInTimestamp.size();
        float result = computeAvg(measurementsInTimestamp, n);
        return String.valueOf(result);
    }

}
