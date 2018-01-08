package carconf.car_assembling.car_decorators;

import carconf.car_assembling.CarPart;
import carconf.car_assembling.CustomizedCar;
import carconf.entity.Color;

public class ColorCarDecorator extends CustomizedCar {

    public ColorCarDecorator(CustomizedCar car, CarPart part) {
        this.setCarContent(car.getCarContent());
        this.getCarContent().setColor((Color) part);
        this.setTotalPrice(car.getTotalPrice() + ((Color) part).getPrice());
    }
}
