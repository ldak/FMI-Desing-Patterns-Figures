package figures.factories;

import utils.FigureReflectionFacade;

import java.util.Scanner;

public class FigureFactoryFactory {
    private FigureReflectionFacade figureReflectionFacade;

    public FigureFactoryFactory(FigureReflectionFacade figureReflectionFacade) {
        this.figureReflectionFacade = figureReflectionFacade;
    }

    public FigureFactory getFactory(int option) {
        switch (option) {
            case 1:
               return getRandomFigureFactory();
            case 2:
                return new ConsoleFigureFactory(this.figureReflectionFacade, this.getStringFigureFactory());
            case 3:
                return getFileFigureFactory();
        }
        throw new IllegalArgumentException("Invalid option");
    }

    private FileFigureFactory getFileFigureFactory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path: ");
        String filePath = scanner.nextLine();
        scanner.close();

        return new FileFigureFactory(filePath, this.getStringFigureFactory());
    }

    private RandomFigureFactory getRandomFigureFactory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of figures to create: ");
        int numberOfFigures = scanner.nextInt();
        scanner.close();

        return new RandomFigureFactory(numberOfFigures, this.figureReflectionFacade);
    }

    private StringFigureFactory getStringFigureFactory() {
        return new StringFigureFactory(this.figureReflectionFacade);
    }

    public String[] getOptionDescriptions() {
        return new String[] {
            "1. For creating figures with random values",
            "2. For creating figures with user input values",
            "3. For reading figures from a file",
        };
    }
}
