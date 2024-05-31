package unimi.redmerska.anna;

import unimi.redmerska.anna.tools.Position;

public class CleaningRobot {
    public final int id;
    public final int district;
    public final int port;
    public Position position;
    public final String address;

    private static int nextID = 1;
    private static int nextGrpcPort = 5000;

    public CleaningRobot(int id, int district, int port, Position position, String address) {
        this.id = id;
        this.district = district;
        this.port = port;
        this.position = position;
        this.address = address;
    }

    public static int assignID() {
        return nextID++;
    }

    public static int assignGrpcPort() {
        return nextGrpcPort++;
    }

    @Override
    public String toString(){
        return String.valueOf(id) + ";" + String.valueOf(district) + ";" + String.valueOf(port) + ";" + String.valueOf(position.x) + ";" + String.valueOf(position.y) + ";";
    }
}
