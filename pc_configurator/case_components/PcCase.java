package pc_configurator.case_components;

import pc_configurator.Component;

public class PcCase extends Component {
    public PcCase(Manufacturer manufacturer, String name,double price) {
        super(manufacturer, name, price, 0);
    }

    @Override
    public String toString() {
        return "PcCase{" +
            "manufacturer=" + getManufacturer() +
            ", name=" + getName() +
            "}";
    }
}
