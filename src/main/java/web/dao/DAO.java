package web.dao;

import web.models.Car;

import java.util.List;
import java.util.stream.Collectors;

public interface DAO {
    List<Car> getCars(int count);

    List<Car> getAllCars();
}
