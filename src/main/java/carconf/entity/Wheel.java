package carconf.entity;

import carconf.car_assembling.car_object_storage.CarPart;

import javax.persistence.*;

@Entity
@Table(
        name = "wheels",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"level_ID", "description"})}
)
public class Wheel implements CarPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wheel_ID", nullable = false)
    private int wheelId;

    @ManyToOne
    @JoinColumn(name="level_ID", nullable = false)
    private EquipmentLevel equipmentLevel;

    @Column(name = "size", nullable = false)
    private int size;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private float price;

    @Column(name = "photo", nullable = false)
    private String photoUrl;

    public Wheel() {
    }

    public Wheel(Wheel wheel) {
        if (wheel != null) {
            this.wheelId = wheel.getWheelId();
            this.equipmentLevel = wheel.getEquipmentLevel();
            this.size = wheel.getSize();
            this.description = wheel.getDescription();
            this.price = wheel.getPrice();
            this.photoUrl = wheel.getPhotoUrl();
        }
    }

    public int getWheelId() {
        return wheelId;
    }

    public void setWheelId(int wheelId) {
        this.wheelId = wheelId;
    }

    public EquipmentLevel getEquipmentLevel() {
        return equipmentLevel;
    }

    public void setEquipmentLevel(EquipmentLevel equipmentLevel) {
        this.equipmentLevel = equipmentLevel;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
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
