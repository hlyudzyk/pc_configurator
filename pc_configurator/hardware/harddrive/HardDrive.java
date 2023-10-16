package pc_configurator.hardware.harddrive;

import pc_configurator.Component;

public abstract class HardDrive extends Component {
    public final int storageCapacity;
    public final int writingSpeed;
    public final int readingSpeed;

    public HardDrive(HardDriveManufacturer manufacturer, String name, double price,
        int energyConsumption, int storageCapacity, int writingSpeed, int readingSpeed) {

        super(manufacturer, name, price, energyConsumption);
        this.storageCapacity = storageCapacity;
        this.writingSpeed = writingSpeed;
        this.readingSpeed = readingSpeed;
    }


    public abstract void writeOnDisc(byte[] bytes);
    public abstract byte[] readFromDisc();

    @Override
    public String toString() {
        return "HardDrive{" +
            "manufacturer=" + getManufacturer() +
            ", name=" + getName() +
            ", storageCapacity=" + storageCapacity +
            ", writingSpeed=" + writingSpeed +
            ", readingSpeed=" + readingSpeed +
            '}';
    }

    public enum HardDriveManufacturer implements Manufacturer {
        KINGSTON("Kingston"),
        PATRIOT("Patriot"),
        TOSHIBA("Toshiba"),
        SAMSUNG("Samsung");

        private final String manufacturerName;

        HardDriveManufacturer(String manufacturerName) {
            this.manufacturerName = manufacturerName;
        }

        @Override
        public String getManufacturerName() {
            return manufacturerName;
        }
    }

}
