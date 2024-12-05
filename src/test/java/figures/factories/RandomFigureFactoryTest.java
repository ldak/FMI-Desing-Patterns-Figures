package figures.factories;

import figures.Circle;
import figures.Figure;
import figures.Rectangle;
import org.junit.jupiter.api.Test;
import utils.FigureReflectionFacade;

import java.util.*;
import java.util.random.RandomGenerator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RandomFigureFactoryTest {

    @Test
    public void testRandomGeneratorUsage() {
        RandomGenerator random = mock(RandomGenerator.class);
        when(random.nextInt(anyInt()))
                .thenReturn(1);
        when(random.nextDouble(anyDouble()))
                .thenReturn(3.0)
                .thenReturn(4.0);

        RandomFigureFactory factory = new RandomFigureFactory(1, new FigureReflectionFacade(), random);
        List<Figure> figures = factory.createFigures();
        Figure figure = figures.getFirst();
        assertInstanceOf(Rectangle.class, figure);
        assertEquals(14.0, figure.getPerimeter());

    }

    @Test
    public void testCreateRandomFigure() {
        final int COUNT = 1000000;
        final double ERROR_PERCENT = 0.01;

        FigureReflectionFacade reflectionFacade = new FigureReflectionFacade();
        RandomFigureFactory factory = new RandomFigureFactory(
                COUNT,
                reflectionFacade,
                new Random()
        );
        Map<String, Integer> figures_count = new HashMap<>();
        reflectionFacade.getFigureClasses().forEach(figure -> figures_count.put(figure.getSimpleName(), 0));
        List<Figure> figures = factory.createFigures();
        for (Figure figure : figures) {
            String figure_name = figure.getClass().getSimpleName();
            figures_count.put(figure_name, figures_count.get(figure_name) + 1);
        }

        for (Map.Entry<String, Integer> entry : figures_count.entrySet()) {
            double expected = (double) COUNT / figures_count.size();
            double actual = entry.getValue();
            double error = Math.abs(expected - actual) / expected;
            assertTrue(error <= ERROR_PERCENT);
        }
    }
}
