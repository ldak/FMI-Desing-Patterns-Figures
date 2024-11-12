package commands;

import figures.Figure;
import figures.Triangle;
import utils.ScannerSingleton;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class DuplicateFigureCommandTest {
    @Test
    public void testExecute() {
        List<Figure> figures = new ArrayList<>();
        figures.add(new Triangle(2, 2, 3));
        DuplicateFigureCommand duplicateFigureCommand = new DuplicateFigureCommand();
        String simulatedInput = "1\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        ScannerSingleton.setInstance(sc);

        duplicateFigureCommand.execute(figures);
        assertEquals(2, figures.size());
        assertInstanceOf(Triangle.class, figures.get(1));
    }

    @Test
    public void testExecuteWithInvalidIndex() {
        List<Figure> figures = new ArrayList<>();
        figures.add(new Triangle(2, 2, 3));
        DuplicateFigureCommand duplicateFigureCommand = new DuplicateFigureCommand();
        String simulatedInput = "2\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        ScannerSingleton.setInstance(sc);
        duplicateFigureCommand.execute(figures);
        assertEquals(1, figures.size());
    }
}
