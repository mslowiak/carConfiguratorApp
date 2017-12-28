package carconf.car_assembling;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomizedCar {
    static List<CarItems> carSpecification;
    private int modelID;
    private int equipmentLevelID;
    private int engineID;

    public int getModelID() {
        return modelID;
    }

    public void setModelID(int modelID) {
        this.modelID = modelID;
    }

    public CustomizedCar(){
        carSpecification = new LinkedList<>();
    }

    public void addSpecification(CarItems carItem) {
        carSpecification.add(carItem);
    }

    public List<CarItems> getCarSpecification() {
        return carSpecification;
    }

    public String getCarSpecificationDescription() {
        return carSpecification.stream()
                .map(item -> item.getItemDescription())
                .reduce("",(a, b) -> a + "\n" + b);
    }
}
