package figures.factories;

import figures.Figure;

import java.util.List;

public class ConsoleFigureFactory implements FigureFactory {
    @Override
    public List<Figure> createFigures() {
        return List.of();
    }
}
