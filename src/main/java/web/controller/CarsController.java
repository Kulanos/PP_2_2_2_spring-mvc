package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDAO;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CarsController {

    private final CarDAO carDAO;

    @Autowired
    public CarsController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping("/cars")
    public String cars(@RequestParam(value = "count", required = false) Integer count, Model model) {
        if (count != null && count < 5) {
            model.addAttribute("cars", carDAO.getCars(count));
        } else {
            model.addAttribute("cars", carDAO.getAllCars());
        }

       return "cars";
    }


}
