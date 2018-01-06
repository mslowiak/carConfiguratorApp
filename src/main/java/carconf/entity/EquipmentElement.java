package carconf.entity;

import carconf.car_assembling.CarPart;

import javax.persistence.*;

@Entity
@Table(name = "equipment_elements")
public class EquipmentElement implements CarPart {
    @Id
    @Column(name = "elem_ID", nullable = false)
    private int elemId;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private float price;

    @ManyToOne
    @JoinColumn(name="level_ID")
    private EquipmentLevel equipmentLevel;

    @ManyToOne
    @JoinColumn(name="type_ID")
    private EquipmentType equipmentType;

    public EquipmentElement() {
    }

    public int getElemId() {
        return elemId;
    }

    public void setElemId(int elemId) {
        this.elemId = elemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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

    @Override
    public String getItemDescription() {
        return getDescription() + equipmentType.getDescription() + getPrice();
    }
}
