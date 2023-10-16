package pc_configurator.case_components.cooling;

import pc_configurator.Component;

public class LiquidCooler extends Component implements CoolingDevice {
    public LiquidCooler(CoolingDeviceManufacturer manufacturer, String name,double price,int energyConsumption) {
        super(manufacturer, name, price, energyConsumption);
    }

    @Override
    public void cool() {
        //cools pc with liquid
    }

    @Override
    public String toString() {
        return "LiquidCooler{"
            +"manufacturer=" + getManufacturer()
            +", name=" + getName() +
            "}";
    }

}
