package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImp implements CarService {

    private List<Car> cars;

    public CarServiceImp() {
        cars = new ArrayList<>(5);
        cars.add(new Car("Lada", "H2341285", 1500999));
        cars.add(new Car("Audi", "M54684512", 4700999));
        cars.add(new Car("Ferrari", "Z1245896", 9900999));
        cars.add(new Car("Lexus", "C4865234", 7200999));
        cars.add(new Car("Toyota", "S7864238", 2900999));
    }

    @Override
    public List<Car> getListCars(int count) {
        if (count < 0) {
            count = 0;
        }
        return cars.stream()
                .limit(count)
                .collect(Collectors.toList());
    }

}
