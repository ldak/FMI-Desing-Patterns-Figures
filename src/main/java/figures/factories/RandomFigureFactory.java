package figures.factories;

import figures.Figure;
import utils.FigureReflectionFacade;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RandomFigureFactory implements FigureFactory {
    private FigureReflectionFacade figureReflectionFacade;
    private int count;

    public RandomFigureFactory(int count, FigureReflectionFacade figureReflectionFacade) {
        this.figureReflectionFacade = figureReflectionFacade;
        this.count = count;
    }

    private Figure createFigure() {
        Set<Class<? extends Figure>> figureClasses = this.figureReflectionFacade.getFigureClasses();
        int randomIndex = (int) (Math.random() * figureClasses.size());
        Class<? extends Figure> randomFigureClass = (Class<? extends Figure>) figureClasses.toArray()[randomIndex];
        int argument_count = this.figureReflectionFacade.getConstructorArgumentCount(randomFigureClass);
        Double[] arguments = new Double[argument_count];
        for (int i = 0; i < argument_count; i++) {
            arguments[i] = (double) ((int)(Math.random() * 100)) / 10 + 20;
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
