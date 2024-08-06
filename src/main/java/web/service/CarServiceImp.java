package web.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.config.MyConfig;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarServiceImp implements CarService {

    private List<Car> cars;

    public CarServiceImp() {
        cars = new ArrayList<>(5);
    }

    @Override
    public List<Car> getListCars(int count) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        cars.add(context.getBean(Car.class));
        cars.add(context.getBean(Car.class));
        cars.add(context.getBean(Car.class));
        cars.add(context.getBean(Car.class));
        cars.add(context.getBean(Car.class));

        if (count > cars.size()) {
            count = cars.size();
        }
        context.close();

        return cars.stream()
                .limit(count)
                .collect(Collectors.toList());
    }

}
