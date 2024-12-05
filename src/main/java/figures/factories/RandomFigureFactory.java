package figures.factories;

import figures.Figure;
import figures.Triangle;
import utils.FigureReflectionFacade;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.random.RandomGenerator;

public class RandomFigureFactory implements FigureFactory {
    private final FigureReflectionFacade figureReflectionFacade;
    private final RandomGenerator randomGenerator;
    private final int count;
    private final int MAX_ARGUMENT = 1000;

    public RandomFigureFactory(int count, FigureReflectionFacade figureReflectionFacade, RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
        this.figureReflectionFacade = figureReflectionFacade;
        this.count = count;
    }

    private Figure createFigure() {
        Set<Class<? extends Figure>> figureClasses = this.figureReflectionFacade.getFigureClasses();
        int randomIndex = randomGenerator.nextInt(figureClasses.size());
        Class<? extends Figure> randomFigureClass = (Class<? extends Figure>) figureClasses.toArray()[randomIndex];
        int argument_count = this.figureReflectionFacade.getConstructorArgumentCount(randomFigureClass);
        Double[] arguments = new Double[argument_count];
        for (int i = 0; i < argument_count; i++) {
            arguments[i] = this.randomGenerator.nextDouble(this.MAX_ARGUMENT);
        }
        if (randomFigureClass.equals(Triangle.class)) {
            double min = Math.abs(arguments[0] - arguments[1]);
            double max = arguments[0] + arguments[1];
            arguments[2] = min + (max - min) * (arguments[2] / this.MAX_ARGUMENT);
        }
        return this.figureReflectionFacade.getFigure(randomFigureClass, arguments);
    }

    @Override
    public List<Figure> createFigures() {
        List<Figure> figures = new ArrayList<>();
        for (int i = 0; i < this.count; i++) {
            figures.add(this.createFigure());
        }
        return figures;
    }
}
