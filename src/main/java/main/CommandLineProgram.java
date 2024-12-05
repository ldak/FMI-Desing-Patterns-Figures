package main;

import commands.Command;
import commands.CommandFactory;
import commands.CommandOptionsEnum;
import figures.Figure;
import figures.factories.FigureFactoryFactory;
import figures.factories.FigureFactoryOptionsEnum;
import utils.ScannerSingleton;

import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class CommandLineProgram {
    private List<Figure> figures;
    private CommandFactory commandFactory;
    private FigureFactoryFactory figureFactoryFactory;

    public CommandLineProgram(CommandFactory commandFactory, FigureFactoryFactory figureFactoryFactory) {
        this.commandFactory = commandFactory;
        this.figureFactoryFactory = figureFactoryFactory;
    }

    public void start() {
        figures = loadFigures();

        SortedMap<CommandOptionsEnum, String> options = commandFactory.getOptionDescriptions();
        while (true) {
            printMenu(options);
            try {
                CommandOptionsEnum option = selectOption(options);
                Command command = commandFactory.getCommand(option);
                command.execute(figures);
            } catch (Exception e) {
                System.out.println("Invalid option. Try again.");
                ScannerSingleton.getInstance().nextLine();
            }

        }
    }

    private <T> void printMenu(SortedMap<T, String> options) {
        System.out.println("Choose an option:");
        int i = 1;
        for (String description : options.values()) {
            System.out.println(i + ". " + description);
            i++;
        }
    }

    private <T> T selectOption(SortedMap<T, String> options) {
        int option = ScannerSingleton.getInstance().nextInt();
        return  (T) options.keySet().toArray()[option - 1];
    }

    private List<Figure> loadFigures() {
        while (true) {
            System.out.println("Choose how to load figures:");
            SortedMap<FigureFactoryOptionsEnum, String> options = figureFactoryFactory.getOptionDescriptions();
            printMenu(options);
            try {
                FigureFactoryOptionsEnum selectedOption = selectOption(options);
                return figureFactoryFactory.getFactory(selectedOption).createFigures();
            } catch (Exception e) {
                System.out.println("Invalid option. Try again.");
                ScannerSingleton.getInstance().nextLine();
            }
        }
    }
}
