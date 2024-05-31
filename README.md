# Cleaning Robot Management System for Smart City

## Project description
In a smart city named Greenfield, a fleet of robots moves around the districts of the city to clean their streets. 
The cleaning robots move around the four smart city districts. Occasionally, such robots need to go for maintenance issues to the mechanic of Greenfield, which can handle only a single robot at a time. Each robot is also equipped with a sensor that periodically detects the air pollution levels of Greenfield. Such pollution measurements are periodically transmitted from the robots of each district to an Administrator Server through MQTT. The administrator Server is in charge of dynamically registering and removing cleaning robots from the system. Moreover, it collects and analyses the air pollution levels of Greenfield in order to provide pollution information to the experts (Administrator Client) of the environmental department of Greenfield.
This project involves the implementation of the Administrator Server, the Administrator Client, and a peer-to-peer system of cleaning robots that periodically send pollution measurements to the Administrator Server through MQTT, and autonomously organize themselves through gRPC when they concurrently need to go to the mechanic of the smart city.

## Implemented components
1. **MQTT Broker**:
    - the MQTT broker on which the cleaning robots publish air pollution measurements

2. **Cleaning Robot**:
    - a cleaning robot of Greenfield

3. **Administrator Server**:
    -  REST server that dynamically adds/removes cleaning robots from the network and computes statistics about the air pollution measurements received by subscribing to the MQTT Broker

4. **Administrator Client**:
    - a client that queries the Administrator Server to obtain information about the statistics of the air pollution levels of Greenfield

