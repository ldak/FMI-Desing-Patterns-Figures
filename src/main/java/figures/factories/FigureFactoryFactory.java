package figures.factories;

import utils.ScannerSingleton;
import utils.FigureReflectionFacade;

import java.util.*;
import java.util.random.RandomGenerator;

public class FigureFactoryFactory {
    private final FigureReflectionFacade figureReflectionFacade;
    private final RandomGenerator randomGenerator;

    public FigureFactoryFactory(FigureReflectionFacade figureReflectionFacade, RandomGenerator randomGenerator) {
        this.figureReflectionFacade = figureReflectionFacade;
        this.randomGenerator = randomGenerator;
    }

    public FigureFactory getFactory(FigureFactoryOptionsEnum option) {
        switch (option) {
            case RANDOM_FIGURE_FACTORY:
               return getRandomFigureFactory();
            case CONSOLE_FIGURE_FACTORY:
                return new ConsoleFigureFactory(this.figureReflectionFacade, this.getStringFigureFactory());
            case FILE_FIGURE_FACTORY:
                return getFileFigureFactory();
        }
        throw new IllegalArgumentException("Invalid option");
    }

    private FileFigureFactory getFileFigureFactory() {
        System.out.println("Enter the file path: ");
        ScannerSingleton.getInstance().nextLine();
        String filePath = ScannerSingleton.getInstance().nextLine();

        return new FileFigureFactory(filePath, this.getStringFigureFactory());
    }

    private RandomFigureFactory getRandomFigureFactory() {
        System.out.println("Enter the number of figures to create: ");
        int numberOfFigures = ScannerSingleton.getInstance().nextInt();

        return new RandomFigureFactory(numberOfFigures, this.figureReflectionFacade, this.randomGenerator);
    }

    private StringFigureFactory getStringFigureFactory() {
        return new StringFigureFactory(this.figureReflectionFacade);
    }

    public SortedMap<FigureFactoryOptionsEnum, String> getOptionDescriptions() {
        return new TreeMap<>() {{
            put(FigureFactoryOptionsEnum.RANDOM_FIGURE_FACTORY, "For creating figures with random values");
            put(FigureFactoryOptionsEnum.CONSOLE_FIGURE_FACTORY, "For creating figures with user input values");
            put(FigureFactoryOptionsEnum.FILE_FIGURE_FACTORY, "For reading figures from a file");
        }};
    }
}
