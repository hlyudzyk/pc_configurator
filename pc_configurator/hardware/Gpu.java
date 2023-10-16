package pc_configurator.hardware;

import pc_configurator.Component;

public class Gpu extends Component{

    public final int memory;

    public Gpu(GpuManufacturer manufacturer, String name, double price,
        int energyConsumption, int memory) {
        super(manufacturer,name, price, energyConsumption);
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "Gpu{" +
            "manufacturer=" + getManufacturer() +
            ", name=" + getName() +
            ", memory=" + memory +
            '}';
    }

    public enum GpuManufacturer implements Manufacturer {
        GIGABYTE("Gigabyte"),
        MSI("MSI"),
        ASUS("Asus");

        private final String manufacturerName;

        GpuManufacturer(String manufacturerName) {
            this.manufacturerName = manufacturerName;
        }

        @Override
        public String getManufacturerName() {
            return manufacturerName;
        }
    }
}
