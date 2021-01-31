package zad3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;

public class CarRentTests {

  private CarRent carRent;

  @Before
  public void setUp() {
    carRent = new CarRent();
  }

  @Test
  public void testCountZeroCarsTest() {
    assertEquals(0, carRent.countCars());
  }

  @Test
  public void testAddCarAndCountAmountTest() throws BadProductYearException, BadPriceException, CarExistException {
    Car car = new Car(1, "Audi a4", 2004, 10000);
    carRent.addCar(car);
    assertEquals(1, carRent.countCars());
  }

  @Test
  public void testAddCarThrowExceptionTest() throws BadProductYearException, BadPriceException, CarExistException {
    Car car = new Car(1, "Audi a4", 2004, 10000);
    carRent.addCar(car);

    Exception exception = assertThrows(CarExistException.class, () -> carRent.addCar(car));
    String expectedMessage = "Car exist in map";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  public void testAddCarAndGetByIDTest() throws BadProductYearException, BadPriceException, CarExistException {
    Car car = new Car(1, "Audi a4", 2004, 10000);
    Car car2 = new Car(2, "Subaru", 2010, 30000);
    carRent.addCar(car);
    carRent.addCar(car2);

    assertEquals(carRent.getCarById(1), car);
    assertEquals(carRent.getCarById(2), car2);
    assertNull(carRent.getCarById(3));
  }

  @Test
  public void testCarRentHashMapTest() throws BadProductYearException, BadPriceException, CarExistException {
    HashMap<Integer, Car> cars = new HashMap<Integer, Car>();
    Car car = new Car(1, "Audi a4", 2004, 10000);
    Car car2 = new Car(2, "Subaru", 2010, 30000);
    cars.put(car.getId(), car);
    cars.put(car2.getId(), car2);

    carRent.addCar(car);
    carRent.addCar(car2);

    assertEquals(carRent.getCars(), cars);
  }

  @Test
  public void removeCarByIdTest() throws CarExistException, BadProductYearException, BadPriceException {
    Car car = new Car(1, "Audi a4", 2004, 10000);
    Car car2 = new Car(2, "Subaru", 2010, 30000);
    carRent.addCar(car);
    carRent.addCar(car2);
    assertEquals(carRent.getCars().size(), 2);

    carRent.deleteCarById(1);
    assertEquals(carRent.getCars().size(), 1);
  }

  @Test
  public void carToJsonTestTest() throws CarExistException, BadProductYearException, BadPriceException, JsonProcessingException {
    Car car = new Car(1, "Audi a4", 2004, 10000);
    carRent.addCar(car);

    String carToJson = carRent.carToJson(1);
    assertEquals(carToJson, "{\"id\":1,\"name\":\"Audi a4\",\"productionYear\":2004,\"price\":10000}");
  }

  @Test
  public void carsToJsonTestTest() throws CarExistException, BadProductYearException, BadPriceException, JsonProcessingException {
    Car car = new Car(1, "Audi a4", 2004, 10000);
    Car car2 = new Car(2, "Subaru", 2010, 30000);
    carRent.addCar(car);
    carRent.addCar(car2);

    String carsToJson = carRent.carsToJson();
    assertEquals(carsToJson, "{\"1\":{\"id\":1,\"name\":\"Audi a4\",\"productionYear\":2004,\"price\":10000},\"2\":{\"id\":2,\"name\":\"Subaru\",\"productionYear\":2010,\"price\":30000}}");
  }

}
