package carconf.car_assembling;

import carconf.App;
import carconf.entity.*;
import javafx.scene.image.Image;

import java.text.DecimalFormat;

public class CarInformationFacade {

    public StringBuilder getCarModel(){
        StringBuilder sb = new StringBuilder();
        Model model = App.car.getCarContent().getModel();
        sb.append(model.getName()).append(" ").append(model.getBrand());
        return sb;
    }

    public StringBuilder getFullCarDescription(){
        StringBuilder sb = new StringBuilder();

        Model model = App.car.getCarContent().getModel();
        sb.append("MODEL AUTA:").append("\n");
        sb.append("\tNazwa: ").append(model.getName()).append("\n");
        sb.append("\tMarka: ").append(model.getBrand()).append("\n");
        sb.append("\tSzerokość: ").append(model.getHeight()).append("\n");
        sb.append("\tWysokość: ").append(model.getWidth()).append("\n");
        sb.append("\tDługość: ").append(model.getLength()).append("\n").append("\n");

        EquipmentLevel equipmentLevel = App.car.getCarContent().getEquipmentLevel();
        sb.append("RODZAJ WYPOSAŻENIA:").append("\n");
        sb.append("\tNazwa: ").append(equipmentLevel.getName()).append("\n");
        sb.append("\tCena: ").append(new DecimalFormat("#").format(equipmentLevel.getPrice())).append(" PLN\n").append("\n");

        Color color = App.car.getCarContent().getColor();
        sb.append("KOLOR:").append("\n");
        sb.append("\tNazwa: ").append(color.getDescription()).append("\n");
        sb.append("\tRodzaj koloru: ").append(color.getColorType()).append("\n");
        sb.append("\tCena: ").append(new DecimalFormat("#").format(color.getPrice())).append(" PLN\n").append("\n");

        Wheel wheel = App.car.getCarContent().getWheel();
        sb.append("FELGI:").append("\n");
        sb.append("\tOpis: ").append(wheel.getDescription()).append("\n");
        sb.append("\tRozmiar: ").append(wheel.getSize()).append("\n");
        sb.append("\tCena: ").append(new DecimalFormat("#").format(wheel.getPrice())).append(" PLN\n").append("\n");

        Engine engine = App.car.getCarContent().getEngine();
        sb.append("SILNIK:").append("\n");
        sb.append("\tNazwa: ").append(engine.getName()).append("\n");
        sb.append("\tRodzaj paliwa: ").append(engine.getFuel()).append("\n");
        sb.append("\tLiczba KM: ").append(engine.getPowerKM()).append("\n");
        sb.append("\tLiczba KW: ").append(engine.getPowerKW()).append("\n");
        sb.append("\tPojemność: ").append(new DecimalFormat("#").format(engine.getCapacity())).append("\n");
        sb.append("\tRodzaj skrzyni: ").append(engine.getGearBox()).append("\n");
        sb.append("\tLiczba cylindrów: ").append(engine.getAmountOfCylinders()).append("\n");
        sb.append("\tCena: ").append(new DecimalFormat("#").format(engine.getPrice())).append(" PLN\n").append("\n");

        sb.append("ELEMENTY WYPOSAŻENIA:").append("\n");
        for(EquipmentElement e : App.car.getCarContent().getEquipmentElements()){
            sb.append("\t")
                    .append(e.getDescription())
                    .append(" => ")
                    .append(new DecimalFormat("#").format(e.getPrice()))
                    .append("\n");
        }
        return sb;
    }

    public StringBuilder getShortCarDescription(){
        StringBuilder sb = new StringBuilder();

        Model model = App.car.getCarContent().getModel();
        sb.append("MODEL AUTA:").append("\n");
        sb.append("\tNazwa: ").append(model.getName()).append("\n");
        sb.append("\tMarka: ").append(model.getBrand()).append("\n").append("\n");

        EquipmentLevel equipmentLevel = App.car.getCarContent().getEquipmentLevel();
        sb.append("RODZAJ WYPOSAŻENIA:").append("\n");
        sb.append("\tNazwa: ").append(equipmentLevel.getName()).append("\n");
        sb.append("\tCena: ").append(new DecimalFormat("#").format(equipmentLevel.getPrice())).append(" PLN\n").append("\n");

        Color color = App.car.getCarContent().getColor();
        sb.append("KOLOR:").append("\n");
        sb.append("\tNazwa: ").append(color.getDescription()).append("\n");
        sb.append("\tCena: ").append(new DecimalFormat("#").format(color.getPrice())).append(" PLN\n").append("\n");

        Wheel wheel = App.car.getCarContent().getWheel();
        sb.append("FELGI:").append("\n");
        sb.append("\tOpis: ").append(wheel.getDescription()).append("\n");
        sb.append("\tCena: ").append(new DecimalFormat("#").format(wheel.getPrice())).append(" PLN\n").append("\n");

        Engine engine = App.car.getCarContent().getEngine();
        sb.append("SILNIK:").append("\n");
        sb.append("\tNazwa: ").append(engine.getName()).append("\n");
        sb.append("\tRodzaj paliwa: ").append(engine.getFuel()).append("\n");
        sb.append("\tLiczba KM: ").append(engine.getPowerKM()).append("\n");
        sb.append("\tPojemność: ").append(new DecimalFormat("#").format(engine.getCapacity())).append("\n");
        sb.append("\tRodzaj skrzyni: ").append(engine.getGearBox()).append("\n");
        sb.append("\tCena: ").append(new DecimalFormat("#").format(engine.getPrice())).append(" PLN\n").append("\n");

        sb.append("ELEMENTY WYPOSAŻENIA:").append("\n");
        for(EquipmentElement e : App.car.getCarContent().getEquipmentElements()){
            sb.append("\t")
                    .append(e.getDescription())
                    .append(" => ")
                    .append(new DecimalFormat("#").format(e.getPrice()))
                    .append(" PLN\n");
        }
        return sb;
    }

    public String getTotalPriceByText(){
        double totalPrice = App.car.getTotalPrice();
        return new DecimalFormat("#").format(totalPrice) + " PLN";
    }

    public Image getCarPhoto(){
        return new Image(App.car.getCarContent().getModel().getPhotoUrl());
    }

    public Image getCarColorPhoto(){
        return new Image(App.car.getCarContent().getColor().getPhotoUrl());
    }

    public Image getCarWheelPhoto(){
        return new Image(App.car.getCarContent().getWheel().getPhotoUrl());
    }
}
