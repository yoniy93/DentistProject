package project.Entities;

public class Treatments {

    private String name;
    private int duration;
    private String id;
    private double price;
    private String description;

    public Treatments(String id, String name, int duration, double price, String description){
        setId(id);
        setDuration(duration);
        setName(name);
        setPrice(price);
        setDescription(description);
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
