package zad4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;

public class CarRent {

    private HashMap<Integer, Car> cars;

    public CarRent() {
      this.cars = new HashMap<>();
    }

    public CarRent(HashMap<Integer, Car> cars) {
      this.cars = cars;
    }

    public void addCar(Car car) throws CarExistException {
      Car existCar = cars.get(car.getId());
      if (existCar == null) {
        cars.put(car.getId(), car);
      } else {
        throw new CarExistException();
      }
    }

    public Car getCarById(int id) {
        return cars.get(id);
    }

    public int countCars() {
        return cars.size();
    }

    public HashMap<Integer, Car> getCars() {
        return cars;
    }

    public void deleteCarById(int id) {
      cars.remove(id);
    }

    public String carToJson(int id) throws JsonProcessingException {
      ObjectMapper mapper = new ObjectMapper();
      return mapper.writeValueAsString(this.getCarById(id));
    }

    public String carsToJson() throws JsonProcessingException {
      ObjectMapper mapper = new ObjectMapper();
      return mapper.writeValueAsString(this.getCars());
    }
}
