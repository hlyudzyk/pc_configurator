package pc_configurator;

public abstract class Component {
    private final Manufacturer manufacturer;
    private final String name;
    private double price;
    private final int energyConsumption;

    public Component(Manufacturer manufacturer,String name, double price, int energyConsumption) {
        this.manufacturer = manufacturer;
        this.name = name;
        this.price = price;
        this.energyConsumption = energyConsumption;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer.toString();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price<=0){
            throw new IllegalArgumentException("Price is set incorrectly");
        }
        this.price = price;
    }

    //default toString() for Component
    @Override
    public String toString() {
        return "Component{" +
            "manufacturer=" + manufacturer +
            ", name='" + name + '\'' +
            ", energyConsumption=" + energyConsumption +
            '}';
    }

    public interface Manufacturer {
        String getManufacturerName();
    }

}
