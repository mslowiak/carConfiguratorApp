package carconf.entity;

import carconf.car_assembling.CarPart;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "models",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})}
)
public class Model implements CarPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_ID", nullable = false)
    private int modelId;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "width", nullable = false)
    private int width;

    @Column(name = "height", nullable = false)
    private int height;

    @Column(name = "length", nullable = false)
    private int length;

    @Column(name = "BasicPrice", nullable = false)
    private float basicPrice;

    @Column(name = "Photo", nullable = false)
    private String photoUrl;

    @OneToMany(mappedBy="model")
    private List<Color> colors;

    @OneToMany(mappedBy="model")
    private List<EquipmentLevel> equipmentLevels;

    public Model(String name, String brand, int width, int height, int length) {
        this.name = name;
        this.brand = brand;
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public Model() {
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(float basicPrice) {
        this.basicPrice = basicPrice;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public List<Color> getColors() {
        return this.colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public Color addColor(Color color) {
        getColors().add(color);
        color.setModel(this);

        return color;
    }

    public Color removeColor(Color color) {
        getColors().remove(color);
        color.setModel(null);

        return color;
    }

    public List<EquipmentLevel> getEquipmentLevels() {
        return this.equipmentLevels;
    }

    public void setEquipmentLevels(List<EquipmentLevel> equipmentLevels) {
        this.equipmentLevels = equipmentLevels;
    }

    public EquipmentLevel addEquipmentLevel(EquipmentLevel equipmentLevel) {
        getEquipmentLevels().add(equipmentLevel);
        equipmentLevel.setModel(this);

        return equipmentLevel;
    }

    public EquipmentLevel removeEquipmentLevel(EquipmentLevel equipmentLevel) {
        getEquipmentLevels().remove(equipmentLevel);
        equipmentLevel.setModel(null);

        return equipmentLevel;
    }

    @Override
    public String getItemDescription() {
        return getBrand() + getName();
    }
}
