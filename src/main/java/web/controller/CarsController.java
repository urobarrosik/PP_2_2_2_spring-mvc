package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarsController {

    private CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String printCarsList(Model model,
                                @RequestParam(value = "count", required = false, defaultValue = "5") int count) {
//Если пользователь передаст значение количества машин не цифрой, то вылетит ошибка((
//        int intCount;
//        try {
//            intCount = Integer.parseInt(count);
//        } catch (NumberFormatException e) {
//            return "CountError";
//        }

        List<Car> cars = carService.getListCars(count);

        model.addAttribute("cars", cars);

        return "Cars";
    }

}