package carconf.car_assembling;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomizedCar {
    static List<CarItems> carSpecification;

    public CustomizedCar(){
        carSpecification = new LinkedList<>();
    }

    public static void addSpecification(CarItems carItem) {
        carSpecification.add(carItem);
    }

    public static List<CarItems> getCarSpecification() {
        return carSpecification;
    }

    public static String getCarSpecificationDescription() {
        return carSpecification.stream()
                .map(item -> item.getItemDescription())
                .reduce("",(a, b) -> a + "\n" + b);
    }
}
