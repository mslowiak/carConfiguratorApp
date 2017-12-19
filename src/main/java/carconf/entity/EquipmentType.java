package carconf.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "equipment_types",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"description"})}
)
public class EquipmentType {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int type_ID;

    private String description;

    @OneToMany(mappedBy="equipmentType")
    private List<EquipmentElement> equipmentElements;

    public EquipmentType() {
    }

    public int getType_ID() {
        return type_ID;
    }

    public void setType_ID(int type_ID) {
        this.type_ID = type_ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<EquipmentElement> getEquipmentElements() {
        return equipmentElements;
    }

    public void setEquipmentElements(List<EquipmentElement> equipmentElements) {
        this.equipmentElements = equipmentElements;
    }

    public EquipmentElement addEquipmentElement(EquipmentElement equipmentElement) {
        getEquipmentElements().add(equipmentElement);
        equipmentElement.setEquipmentType(this);

        return equipmentElement;
    }

    public EquipmentElement removeEquipmentElement(EquipmentElement equipmentElement) {
        getEquipmentElements().remove(equipmentElement);
        equipmentElement.setEquipmentType(null);

        return equipmentElement;
    }
}