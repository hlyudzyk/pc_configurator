package pc_configurator.hardware;

import java.util.ArrayList;
import java.util.List;
import pc_configurator.Component;

public class MotherBoard extends Component {
    //required
    private boolean isAssembled;
    public final CpuSocket cpuSocket;
    public final RamSocket ramSocket;
    private final int ramSlots;
    private Cpu cpu;
    private List<Ram> ramModules;
    //optional
    private Gpu gpu;
    private AudioCard audioCard;

    public MotherBoard(MotherboardManufacturer manufacturer, String name,double price,
        int energyConsumption,int ramSlots, CpuSocket cpuSocket, RamSocket ramSocket) {

        super(manufacturer,name, price, energyConsumption);

        this.ramModules = new ArrayList<>();
        this.ramSocket = ramSocket;
        this.cpuSocket = cpuSocket;
        this.ramSlots = ramSlots;

        isAssembled = false;
    }

    public boolean isAssembled() {
        return isAssembled;
    }

    public void installHardware(Ram ram, Cpu cpu){
        installRam(ram);
        installCpu(cpu);
        isAssembled = true;
    }

    public void installCpu(Cpu cpu) {
        if(cpu.isCompatibleWithMotherBoard(this)){
            this.cpu = cpu;
        }
        else{
            throw new IllegalArgumentException("Incompatible cpu given");
        }
    }

    public void installRam(Ram ram) {
        if(!ram.isCompatibleWithMotherBoard(this)){
            throw new IllegalArgumentException("Incompatible ram module given");
        }
        if(this.ramModules.size()>this.ramSlots){
            throw new IllegalArgumentException("Wrong amount of ram modules given");
        }
        this.ramModules.add(ram);
    }

    public void installGpu(Gpu gpu){
        this.gpu = gpu;
    }

    public void installAudioCard(AudioCard audioCard){
        this.audioCard = audioCard;
    }

    @Override
    public String toString() {
        return "MotherBoard{" +
            "manufacturer=" + getManufacturer() +
            ", name=" + getName() +
            ", cpuSocket=" + cpuSocket +
            ", ramSocket=" + ramSocket +
            ", cpu=" + cpu +
            ", ram=" + ramModules +
            ", gpu=" + gpu +
            ", audioCard=" + audioCard +
            '}';
    }

    public interface Compatible{
        boolean isCompatibleWithMotherBoard(MotherBoard motherBoard);
    }
    public enum CpuSocket {
        LGA1700("LGA 1700"),    // Intel 10th and 11th Gen
        AM4("AM4"),            // AMD Ryzen
        LGA1151("LGA 1151"),    // Intel 6th to 9th Gen
        TR4("TR4"),            // AMD Threadripper
        sTRX4("sTRX4"),        // AMD Threadripper (Zen 2)
        sWRX8("sWRX8"),        // AMD Ryzen Threadripper Pro
        sSP3("sSP3"),            // AMD Epyc
        SP3r2("SP3r2"),        // AMD Epyc (Rome)
        sTRX40("sTRX40");        // AMD Threadripper (Zen 2)

        private final String socketName;

        CpuSocket(String socketName) {
            this.socketName = socketName;
        }

        public String getSocketName() {
            return socketName;
        }
    }
    public enum RamSocket {
        DDR4("DDR4"),    // DDR4 RAM
        DDR3("DDR3"),    // DDR3 RAM
        DDR2("DDR2"),    // DDR2 RAM
        DDR("DDR"),      // DDR RAM
        LPDDR4X("LPDDR4X"),  // Low-Power DDR4X RAM
        LPDDR4("LPDDR4"),    // Low-Power DDR4 RAM
        LPDDR3("LPDDR3");    // Low-Power DDR3 RAM

        private final String socketName;

        RamSocket(String socketName) {
            this.socketName = socketName;
        }

        public String getSocketName() {
            return socketName;
        }
    }
    public enum MotherboardManufacturer implements Manufacturer {
        ASUS("ASUS"),
        MSI("MSI"),
        GIGABYTE("Gigabyte"),
        INTEL("Intel");

        private final String manufacturerName;

        MotherboardManufacturer(String manufacturerName) {
            this.manufacturerName = manufacturerName;
        }

        @Override
        public String getManufacturerName() {
            return manufacturerName;
        }
    }
}
