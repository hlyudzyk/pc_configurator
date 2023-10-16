package pc_configurator.case_components.cooling;

import pc_configurator.Component;

public class AirCooler extends Component implements CoolingDevice {
    public AirCooler(CoolingDeviceManufacturer manufacturer, String name, double price,int energyConsumption) {
        super(manufacturer, name, price, energyConsumption);
    }

    @Override
    public void cool() {
        //cools pc with air
    }

    @Override
    public String toString() {
        return "AirCooler{"
            +"manufacturer=" + getManufacturer()
            +", name=" + getName() +
            "}";
    }

}
