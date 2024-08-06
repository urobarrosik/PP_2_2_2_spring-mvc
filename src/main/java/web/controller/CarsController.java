package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImp;

import java.util.List;

@Controller
public class CarsController {

	@GetMapping(value = "/cars")
	public String printCarsList(Model model,
								@RequestParam(value = "count", required = false, defaultValue = "9999") String count) {
		if (count.equals("9999")) {
			return "Car";
		}
		int intCount;
		try {
			intCount = Integer.parseInt(count);
		} catch (NumberFormatException e) {
			return "CountError";
		}
		if (intCount > 5) {intCount = 5;}
		if (intCount < 0) {intCount = 0;}

		List<Car> cars = new CarServiceImp().getListCars(intCount);

		model.addAttribute("cars", cars);
		return "Cars";
	}
	
}