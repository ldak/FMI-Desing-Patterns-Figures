package figures.factories;

import figures.Figure;
import javafx.util.Pair;
import utils.FigureReflectionFacade;



public class StringFigureFactory{

    private FigureReflectionFacade figureReflectionFacade;

    public StringFigureFactory(FigureReflectionFacade figureReflectionFacade) {
        this.figureReflectionFacade = figureReflectionFacade;
    }

    public Figure createFigure(String input) throws IllegalArgumentException {
        Pair<String, Double[]> formated_input = formatInput(input);
        String figureType = formated_input.getKey();
        Double[] params = formated_input.getValue();

        Class<? extends Figure> figureClass = figureReflectionFacade.getFigureClass(figureType);

        return figureReflectionFacade.getFigure(figureClass, params);
    }

    private Pair<String, Double[]> formatInput(String input) {
        //split by all whitespaces
        String[] parts = input.split("\\s+");
        String figureType = parts[0];
        Double[] params = new Double[parts.length - 1];
        for (int i = 1; i < parts.length; i++) {
            params[i - 1] = Double.parseDouble(parts[i]);
        }
        return new Pair<>(figureType, params);
    }



}
