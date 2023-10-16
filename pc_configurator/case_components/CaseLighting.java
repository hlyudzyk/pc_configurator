package pc_configurator.case_components;

import pc_configurator.Component;

public class CaseLighting extends Component {
    public final LightType lightType;
    public final boolean hasController;

    public CaseLighting(Manufacturer manufacturer, String name,double price,int energyConsumption,
        LightType lightType, boolean hasController) {

        super(manufacturer, name, price, energyConsumption);

        this.lightType = lightType;
        this.hasController = hasController;
    }

    public void light(){
        //emmit light
    }

    @Override
    public String toString() {
        return "CaseLighting{" +
            "manufacturer=" + getManufacturer() +
            ", name=" + getName() +
            ", lightType=" + lightType +
            ", hasController=" + hasController +
            '}';
    }

    public enum LightType {
        RGB("RGB"),
        ONECOLOR("OneColor");

        private final String LightType;

        LightType(String LightType) {
            this.LightType = LightType;
        }
    }
}
