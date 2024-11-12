package commands;

import figures.Figure;
import figures.Rectangle;
import figures.Triangle;
import main.ScannerSingleton;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class DeleteFigureCommandTest {

    @Test
    public void testExecute() {
        List<Figure> figures = new ArrayList<>();
        figures.add(new Triangle(2, 2, 3));
        figures.add(new Rectangle(2, 3));
        DeleteFigureCommand deleteFigureCommand = new DeleteFigureCommand();
        String simulatedInput = "2\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        ScannerSingleton.setInstance(sc);
        deleteFigureCommand.execute(figures);
        assertEquals(1, figures.size());
        assertInstanceOf(Triangle.class, figures.getFirst());
    }

    @Test
    public void testExecute2() {
        List<Figure> figures = new ArrayList<>();
        figures.add(new Triangle(2, 2, 3));
        figures.add(new Rectangle(2, 3));
        DeleteFigureCommand deleteFigureCommand = new DeleteFigureCommand();
        String simulatedInput = "1\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        ScannerSingleton.setInstance(sc);
        deleteFigureCommand.execute(figures);
        assertEquals(1, figures.size());
        assertInstanceOf(Rectangle.class, figures.getFirst());
    }

    @Test
    public void testExecuteWithInvalidIndex() {
        List<Figure> figures = new ArrayList<>();
        figures.add(new Triangle(2, 2, 3));
        figures.add(new Rectangle(2, 3));
        DeleteFigureCommand deleteFigureCommand = new DeleteFigureCommand();
        String simulatedInput = "3\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        ScannerSingleton.setInstance(sc);
        deleteFigureCommand.execute(figures);
        assertEquals(2, figures.size());
    }
}
