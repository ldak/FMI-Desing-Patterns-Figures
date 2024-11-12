package main;

import commands.Command;
import commands.CommandFactory;
import figures.Figure;
import figures.factories.FigureFactoryFactory;

import java.util.List;
import java.util.Scanner;

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
        while (true) {
            printMenu();
            try {
                int option = ScannerSingleton.getInstance().nextInt();
                Command command = commandFactory.getCommand(option);
                command.execute(figures);
            } catch (Exception e) {
                System.out.println("Invalid option. Try again.");
            }

        }
    }

    private void printMenu() {
        System.out.println("Choose an option:");
        for (String commandDescription : commandFactory.getOptionDescriptions()) {
            System.out.println(commandDescription);
        }
    }

    private List<Figure> loadFigures() {
        while (true) {
            System.out.println("Choose how to load figures:");
            for (String factoryDescription : figureFactoryFactory.getOptionDescriptions()) {
                System.out.println(factoryDescription);
            }
            int option = ScannerSingleton.getInstance().nextInt();
            try {
                return figureFactoryFactory.getFactory(option).createFigures();
            } catch (Exception e) {
                System.out.println("Invalid option. Try again.");
            }
        }
    }
}
