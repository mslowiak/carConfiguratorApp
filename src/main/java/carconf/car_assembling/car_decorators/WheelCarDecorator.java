package carconf.car_assembling.car_decorators;

import carconf.car_assembling.CarPart;
import carconf.car_assembling.CustomizedCar;
import carconf.entity.Wheel;

public class WheelCarDecorator extends CustomizedCar {
    public WheelCarDecorator (CustomizedCar car, CarPart part) {
        this.setCarContent(car.getCarContent());
        this.getCarContent().setWheel((Wheel) part);
        this.setTotalPrice(car.getTotalPrice() + ((Wheel) part).getPrice());
    }
}
