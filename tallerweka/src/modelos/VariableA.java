/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author mario
 */
public class VariableA {
    private String timestamp;
    private String temperature;
    private String humidity;
    private String speed;

    public VariableA(String timestamp, String temperature, String humidity, String speed) {
        this.timestamp = timestamp;
        this.temperature = temperature;
        this.humidity = humidity;
        this.speed = speed;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
    
}
