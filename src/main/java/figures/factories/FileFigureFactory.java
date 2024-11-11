package figures.factories;

import figures.Figure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileFigureFactory implements FigureFactory {
    private File file;
    private StringFigureFactory stringFigureFactory;

    public FileFigureFactory(String path, StringFigureFactory stringFigureFactory) throws IllegalArgumentException {
        this.file = new File(path);
        this.stringFigureFactory = stringFigureFactory;
        if (!file.exists()) {
            throw new IllegalArgumentException("File does not exist");
        }
    }

    @Override
    public List<Figure> createFigures() {
        try {
            Scanner scanner = new Scanner(file);
            List<Figure> figures = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Figure figure = stringFigureFactory.createFigure(line);
                figures.add(figure);
            }
            return figures;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
