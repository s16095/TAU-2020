package zad1;

import javax.management.InvalidAttributeValueException;

public class BadProductYearException extends InvalidAttributeValueException {
  public BadProductYearException() {
    super("Bad product year for car");
  }
}
