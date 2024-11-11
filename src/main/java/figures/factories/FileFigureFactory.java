package figures.factories;

import figures.Figure;

import java.util.List;

public class FileFigureFactory implements FigureFactory{
    @Override
    public List<Figure> createFigures() {
        return List.of();
    }
}
