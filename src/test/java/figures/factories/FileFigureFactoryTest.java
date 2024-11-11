package figures.factories;

import figures.Figure;
import org.junit.jupiter.api.Test;
import utils.FigureReflectionFacade;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileFigureFactoryTest {
    @Test
    public void testCreateFigure() {
        FileFigureFactory factory = new FileFigureFactory(
            "src/test/resources/figure1.txt",
                new StringFigureFactory(new FigureReflectionFacade())
        );
        List<Figure> figures = factory.createFigures();
        assertEquals(3, figures.size());
        assertEquals("Triangle 2.0 3.0 4.0", figures.get(0).toString());
        assertEquals("Rectangle 2.0 3.0", figures.get(1).toString());
        assertEquals("Circle 2.0", figures.get(2).toString());
    }

    @Test
    public void testCreateFigureWithInvalidFile() {
        assertThrows(IllegalArgumentException.class, () -> new FileFigureFactory(
            "src/test/resources/figure2.txt",
                new StringFigureFactory(new FigureReflectionFacade())
        ));
    }
}
