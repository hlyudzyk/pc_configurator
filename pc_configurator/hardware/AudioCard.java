package pc_configurator.hardware;

import pc_configurator.Component;

public class AudioCard extends Component {
    public final double maxFrequency;

    public AudioCard(AudioCardManufacturer manufacturer, String name,double price,
        int energyConsumption, double maxFrequency) {
        super(manufacturer,name, price, energyConsumption);
        this.maxFrequency = maxFrequency;
    }

    @Override
    public String toString() {
        return "AudioCard{" +
            "manufacturer=" + getManufacturer() +
            ", name=" + getName() +
            ", maxFrequency=" + maxFrequency +
            '}';
    }

    public enum AudioCardManufacturer implements Manufacturer {
        HATOR("Hator"),
        UGREEN("UGreen"),
        ASUS("Asus");

        private final String manufacturerName;

        AudioCardManufacturer(String manufacturerName) {
            this.manufacturerName = manufacturerName;
        }

        @Override
        public String getManufacturerName() {
            return manufacturerName;
        }
    }
}
