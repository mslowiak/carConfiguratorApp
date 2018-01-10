package carconf.car_assembling;

import carconf.car_assembling.car_object_storage.CustomizedCar;

import java.util.ArrayList;
import java.util.List;

public class CustomizedCarCaretaker {

    private List<CustomizedCarMemento> customizedCarMementos = new ArrayList<>();

    public void saveCustomizedCar(CustomizedCar customizedCar){
        CustomizedCarMemento memento = customizedCar.createMemento();
        customizedCarMementos.add(memento);
    }

    public CustomizedCar loadCustomizedCar(){
        CustomizedCarMemento memento = customizedCarMementos.get(customizedCarMementos.size() - 1);
        return CustomizedCar.createCustomizedCar(memento);
    }
}
