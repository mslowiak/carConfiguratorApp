package carconf.entity;

import carconf.car_assembling.CarItems;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "equipment_levels",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"level_ID", "model_ID"})}
)
public class EquipmentLevel implements CarItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "level_ID", nullable = false)
    private int levelId;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "price", nullable = false)
    private float price;

    @OneToMany(mappedBy="equipmentLevel")
    private List<ConfigurationsLevelEngine> configurationsLevelEngines;

    @OneToMany(mappedBy="equipmentLevel")
    private List<EquipmentElement> equipmentElements;

    @ManyToOne
    @JoinColumn(name="model_ID")
    private Model model;

    @OneToMany(mappedBy="equipmentLevel")
    private List<Wheel> wheels;

    public EquipmentLevel() {
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
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
        configurationsLevelEngine.setEquipmentLevel(this);

        return configurationsLevelEngine;
    }

    public ConfigurationsLevelEngine removeConfigurationsLevelEngine(ConfigurationsLevelEngine configurationsLevelEngine) {
        getConfigurationsLevelEngines().remove(configurationsLevelEngine);
        configurationsLevelEngine.setEquipmentLevel(null);

        return configurationsLevelEngine;
    }

    public List<EquipmentElement> getEquipmentElements() {
        return this.equipmentElements;
    }

    public void setEquipmentElements(List<EquipmentElement> equipmentElements) {
        this.equipmentElements = equipmentElements;
    }

    public EquipmentElement addEquipmentElement(EquipmentElement equipmentElement) {
        getEquipmentElements().add(equipmentElement);
        equipmentElement.setEquipmentLevel(this);

        return equipmentElement;
    }

    public EquipmentElement removeEquipmentElement(EquipmentElement equipmentElement) {
        getEquipmentElements().remove(equipmentElement);
        equipmentElement.setEquipmentLevel(null);

        return equipmentElement;
    }

    public Model getModel() {
        return this.model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public List<Wheel> getWheels() {
        return this.wheels;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }

    public Wheel addWheel(Wheel wheel) {
        getWheels().add(wheel);
        wheel.setEquipmentLevel(this);

        return wheel;
    }

    public Wheel removeWheel(Wheel wheel) {
        getWheels().remove(wheel);
        wheel.setEquipmentLevel(null);

        return wheel;
    }

    @Override
    public String getDescribtion() {
        return null;
    }
}
