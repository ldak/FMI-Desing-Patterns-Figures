package main;

import commands.Command;
import commands.CommandFactory;
import figures.Figure;
import figures.factories.FigureFactoryFactory;

import java.util.List;

public class CommandLineProgram {
    private List<Figure> figures;
    private CommandFactory commandFactory;
    private FigureFactoryFactory figureFactoryFactory;

    public CommandLineProgram(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public void start() {
        figures = loadFigures();
        while (true) {
            printMenu();
            int option = 0; // read option from user
            Command command = commandFactory.getCommand(option);
            command.execute(figures);
        }
    }

    private void printMenu() {

    }

    private List<Figure> loadFigures() {
        return null;
    }
}
