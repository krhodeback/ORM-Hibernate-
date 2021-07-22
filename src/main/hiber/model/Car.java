package hiber.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @Column(name = "series")
    private Long series;

    @Column(name = "model")
    private String model;

    public Car() {
    }

    public Car(String model, Long series) {
        super();
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public Long getSeries() {
        return series;
    }

    @Override
    public String toString() {
        return "Car [series=" + series + ", model=" + model + "]";
    }

}
