package figures.factories;

import figures.Figure;
import utils.FigureReflectionFacade;

import java.util.Set;

public class RandomFigureFactory implements FigureFactory {
    private FigureReflectionFacade figureReflectionFacade;

    public RandomFigureFactory(FigureReflectionFacade figureReflectionFacade) {
        this.figureReflectionFacade = figureReflectionFacade;
    }

    @Override
    public Figure createFigure() {
        Set<Class<? extends Figure>> figureClasses = this.figureReflectionFacade.getFigureClasses();
        int randomIndex = (int) (Math.random() * figureClasses.size());
        Class<? extends Figure> randomFigureClass = (Class<? extends Figure>) figureClasses.toArray()[randomIndex];
        int argument_count = this.figureReflectionFacade.getConstructorArgumentCount(randomFigureClass);
        Double[] arguments = new Double[argument_count];
        for (int i = 0; i < argument_count; i++) {
            arguments[i] = Math.random() * 10 + 20;
        }
        return this.figureReflectionFacade.getFigure(randomFigureClass, arguments);
    }
}
