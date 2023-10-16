package pc_configurator.case_components.cooling;

import pc_configurator.Component;

public interface CoolingDevice {
    void cool();
    public enum CoolingDeviceManufacturer implements Component.Manufacturer {
        MSI("MSI"),
        BEQUIET("BeQuiet"),
        ASUS("ASUS");

        private final String CoolingDeviceManufacturer;

        CoolingDeviceManufacturer(String CoolingDeviceManufacturer) {
            this.CoolingDeviceManufacturer = CoolingDeviceManufacturer;
        }

        @Override
        public String getManufacturerName() {
            return CoolingDeviceManufacturer;
        }
    }

}
