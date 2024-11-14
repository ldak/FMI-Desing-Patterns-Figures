package figures.factories;

import figures.Figure;
import org.junit.jupiter.api.Test;
import utils.FigureReflectionFacade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomFigureFactoryTest {

    @Test
    public void testCreateRandomFigure() {
        final int COUNT = 10000;
        final double ERROR_PERCENT = 0.1;

        RandomFigureFactory factory = new RandomFigureFactory(
                COUNT,
                new FigureReflectionFacade()
        );
        Map<String, Integer> figures_count = new HashMap<>();
        List<Figure> figures = factory.createFigures();
        for (Figure figure : figures) {
            String figure_name = figure.getClass().getSimpleName();
            if (figures_count.containsKey(figure_name)) {
                figures_count.put(figure_name, figures_count.get(figure_name) + 1);
            } else {
                figures_count.put(figure_name, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : figures_count.entrySet()) {
            double expected = (double) COUNT / figures_count.size();
            double actual = entry.getValue();
            double error = Math.abs(expected - actual) / expected;
            assertTrue(error <= ERROR_PERCENT);
        }
    }
}
