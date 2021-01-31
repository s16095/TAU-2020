package zad4;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Optional;

public class StatisticCarRent {

  private CarRent carRent;

  StatisticCarRent(CarRent carRent) {
    this.carRent = carRent;
  }

  public double avgCarProductionYear() {
    HashMap<Integer, Car> cars = this.carRent.getCars();
    double sum = cars.values().stream().map(Car::getProductionYear).reduce(0, Integer::sum);
    return sum/cars.size();
  }

  public int sumPrice() {
    HashMap<Integer, Car> cars = this.carRent.getCars();
    int sum = cars.values().stream().map(Car::getPrice).reduce(0, Integer::sum);
    return sum;
  }

  public Optional<Car> oldestCar() {
    HashMap<Integer, Car> cars = this.carRent.getCars();
    return cars.values().stream().min(Comparator.comparing(Car::getPrice));
  }
}
