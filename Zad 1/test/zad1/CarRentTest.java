package zad1;

import org.junit.*;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class CarRentTest {

  private CarRent carRent;

  @Before
  public void setUp() {
    carRent = new CarRent();
  }

  @Test
  public void testCountZeroCars() {
    assertEquals(0, carRent.countCars());
  }

  @Test
  public void testAddCarAndCountAmount() throws BadProductYearException, BadPriceException, CarExistException {
    Car car = new Car(1, "Audi a4", 2004, 10000);
    carRent.addCar(car);
    assertEquals(1, carRent.countCars());
  }

  @Test
  public void testAddCarAndGetByID() throws BadProductYearException, BadPriceException, CarExistException {
    Car car = new Car(1, "Audi a4", 2004, 10000);
    Car car2 = new Car(2, "Subaru", 2010, 30000);
    carRent.addCar(car);
    carRent.addCar(car2);

    assertEquals(carRent.getCarById(1), car);
    assertEquals(carRent.getCarById(2), car2);
  }

  @Test
  public void testCarRentHashMap() throws BadProductYearException, BadPriceException, CarExistException {
    HashMap<Integer, Car> cars = new HashMap<Integer, Car>();
    Car car = new Car(1, "Audi a4", 2004, 10000);
    Car car2 = new Car(2, "Subaru", 2010, 30000);
    cars.put(car.getId(), car);
    cars.put(car2.getId(), car2);

    carRent.addCar(car);
    carRent.addCar(car2);

    assertEquals(carRent.getCars(), cars);
  }


}
