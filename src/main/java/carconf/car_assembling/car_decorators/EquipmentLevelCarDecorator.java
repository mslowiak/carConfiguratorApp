package carconf.car_assembling.car_decorators;

import carconf.car_assembling.car_object_storage.CarPart;
import carconf.car_assembling.car_object_storage.CustomizedCar;
import carconf.entity.EquipmentLevel;

public class EquipmentLevelCarDecorator extends CustomizedCar {
    public EquipmentLevelCarDecorator (CustomizedCar car, CarPart part) {
        this.setCarContent(car.getCarContent());
        this.getCarContent().setEquipmentLevel((EquipmentLevel) part);
        this.setTotalPrice(car.getTotalPrice() + ((EquipmentLevel) part).getPrice());
    }
}
