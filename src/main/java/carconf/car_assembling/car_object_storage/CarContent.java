package carconf.car_assembling.car_object_storage;

import carconf.entity.*;

import java.util.ArrayList;
import java.util.List;

public class CarContent {

    private Color color;
    private ConfigurationsLevelEngine configurationsLevelEngine;
    private Engine engine;
    private List<EquipmentElement> equipmentElements;
    private EquipmentLevel equipmentLevel;
    private EquipmentType equipmentType;
    private Model model;
    private Wheel wheel;


    public CarContent() {
        equipmentElements = new ArrayList<>();
    }

    public CarContent(CarContent carContent) {
        this.color = new Color(carContent.color);
        this.configurationsLevelEngine = new ConfigurationsLevelEngine(carContent.configurationsLevelEngine);
        this.engine = new Engine(carContent.engine);
        List<EquipmentElement> tmp = new ArrayList<>();
        for (EquipmentElement e : carContent.equipmentElements){
            tmp.add(new EquipmentElement(e));
        }
        this.equipmentElements = tmp;
        this.equipmentLevel = new EquipmentLevel(carContent.equipmentLevel);
        this.equipmentType = new EquipmentType(carContent.equipmentType);
        this.model = new Model(carContent.model);
        this.wheel = new Wheel(carContent.wheel);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ConfigurationsLevelEngine getConfigurationsLevelEngine() {
        return configurationsLevelEngine;
    }

    public void setConfigurationsLevelEngine(ConfigurationsLevelEngine configurationsLevelEngine) {
        this.configurationsLevelEngine = configurationsLevelEngine;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public List<EquipmentElement> getEquipmentElements() {
        return equipmentElements;
    }

    public void setEquipmentElements(List<EquipmentElement> equipmentElements) {
        this.equipmentElements = equipmentElements;
    }

    public EquipmentLevel getEquipmentLevel() {
        return equipmentLevel;
    }

    public void setEquipmentLevel(EquipmentLevel equipmentLevel) {
        this.equipmentLevel = equipmentLevel;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public void addEquipmentElement(EquipmentElement elem) {
        this.equipmentElements.add(elem);
    }
}
