package carconf.car_assembling.car_decorators;

import carconf.car_assembling.CarPart;
import carconf.car_assembling.CustomizedCar;
import carconf.entity.Engine;

public class EngineCarDecorator extends CustomizedCar {
    public EngineCarDecorator (CustomizedCar car, CarPart part) {
        this.setCarContent(car.getCarContent());
        this.getCarContent().setEngine((Engine) part);
        this.setTotalPrice(car.getTotalPrice() + ((Engine) part).getPrice());
    }
}
