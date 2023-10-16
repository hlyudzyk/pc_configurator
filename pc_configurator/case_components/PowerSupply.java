package pc_configurator.case_components;

import pc_configurator.Component;

public class PowerSupply extends Component {
    public final int power;
    public PowerSupply(PowerSupplyManufacturer manufacturer, String name,double price,
        int energyConsumption,int power) {
        super(manufacturer, name, price, energyConsumption);
        this.power = power;
    }

    @Override
    public String toString() {
        return "PowerSupply{" +
            "manufacturer=" + getManufacturer() +
            ", name=" + getName() +
            ", power=" + power +
            '}';
    }
    public enum PowerSupplyManufacturer implements Manufacturer {
        MSI("MSI"),
        BEQUIET("BeQuiet"),
        GIGABYTE("Gigabyte");

        private final String manufacturerName;

        PowerSupplyManufacturer(String manufacturerName) {
            this.manufacturerName = manufacturerName;
        }

        @Override
        public String getManufacturerName() {
            return manufacturerName;
        }
    }
}
