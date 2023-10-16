package pc_configurator;

import java.util.ArrayList;
import java.util.List;
import pc_configurator.case_components.CaseLighting;
import pc_configurator.case_components.CaseLighting.LightType;
import pc_configurator.case_components.PcCase;
import pc_configurator.case_components.PowerSupply;
import pc_configurator.case_components.PowerSupply.PowerSupplyManufacturer;
import pc_configurator.case_components.cooling.AirCooler;
import pc_configurator.case_components.cooling.CoolingDevice.CoolingDeviceManufacturer;
import pc_configurator.case_components.cooling.LiquidCooler;
import pc_configurator.hardware.AudioCard;
import pc_configurator.hardware.AudioCard.AudioCardManufacturer;
import pc_configurator.hardware.Cpu;
import pc_configurator.hardware.Cpu.CpuManufacturer;
import pc_configurator.hardware.Gpu;
import pc_configurator.hardware.Gpu.GpuManufacturer;
import pc_configurator.hardware.MotherBoard;
import pc_configurator.hardware.MotherBoard.CpuSocket;
import pc_configurator.hardware.MotherBoard.MotherboardManufacturer;
import pc_configurator.hardware.MotherBoard.RamSocket;
import pc_configurator.hardware.Ram;
import pc_configurator.hardware.Ram.RamManufacturer;
import pc_configurator.hardware.harddrive.HardDrive;
import pc_configurator.hardware.harddrive.HardDrive.HardDriveManufacturer;
import pc_configurator.hardware.harddrive.Hdd;
import pc_configurator.hardware.harddrive.Ssd;

public final class ComponentsWarehouse {
    public List<AirCooler> airCoolers = new ArrayList<>();
    public List<LiquidCooler> liquidCoolers = new ArrayList<>();
    public List<CaseLighting> caseLightings = new ArrayList<>();
    public List<PcCase> pcCases = new ArrayList<>();
    public List<PowerSupply> powerSupplies = new ArrayList<>();
    public List<HardDrive> hardDrives = new ArrayList<>();
    public List<AudioCard> audioCards = new ArrayList<>();
    public List<Cpu> cpuList = new ArrayList<>();
    public List<Gpu> gpuList = new ArrayList<>();
    public List<MotherBoard> motherBoards = new ArrayList<>();
    public List<Ram> ramList = new ArrayList<>();

    public ComponentsWarehouse() {
        addDefaultComponents();
    }

    //For testing purposes only. Fills lists of components with default values
    private void addDefaultComponents() {
        cpuList.add(new Cpu(CpuManufacturer.AMD,"Ryzen 7",110,90,3400,8, CpuSocket.AM4));
        cpuList.add(new Cpu(CpuManufacturer.AMD,"Ryzen 5",95,80,3900,6, CpuSocket.AM4));
        cpuList.add(new Cpu(CpuManufacturer.INTEL,"Core i5-12400F",100,85,2500,6, CpuSocket.LGA1700));
        cpuList.add(new Cpu(CpuManufacturer.INTEL,"Core i7-13700K",125,95,3400,16, CpuSocket.LGA1700));

        ramList.add(new Ram(RamManufacturer.KINGSTON,"FURY Beast",40,5,8,3200,RamSocket.DDR4));
        ramList.add(new Ram(RamManufacturer.CORSAIR,"Vengeance",40,5,16,3600,RamSocket.DDR4));

        motherBoards.add(new MotherBoard(MotherboardManufacturer.GIGABYTE,"B550",50,30,4,CpuSocket.AM4,RamSocket.DDR4));
        motherBoards.add(new MotherBoard(MotherboardManufacturer.ASUS,"Rog Strix",50,30,4,CpuSocket.LGA1700,RamSocket.DDR4));
        motherBoards.add(new MotherBoard(MotherboardManufacturer.ASUS,"Prime B450",50,30,4,CpuSocket.AM4,RamSocket.DDR4));

        gpuList.add(new Gpu(GpuManufacturer.MSI,"GeForce RTX 4060", 400,100,8192));
        gpuList.add(new Gpu(GpuManufacturer.GIGABYTE,"GeForce RTX 3060", 300,90, 12288));
        gpuList.add(new Gpu(GpuManufacturer.MSI,"Radeon RX 7900",320,110, 20480));

        powerSupplies.add(new PowerSupply(PowerSupplyManufacturer.GIGABYTE,"P750GM",45,30,750));
        powerSupplies.add(new PowerSupply(PowerSupplyManufacturer.BEQUIET,"System",56,30,750));
        powerSupplies.add(new PowerSupply(PowerSupplyManufacturer.MSI,"MAG",40,30,650));

        audioCards.add(new AudioCard(AudioCardManufacturer.HATOR,"Crystal",20,25,96));
        audioCards.add(new AudioCard(AudioCardManufacturer.ASUS,"Xonar",20,25,96));
        audioCards.add(new AudioCard(AudioCardManufacturer.UGREEN,"CM383",20,25,96));

        airCoolers.add(new AirCooler(CoolingDeviceManufacturer.BEQUIET,"Shadow 3",20,40));
        airCoolers.add(new AirCooler(CoolingDeviceManufacturer.MSI,"Freezer",19,40));
        airCoolers.add(new AirCooler(CoolingDeviceManufacturer.ASUS,"Cool5",15,45));
        liquidCoolers.add(new LiquidCooler(CoolingDeviceManufacturer.ASUS,"LC240",30,35));
        liquidCoolers.add(new LiquidCooler(CoolingDeviceManufacturer.MSI,"Mag",28,35));

        pcCases.add(new PcCase(CoolingDeviceManufacturer.MSI,"Mag Forge",30));
        pcCases.add(new PcCase(CoolingDeviceManufacturer.MSI,"Gungir",35));

        caseLightings.add(new CaseLighting(CoolingDeviceManufacturer.MSI,"Coolmoon",15,30, LightType.RGB,true));
        caseLightings.add(new CaseLighting(CoolingDeviceManufacturer.ASUS,"Mono red",24,15, LightType.ONECOLOR,false));

        hardDrives.add(new Ssd(HardDriveManufacturer.SAMSUNG,"V-Nand",30,25,1024,5,5));
        hardDrives.add(new Ssd(HardDriveManufacturer.KINGSTON,"NV2",30,25,512,5,5));
        hardDrives.add(new Hdd(HardDriveManufacturer.TOSHIBA,"P300",28,25,512,15,15));
        hardDrives.add(new Hdd(HardDriveManufacturer.TOSHIBA,"D-Red",35,25,1024,15,15));

    }

}
