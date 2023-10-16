package pc_configurator;

import java.util.ArrayList;
import java.util.List;
import pc_configurator.case_components.CaseLighting;
import pc_configurator.case_components.PcCase;
import pc_configurator.case_components.PowerSupply;
import pc_configurator.case_components.cooling.CoolingDevice;
import pc_configurator.hardware.MotherBoard;
import pc_configurator.hardware.harddrive.HardDrive;

public class Computer {
    //required
    public MotherBoard motherBoard;
    private List<HardDrive> hardDrives;
    private PcCase pcCase;
    private PowerSupply powerSupply;
    //optional
    private List<CoolingDevice> coolingDevices;
    private CaseLighting caseLighting;

    private Computer(ComputerBuilder builder){
        this.motherBoard = builder.motherBoard;
        this.hardDrives = builder.hardDrives;
        this.pcCase = builder.pcCase;
        this.powerSupply = builder.powerSupply;
        this.coolingDevices = builder.coolingDevices;
        this.caseLighting = builder.caseLighting;
    }

    public static class ComputerBuilder{
        //required
        public MotherBoard motherBoard;
        private List<HardDrive> hardDrives;
        private PcCase pcCase;
        private PowerSupply powerSupply;
        //optional
        private List<CoolingDevice> coolingDevices;
        private CaseLighting caseLighting;

        public ComputerBuilder(MotherBoard motherBoard, HardDrive hardDrive, PcCase pcCase,
            PowerSupply powerSupply) {

            if(!motherBoard.isAssembled()){
                throw new IllegalArgumentException("Motherboard is not assembled! Please, assemble all"
                    + "components and try again!");
            }

            this.hardDrives = new ArrayList<>();
            this.coolingDevices = new ArrayList<>();
            this.motherBoard = motherBoard;
            this.hardDrives.add(hardDrive);
            this.pcCase = pcCase;
            this.powerSupply = powerSupply;

        }
        public ComputerBuilder installHardDrive(HardDrive hardDrive) {
            this.hardDrives.add(hardDrive);
            return this;
        }
        public ComputerBuilder installCoolingDevice(CoolingDevice coolingDevice){
            this.coolingDevices.add(coolingDevice);
            return this;
        }

        public ComputerBuilder installLighting(CaseLighting caseLighting){
            this.caseLighting = caseLighting;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }

    }

    public List<HardDrive> getHardDrives() {
        return hardDrives;
    }

    public PcCase getPcCase() {
        return pcCase;
    }

    public void setPcCase(PcCase pcCase) {
        this.pcCase = pcCase;
    }

    public PowerSupply getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(PowerSupply powerSupply) {
        this.powerSupply = powerSupply;
    }

    @Override
    public String toString() {
        return "Computer{" +
            "motherBoard=" + motherBoard +
            ", hardDrives=" + hardDrives +
            ", pcCase=" + pcCase +
            ", powerSupply=" + powerSupply +
            ", coolingDevices=" + coolingDevices +
            ", caseLighting=" + caseLighting +
            '}';
    }
}
