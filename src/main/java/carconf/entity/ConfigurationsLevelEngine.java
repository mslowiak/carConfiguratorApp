package carconf.entity;

import carconf.car_assembling.car_object_storage.CarPart;

import javax.persistence.*;

@Entity
@Table(name = "configurations_level_engine",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"engine_ID", "level_ID"})}
)
public class ConfigurationsLevelEngine implements CarPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int config_ID;

    @ManyToOne
    @JoinColumn(name = "engine_ID")
    private Engine engine;

    @ManyToOne
    @JoinColumn(name = "level_ID")
    private EquipmentLevel equipmentLevel;

    public ConfigurationsLevelEngine() {
    }

    public ConfigurationsLevelEngine(ConfigurationsLevelEngine configurationsLevelEngine) {
        if (configurationsLevelEngine != null) {
            this.config_ID = configurationsLevelEngine.getConfig_ID();
            this.engine = new Engine(configurationsLevelEngine.getEngine());
            this.equipmentLevel = new EquipmentLevel(configurationsLevelEngine.getEquipmentLevel());
        }
    }

    public int getConfig_ID() {
        return this.config_ID;
    }

    public void setConfig_ID(int config_ID) {
        this.config_ID = config_ID;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public EquipmentLevel getEquipmentLevel() {
        return this.equipmentLevel;
    }

    public void setEquipmentLevel(EquipmentLevel equipmentLevel) {
        this.equipmentLevel = equipmentLevel;
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
