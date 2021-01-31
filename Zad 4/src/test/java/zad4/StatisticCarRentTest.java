package zad4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StatisticCarRentTest {

  @Mock
  private CarRent carRent;

  @InjectMocks
  private StatisticCarRent statisticCarRent;

  @Test
  public void avgCarProductionYearTest() throws BadProductYearException, BadPriceException {
    HashMap<Integer, Car> cars = new HashMap<Integer, Car>();
    Car car = new Car(1, "Audi a4", 2004, 10000);
    Car car2 = new Car(2, "Subaru", 2010, 30000);
    cars.put(car.getId(), car);
    cars.put(car2.getId(), car2);
    when(carRent.getCars()).thenReturn(cars);
    assertEquals(statisticCarRent.avgCarProductionYear(), 2007.0);
  }

  @Test
  public void calculateSumPriceTest() throws BadProductYearException, BadPriceException {
    HashMap<Integer, Car> cars = new HashMap<Integer, Car>();
    Car car = new Car(1, "Audi a4", 2004, 10000);
    Car car2 = new Car(2, "Subaru", 2010, 30000);
    cars.put(car.getId(), car);
    cars.put(car2.getId(), car2);
    given(carRent.getCars()).willReturn(cars);
    assertEquals(statisticCarRent.sumPrice(), 40000);
  }

  @Test
  public void oldestCarTest() throws BadProductYearException, BadPriceException {
    HashMap<Integer, Car> cars = new HashMap<Integer, Car>();
    Car car = new Car(1, "Audi a4", 2004, 10000);
    Car car2 = new Car(2, "Subaru", 2010, 30000);
    cars.put(car.getId(), car);
    cars.put(car2.getId(), car2);
    given(carRent.getCars()).willReturn(cars);
    assertEquals(statisticCarRent.oldestCar().get(), car);
  }

  @Test
  public void avgCarProductionYearStubTest() throws BadProductYearException, BadPriceException {
    HashMap<Integer, Car> cars = new HashMap<Integer, Car>();
    Car car = new Car(1, "Audi a4", 2004, 10000);
    Car car2 = new Car(2, "Subaru", 2010, 30000);
    cars.put(car.getId(), car);
    cars.put(car2.getId(), car2);
    CarRent carRent = new CarRent(cars);
    StatisticCarRent statisticCarRent = new StatisticCarRent(carRent);
    assertEquals(statisticCarRent.avgCarProductionYear(), 2007.0);
  }

  @Test
  public void calculateSumPriceStubTest() throws BadProductYearException, BadPriceException {
    HashMap<Integer, Car> cars = new HashMap<Integer, Car>();
    Car car = new Car(1, "Audi a4", 2004, 10000);
    Car car2 = new Car(2, "Subaru", 2010, 30000);
    cars.put(car.getId(), car);
    cars.put(car2.getId(), car2);
    CarRent carRent = new CarRent(cars);
    StatisticCarRent statisticCarRent = new StatisticCarRent(carRent);
    assertEquals(statisticCarRent.sumPrice(), 40000);
  }

  @Test
  public void oldestCarStubTest() throws BadProductYearException, BadPriceException {
    HashMap<Integer, Car> cars = new HashMap<Integer, Car>();
    Car car = new Car(1, "Audi a4", 2004, 10000);
    Car car2 = new Car(2, "Subaru", 2010, 30000);
    cars.put(car.getId(), car);
    cars.put(car2.getId(), car2);
    CarRent carRent = new CarRent(cars);
    StatisticCarRent statisticCarRent = new StatisticCarRent(carRent);
    assertEquals(statisticCarRent.oldestCar().get(), car);
  }
}
