package web.dao;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class CarDAO implements DAO{
    private static int CAR_COUNT;
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car(++CAR_COUNT, "Nissan", "Blue"));
        cars.add(new Car(++CAR_COUNT, "BMW", "Ellow"));
        cars.add(new Car(++CAR_COUNT, "Honda", "Red"));
        cars.add(new Car(++CAR_COUNT, "Audi", "White"));
        cars.add(new Car(++CAR_COUNT, "Ford", "Gray"));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count >=5){
            return cars;
        }
       return cars.stream().limit(count).collect(Collectors.toList());
    }

    @Override
    public List<Car> getAllCars() {
        return cars;
    }

}
