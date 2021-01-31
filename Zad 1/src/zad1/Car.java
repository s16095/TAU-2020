package zad1;

public class Car {

  private int id;
  private String name;
  private int productionYear;
  private int price;

  public Car(int id, String name, int productionYear, int price) throws BadPriceException, BadProductYearException {
    setId(id);
    setName(name);
    setProductionYear(productionYear);
    setPrice(price);
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getProductionYear() {
    return productionYear;
  }

  public void setProductionYear(int productionYear) throws BadProductYearException {
    if (productionYear <= 1950 || productionYear > 2021) {
      throw new BadProductYearException();
    } else {
      this.productionYear = productionYear;
    }
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) throws BadPriceException {
    if (price <= 0) {
      throw new BadPriceException();
    } else {
      this.price = price;
    }
  }

  public void setId(int id) {
    this.id = id;
  }
}
