package unimi.redmerska.anna.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import unimi.redmerska.anna.CleaningRobot;

public class MQTTPublisher extends Thread {

    private MqttClient client;

    private String brokerAddress;

    private int sendDataInterval;

    private CleaningRobot robot;

    public MQTTPublisher(String brokerAddress, int sendDataInterval, CleaningRobot robot) {
        this.brokerAddress = brokerAddress;
        this.sendDataInterval = sendDataInterval;
        this.robot = robot;
    }

    public void connect() {
        try {
            connectWithMqtt(brokerAddress);
            System.out.println("Connected to the broker.");
        } catch (MqttException e) {
            System.out.println("Couldn't connect to the broker.");
        }
    }

    private void connectWithMqtt(String broker) throws MqttException {
        String clientId = MqttClient.generateClientId();
        client = new MqttClient(broker, clientId);

        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);

        client.connect(connOpts);
    }

    private void sendMessage(String message, String topic) throws MqttException {
        MqttMessage m = new MqttMessage(message.getBytes());
        m.setQos(2);
        client.publish(topic, m);
    }

    public void run() {
        long time = System.currentTimeMillis();
        long lastTime = time;
        while(true) {
            if(time - lastTime >= sendDataInterval) {
                lastTime = time;
                String message = robot.createMqttMessage();
                String topic = "greenfield/pollution/district" + robot.getDistrict();
                try {
                    System.out.println("Sending message with measurements to the server: " + message);
                    sendMessage(message, topic);
                } catch (MqttException e) {
                    System.out.println("The data couldn't be send.");
                }
            }
            time = System.currentTimeMillis();
        }
    }
}
