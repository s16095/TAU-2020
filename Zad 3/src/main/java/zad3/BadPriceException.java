package zad3;

import javax.management.InvalidAttributeValueException;

public class BadPriceException extends InvalidAttributeValueException {
  public BadPriceException() {
    super("Bad price for car");
  }
}
