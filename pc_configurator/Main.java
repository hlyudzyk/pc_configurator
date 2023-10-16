package pc_configurator;

public class Main {
    public static void main(String[] args){
        ComponentsWarehouse warehouse = new ComponentsWarehouse();
        Computer myComputer = PcConfigurator.assembleComputer(warehouse);

        System.out.println(myComputer.toString());
    }
}
