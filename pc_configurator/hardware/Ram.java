package pc_configurator.hardware;
import pc_configurator.Component;
import pc_configurator.hardware.MotherBoard.Compatible;
import pc_configurator.hardware.MotherBoard.RamSocket;
public class Ram extends Component implements Compatible {
    private final int capacity;
    private final int clockSpeed;
    public final RamSocket ramSocket;

    public Ram(RamManufacturer manufacturer, String name,double price,int energyConsumption,
        int capacity, int clockSpeed, RamSocket ramSocket) {

        super(manufacturer, name, price, energyConsumption);

        this.capacity = capacity;
        this.clockSpeed = clockSpeed;
        this.ramSocket = ramSocket;
    }

    @Override
    public boolean isCompatibleWithMotherBoard(MotherBoard motherBoard) {
        return this.ramSocket.equals(motherBoard.ramSocket);
    }

    @Override
    public String toString() {
        return "Ram{" +
            "manufacturer=" + getManufacturer() +
            ", name=" + getName() +
            ", capacity=" + capacity +
            ", clockSpeed=" + clockSpeed +
            ", ramSocket=" + ramSocket +
            '}';
    }

    public enum RamManufacturer implements Manufacturer {
        KINGSTON("Kingston"),
        CORSAIR("Corsair"),
        HYPERX("HyperX"),
        SAMSUNG("Samsung");

        private final String manufacturerName;

        RamManufacturer(String manufacturerName) {
            this.manufacturerName = manufacturerName;
        }

        @Override
        public String getManufacturerName() {
            return manufacturerName;
        }
    }

}
