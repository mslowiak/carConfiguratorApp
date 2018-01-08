package carconf.car_assembling;

public class CustomizedCar{

    private CarContent carContent;
    private double totalPrice;


    public CustomizedCar(){
        carContent = new CarContent();
        totalPrice = 0;
    }

    public CarContent getCarContent() {
        return carContent;
    }

    public void setCarContent(CarContent carContent) {
        this.carContent = carContent;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
