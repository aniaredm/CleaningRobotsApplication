package unimi.redmerska.anna.mqtt;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import unimi.redmerska.anna.Measurement;
import unimi.redmerska.anna.MeasurementsManager;

public class MQTTSubscriber extends Thread {
    
    private MqttClient client;

    private String brokerAddress;

    private static final String TOPIC = "greenfield/pollution/#";

    private int subscriberTimeout;

    public MQTTSubscriber(String brokerAddress, int subscriberTimeout) {
        this.brokerAddress = brokerAddress;
        this.subscriberTimeout = subscriberTimeout;
    }

    private void connectWithMqtt(String broker) throws MqttException {
        String clientId = MqttClient.generateClientId();
        client = new MqttClient(broker, clientId);
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        client.connect(connOpts);
        System.out.println("MQTT: Successfully connected to the broker.");

        client.setCallback(new MqttCallback() {
            @Override
            public void messageArrived(String topic, MqttMessage message) {
                String receivedMqttMessage = new String(message.getPayload());
                System.out.println("Received MqttMessage: " + receivedMqttMessage);
                Measurement measurement = parseMqttMessage(receivedMqttMessage);
                MeasurementsManager.getInstance().addMeasurement(measurement);
            }

            @Override
            public void connectionLost(Throwable cause) {
                System.out.println("MQTT: Connection lost! cause:" + cause.getMessage());
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {}

        });
    }

    public void run() {
        long time = System.currentTimeMillis();
        long lastTime = 0;

        while(true) {
            if(time - lastTime >= subscriberTimeout) {
                try {
                    connectWithMqtt(brokerAddress);
                    client.subscribe(TOPIC, 2);
                } catch (MqttException e) {
                    System.out.println("MQTT: Couldn't connect to the broker.");
                }
                lastTime = time;
            }
            time = System.currentTimeMillis();
        }
    }

    
    private Measurement parseMqttMessage(String mqttMessage){
        String[] data = mqttMessage.split(",");
        int robotId = Integer.parseInt(data[0]);
        String timestamp = data[1];
        List<Float> measurements = new ArrayList<>();
        String[] ms = data[2].split(" ");
        for(String value : ms){
            measurements.add(Float.parseFloat(value));
        }
        return new Measurement(robotId, timestamp, measurements);
    }
}
