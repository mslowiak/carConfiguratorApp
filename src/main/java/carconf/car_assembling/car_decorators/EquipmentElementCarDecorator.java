package carconf.car_assembling.car_decorators;

import carconf.car_assembling.car_object_storage.CarPart;
import carconf.car_assembling.car_object_storage.CustomizedCar;
import carconf.entity.EquipmentElement;

public class EquipmentElementCarDecorator extends CustomizedCar {
    public EquipmentElementCarDecorator (CustomizedCar car, CarPart part) {
        this.setCarContent(car.getCarContent());
        this.getCarContent().addEquipmentElement((EquipmentElement) part);
        this.setTotalPrice(car.getTotalPrice() + ((EquipmentElement) part).getPrice());
    }
}
