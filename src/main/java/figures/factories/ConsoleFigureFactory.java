package figures.factories;

import figures.Figure;
import utils.FigureReflectionFacade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleFigureFactory implements FigureFactory {
    private FigureReflectionFacade figureReflectionFacade;
    private StringFigureFactory stringFigureFactory;

    public ConsoleFigureFactory(FigureReflectionFacade figureReflectionFacade, StringFigureFactory stringFigureFactory) {
        this.figureReflectionFacade = figureReflectionFacade;
        this.stringFigureFactory = stringFigureFactory;
    }

    @Override
    public List<Figure> createFigures() {
        Scanner sc = new Scanner(System.in);
        List<Figure> figures = new ArrayList<>();
        while (true) {
            printMenu();
            String option = sc.nextLine();
            if (option.equals("exit")) {
                return figures;
            }

            try {
                Figure figure = this.stringFigureFactory.createFigure(option);
                figures.add(figure);
            } catch (Exception e) {
                System.out.println("Invalid figure name or parameters");
                String validFigures = String.join(" ", this.figureReflectionFacade.getFigureNames());
                System.out.println("Valid figures: " + validFigures);
            }
        }
    }

    private void printMenu() {
        System.out.println("Enter figure name and parameters separated by space or 'exit' to finish:");
    }
}
