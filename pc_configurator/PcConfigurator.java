package pc_configurator;

import java.util.List;
import java.util.Scanner;
import pc_configurator.Computer.ComputerBuilder;
import pc_configurator.case_components.PcCase;
import pc_configurator.case_components.PowerSupply;
import pc_configurator.hardware.Cpu;
import pc_configurator.hardware.MotherBoard;
import pc_configurator.hardware.Ram;
import pc_configurator.hardware.harddrive.HardDrive;

public class PcConfigurator {
    //For testing purposes only. Further improvement needed
    static Computer assembleComputer(ComponentsWarehouse warehouse){
        ComputerBuilder computerBuilder;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the PC Configurator! Let's select motherboard!\n");
        MotherBoard motherBoard = selectComponent(warehouse.motherBoards,scanner);

        System.out.println("Excellent choice! Select the CPU for PC\n");
        Cpu cpu = selectComponent(warehouse.cpuList,scanner);

        System.out.println("Choose the ram for PC\n");
        Ram ram = selectComponent(warehouse.ramList,scanner);

        motherBoard.installHardware(ram,cpu);

        System.out.println("Select hard drive\n");
        HardDrive hardDrive = selectComponent(warehouse.hardDrives,scanner);

        System.out.println("Select PC Case\n");
        PcCase pcCase = selectComponent(warehouse.pcCases,scanner);

        System.out.println("Select Power Supply\n");
        PowerSupply powerSupply = selectComponent(warehouse.powerSupplies,scanner);

        computerBuilder = new ComputerBuilder(motherBoard,hardDrive,pcCase,powerSupply);

        if(AskForConfirmation("Do you want to choose second hard drive?",scanner)){
            computerBuilder.installHardDrive(selectComponent(warehouse.hardDrives,scanner));
        }

        if(AskForConfirmation("Do you want to install GPU?",scanner)){
            computerBuilder.motherBoard.installGpu(selectComponent(warehouse.gpuList,scanner));
        }

        if(AskForConfirmation("Do you want to install Audio Card?",scanner)){
            computerBuilder.motherBoard.installAudioCard(selectComponent(warehouse.audioCards,scanner));
        }

        if(AskForConfirmation("Do you want to install Air Cooling device?",scanner)){
            computerBuilder.installCoolingDevice(selectComponent(warehouse.airCoolers,scanner));
        }

        if(AskForConfirmation("Do you want to install Liquid Cooling device?",scanner)){
            computerBuilder.installCoolingDevice(selectComponent(warehouse.liquidCoolers,scanner));
        }

        if(AskForConfirmation("Do you want to install Case Lighting?",scanner)){
            computerBuilder.installLighting(selectComponent(warehouse.caseLightings,scanner));
        }

        scanner.close();

        return computerBuilder.build();
    }

    public static <T extends Component> T selectComponent(List<T> components, Scanner scanner) {
        System.out.println("Choose the component by entering index\n");
        printComponents(components);

        int n;
        do {
            System.out.print("Enter the index: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Input error. Enter the number > 0");
                System.out.print("Enter the index: ");
                scanner.next();
            }
            n = scanner.nextInt();
            if (n < 0 || n >= components.size()) {
                System.out.println("Input error. Try again");
            }
        } while (n < 0 || n >= components.size());

        return components.get(n);
    }

    public static void printComponents(List<? extends Component> components) {
        int i = 0;
        for (Component component : components) {
            System.out.println(i + "\t" + component.toString() + "\n");
            i++;
        }
    }
    //returns whether user wants or not to do something
    public static boolean AskForConfirmation(String question,Scanner scanner) {
        System.out.println(question);
        System.out.println("1 - yes, anything else - no: ");
        scanner.nextLine();
        String input = scanner.nextLine();
        return input.equals("1");
    }

}
