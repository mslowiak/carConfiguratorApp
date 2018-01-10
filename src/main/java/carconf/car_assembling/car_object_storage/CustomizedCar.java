package carconf.car_assembling.car_object_storage;

public class CustomizedCar{

    private CarContent carContent;
    private double totalPrice;


    public CustomizedCar(){
        carContent = new CarContent();
        totalPrice = 0;
    }

    public CustomizedCar(CarContent carContent, double totalPrice) {
        this.carContent = carContent;
        this.totalPrice = totalPrice;
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

    public CustomizedCarMemento createMemento() {
        return new CustomizedCarMemento(carContent, totalPrice);
    }

    public static CustomizedCar createCustomizedCar(CustomizedCarMemento memento) {
        return new CustomizedCar(memento.carContent, memento.totalPrice);
    }

    public static class CustomizedCarMemento {
        private final CarContent carContent;
        private final double totalPrice;

        public CustomizedCarMemento(CarContent carContent, double totalPrice) {
            this.carContent = carContent;
            this.totalPrice = totalPrice;
        }
    }
}
