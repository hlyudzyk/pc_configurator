# pc_configurator
Computer configurator.

The PC Configurator is a Java-based project that allows users to assemble and configure their own custom PCs
by selecting components such as CPUs, GPUs, RAM, storage, and more. 
This project provides a flexible and interactive way to build a personalized computer setup tailored to your preferences.

# How to Use

1. **Set Up Your Environment**
   - Ensure you have Java installed on your system.
   - Clone or download the PC Configurator project to your local machine.

2. **Explore Available Components**
   - In the project, you'll find various classes representing PC components such as CPUs, GPUs, RAM, storage, and more. These classes extend the abstract `Component` class.

3. **Assemble Your Computer**
   - Sample code for assembling a computer:
    ```
     ComponentsWarehouse warehouse = new ComponentsWarehouse();
     Computer myComputer = PcConfigurator.assembleComputer(warehouse);
    
4. **Customize Your PC**
   - You can further customize your PC by choosing specific components from the `ComponentsWarehouse`. This project allows you to install various hardware components, including GPUs, audio cards, cooling devices, and more.

5. **View and Interact with Your PC**
   - Once your PC is assembled, you can interact with and view its specifications, including installed components, by interacting with the various classes provided in the project.

6. **Enjoy Your Custom PC**
   - After configuration and customization, you can enjoy your unique custom PC setup.

## Contributing

Contributions to the PC Configurator project are welcome! If you have ideas for improvements, additional features, or bug fixes, please feel free to open issues or submit pull requests.

## License

This project is open-source and available under the [MIT License](LICENSE).

Feel free to modify and adapt this description to fit the specific details and structure of your project. 
Additionally, you may want to include installation instructions, usage examples, and additional details as needed.
