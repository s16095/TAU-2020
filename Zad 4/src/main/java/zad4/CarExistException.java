package zad4;

import javax.management.InvalidAttributeValueException;

public class CarExistException extends InvalidAttributeValueException {
  public CarExistException() {
    super("Car exist in map");
  }
}
