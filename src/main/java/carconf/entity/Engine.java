package carconf.entity;

import carconf.car_assembling.car_object_storage.CarPart;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "engines",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})}
)
public class Engine implements CarPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "engine_ID", nullable = false)
    private int engineId;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "fuel", nullable = false)
    private String fuel;

    @Column(name = "powerKM", nullable = false)
    private int powerKM;

    @Column(name = "powerKW", nullable = false)
    private int powerKW;

    @Column(name = "capacity", nullable = false)
    private float capacity;

    @Column(name = "gearBox", nullable = false)
    private String gearBox;

    @Column(name = "amountOfCylinders", nullable = false)
    private int amountOfCylinders;

    @Column(name = "price", nullable = false)
    private int price;

    @OneToMany(mappedBy="engine")
    private List<ConfigurationsLevelEngine> configurationsLevelEngines;

    public Engine() {
    }

    public Engine(Engine engine) {
        if(engine != null){
            this.engineId = engine.getEngineId();
            this.name = engine.getName();
            this.fuel = engine.getFuel();
            this.powerKM = engine.getPowerKM();
            this.powerKW = engine.getPowerKW();
            this.capacity = engine.getCapacity();
            this.gearBox = engine.getGearBox();
            this.amountOfCylinders = engine.getAmountOfCylinders();
            this.price = engine.getPrice();
            this.configurationsLevelEngines = engine.getConfigurationsLevelEngines();
        }
    }

    public int getEngineId() {
        return engineId;
    }

    public void setEngineId(int engineId) {
        this.engineId = engineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public int getPowerKM() {
        return powerKM;
    }

    public void setPowerKM(int powerKM) {
        this.powerKM = powerKM;
    }

    public int getPowerKW() {
        return powerKW;
    }

    public void setPowerKW(int powerKW) {
        this.powerKW = powerKW;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public String getGearBox() {
        return gearBox;
    }

    public void setGearBox(String gearBox) {
        this.gearBox = gearBox;
    }

    public int getAmountOfCylinders() {
        return amountOfCylinders;
    }

    public void setAmountOfCylinders(int amountOfCylinders) {
        this.amountOfCylinders = amountOfCylinders;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<ConfigurationsLevelEngine> getConfigurationsLevelEngines() {
        return this.configurationsLevelEngines;
    }

    public void setConfigurationsLevelEngines(List<ConfigurationsLevelEngine> configurationsLevelEngines) {
        this.configurationsLevelEngines = configurationsLevelEngines;
    }

    public ConfigurationsLevelEngine addConfigurationsLevelEngine(ConfigurationsLevelEngine configurationsLevelEngine) {
        getConfigurationsLevelEngines().add(configurationsLevelEngine);
        configurationsLevelEngine.setEngine(this);

        return configurationsLevelEngine;
    }

    public ConfigurationsLevelEngine removeConfigurationsLevelEngine(ConfigurationsLevelEngine configurationsLevelEngine) {
        getConfigurationsLevelEngines().remove(configurationsLevelEngine);
        configurationsLevelEngine.setEngine(null);

        return configurationsLevelEngine;
    }

    @Override
    public StringBuilder getFullItemDescription() {
        return null;
    }

    @Override
    public StringBuilder getShortItemDescription() {
        return null;
    }
}
