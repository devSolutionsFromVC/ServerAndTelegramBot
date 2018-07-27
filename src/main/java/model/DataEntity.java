package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DATA")
public class DataEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TEMPERATURE")
    private String temperature;

    @Column(name = "HUMIDITY")
    private String humidity;

    @Column(name = "PRESSURE")
    private String pressure;

    @Column(name = "MEASURE")
    private String measure;

    public DataEntity() {
    }

    public DataEntity(String temperature, String humidity, String pressure, String measure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.measure = measure;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }
}
