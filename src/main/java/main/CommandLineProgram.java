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
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            int option = scanner.nextInt();
            Command command = commandFactory.getCommand(option);
            command.execute(figures, scanner);
        }
    }

    private void printMenu() {
        System.out.println("Choose an option:");
        for (String commandDescription : commandFactory.getOptionDescriptions()) {
            System.out.println(commandDescription);
        }
    }

    private List<Figure> loadFigures() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose how to load figures:");
            for (String factoryDescription : figureFactoryFactory.getOptionDescriptions()) {
                System.out.println(factoryDescription);
            }
            int option = scanner.nextInt();
            try {
                List<Figure> figures = figureFactoryFactory.getFactory(option).createFigures();
                scanner.close();
                return figures;
            } catch (Exception e) {
                System.out.println("Invalid option. Try again.");
            }
        }
    }
}
