package unimi.redmerska.anna;

import unimi.redmerska.anna.mqtt.MQTTSubscriber;
import unimi.redmerska.anna.rest.RESTServer;


public class AdminServer {
    private MQTTSubscriber subscriber;
    private static final String MQTT_BROKER_ADDRESS = "tcp://localhost:1883";

    private RESTServer restSrv;
    private static final int REST_SERVER_PORT = 1337;
    private static final String REST_SERVER_ADDRESS = "localhost";

    public AdminServer(){
        subscriber = new MQTTSubscriber(MQTT_BROKER_ADDRESS, 10000);
        subscriber.start();
        restSrv = new RESTServer(REST_SERVER_ADDRESS, REST_SERVER_PORT);
    }
}