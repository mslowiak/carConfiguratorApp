package carconf.entity;

import carconf.car_assembling.car_object_storage.CarPart;

import javax.persistence.*;

@Entity
@Table(
        name = "colors",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"model_ID", "description"})}
)
public class Color implements CarPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_ID", nullable = false)
    private int colorId;

    @ManyToOne
    @JoinColumn(name="model_ID", nullable = false)
    private Model model;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "color_type", nullable = false)
    private String colorType;

    @Column(name = "price", nullable = false)
    private float price;

    @Column(name = "photo", nullable = false)
    private String photoUrl;

    public Color() {
    }

    public Color(Color color) {
        if (color != null){
            this.colorId = color.colorId;
            this.model = color.model;
            this.description = color.description;
            this.colorType = color.colorType;
            this.price = color.price;
            this.photoUrl = color.photoUrl;
        }
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public Model getModelId() {
        return model;
    }

    public void setModelId(Model model) {
        this.model = model;
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

    public String getColorType() {
        return colorType;
    }

    public void setColorType(String colorType) {
        this.colorType = colorType;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
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
