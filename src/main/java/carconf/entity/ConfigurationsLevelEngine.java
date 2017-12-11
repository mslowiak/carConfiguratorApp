package carconf.entity;

import javax.persistence.*;

@Entity
@Table(name = "configurations_level_engine",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"engine_ID", "level_ID"})}
)
public class ConfigurationsLevelEngine {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int config_ID;

    @ManyToOne
    @JoinColumn(name="engine_ID")
    private Engine engine;

    @ManyToOne
    @JoinColumn(name="level_ID")
    private EquipmentLevel equipmentLevel;

    public ConfigurationsLevelEngine() {
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
}
