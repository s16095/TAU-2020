package zad1;

import java.util.HashMap;

public class CarRent {

    private HashMap<Integer, Car> cars = new HashMap<Integer, Car>();

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
}
