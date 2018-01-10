package carconf.car_assembling.car_decorators;

import carconf.car_assembling.car_object_storage.CarPart;
import carconf.car_assembling.car_object_storage.CustomizedCar;
import carconf.entity.Model;

public class ModelCarDecorator extends CustomizedCar {

    public ModelCarDecorator(CustomizedCar car, CarPart part) {
        this.setCarContent(car.getCarContent());
        this.getCarContent().setModel((Model) part);
        this.setTotalPrice(car.getTotalPrice());
    }
}
