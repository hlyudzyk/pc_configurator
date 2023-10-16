package pc_configurator.hardware.harddrive;

public class Hdd extends HardDrive {

    public Hdd(HardDriveManufacturer manufacturer, String name,double price, int energyConsumption,
        int storageCapacity, int writingSpeed, int readingSpeed) {
        super(manufacturer, name, price,energyConsumption, storageCapacity, writingSpeed, readingSpeed);
    }

    @Override
    public void writeOnDisc(byte[] bytes) {
        //writes on disc
    }

    @Override
    public byte[] readFromDisc() {
        //reads from disc
        return new byte[0];
    }
}
