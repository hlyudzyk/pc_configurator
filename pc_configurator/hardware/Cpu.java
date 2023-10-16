package pc_configurator.hardware;
import pc_configurator.Component;
import pc_configurator.hardware.MotherBoard.Compatible;
import pc_configurator.hardware.MotherBoard.CpuSocket;

public class Cpu extends Component implements Compatible {
    public final double clockSpeed;
    public final int cores;
    public final CpuSocket socket;

    public Cpu(CpuManufacturer manufacturer, String name,double price,int energyConsumption,
        double clockSpeed, int cores, CpuSocket socket) {

        super(manufacturer,name, price, energyConsumption);
        this.clockSpeed = clockSpeed;
        this.cores = cores;
        this.socket = socket;
    }

    @Override
    public boolean isCompatibleWithMotherBoard(MotherBoard motherBoard) {
        return this.socket.equals(motherBoard.cpuSocket);
    }

    @Override
    public String toString() {
        return "Cpu{" +
            "manufacturer=" + getManufacturer() +
            ", name=" + getName() +
            ", clockSpeed=" + clockSpeed +
            ", cores=" + cores +
            ", socket=" + socket +
            '}';
    }

    public enum CpuManufacturer implements Manufacturer {
        INTEL("Intel"),
        AMD("AMD");

        private final String manufacturerName;

        CpuManufacturer(String manufacturerName) {
            this.manufacturerName = manufacturerName;
        }

        @Override
        public String getManufacturerName() {
            return manufacturerName;
        }

    }




}
