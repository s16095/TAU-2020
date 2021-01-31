package zad4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CarTests {

  @Test
  public void setPriceTest() throws BadPriceException {
    Car car = new Car();
    int price = 10000;
    car.setPrice(price);
    assertEquals(car.getPrice(), price);
  }

  @Test
  public void setPriceTestThrowException() {
    Car car = new Car();
    int price = -10000;
    Exception exception = assertThrows(BadPriceException.class, () -> {
      car.setPrice(price);
    });
    String expectedMessage = "Bad price for car";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  public void setProductionYearTest() throws BadProductYearException {
    Car car = new Car();
    int productionYear = 1995;
    car.setProductionYear(productionYear);
    assertEquals(car.getProductionYear(), productionYear);
  }

  @Test
  public void setProductionYearTooHighThrowException() {
    Car car = new Car();
    int productionYear = 2022;
    Exception exception = assertThrows(BadProductYearException.class, () -> car.setProductionYear(productionYear));
    String expectedMessage = "Bad product year for car";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  public void setProductionYearTooLowThrowException() {
    Car car = new Car();
    int productionYear = 1945;
    Exception exception = assertThrows(BadProductYearException.class, () -> car.setProductionYear(productionYear));
    String expectedMessage = "Bad product year for car";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
  }
}
