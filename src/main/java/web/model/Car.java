package web.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//Не понял замечание про DI, а точнее на чём или где его использовать, пока пытался понять - сделал добавление машин
//через бины скоупа prototype, но тут тоже DI особо не пригодился.
@Component
@Scope("prototype")
public class Car {

    private String model = "Audi";

    private  int series;

    private  int price;

    private static int seriesCount;
    private static int priceCount;

    public Car() {
        series = 11111 + seriesCount;
        price = 1111111 + priceCount;
    }

    @PostConstruct
    public void init() {
        seriesCount = seriesCount + 11111;
        priceCount = priceCount + 1030500;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model = '" + model + '\'' +
                ", series = '" + series + '\'' +
                ", price = " + price +
                '}';
    }
}
