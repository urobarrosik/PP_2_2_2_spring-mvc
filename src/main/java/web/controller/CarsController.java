package web.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.config.MyConfig;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarsController {

    @GetMapping(value = "/cars")
    public String printCarsList(Model model,
                                @RequestParam(value = "count", required = false, defaultValue = "5") String count) {
        int intCount;
        try {
            intCount = Integer.parseInt(count);
        } catch (NumberFormatException e) {
            return "CountError";
        }
        if (intCount > 5) {
            intCount = 5;
        }
        if (intCount < 0) {
            intCount = 0;
        }

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        List<Car> cars = context.getBean(CarService.class).getListCars(intCount);

        model.addAttribute("cars", cars);

        context.close();

        return "Cars";
    }

}