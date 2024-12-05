package main;

import commands.CommandFactory;
import figures.factories.FigureFactoryFactory;
import utils.FigureReflectionFacade;
import utils.SystemExitHandler;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        CommandFactory commandFactory = new CommandFactory(new SystemExitHandler());
        FigureFactoryFactory figureFactoryFactory = new FigureFactoryFactory(new FigureReflectionFacade(), new Random());

        CommandLineProgram program = new CommandLineProgram(commandFactory, figureFactoryFactory);
        program.start();
    }
}