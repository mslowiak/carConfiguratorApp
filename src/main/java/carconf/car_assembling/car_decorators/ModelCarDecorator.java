package carconf.car_assembling.car_decorators;

import carconf.car_assembling.CarPart;
import carconf.car_assembling.CustomizedCar;
import carconf.entity.Model;

public class ModelCarDecorator extends CustomizedCar {

    public ModelCarDecorator(CustomizedCar car, CarPart part) {
        this.setCarContent(car.getCarContent());
        this.getCarContent().setModel((Model) part);
        this.setTotalPrice(car.getTotalPrice());
    }
}
