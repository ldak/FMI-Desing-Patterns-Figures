package figures.factories;

import utils.ScannerSingleton;
import org.junit.jupiter.api.Test;
import utils.FigureReflectionFacade;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class FigureFactoryFactoryTest {

    @Test
    public void testGetRandomFigureFactory() {
        String simulatedInput = "6\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        ScannerSingleton.setInstance(sc);
        FigureFactoryFactory factory = new FigureFactoryFactory(new FigureReflectionFacade());
        FigureFactory figureFactory = factory.getFactory(1);
        assertInstanceOf(RandomFigureFactory.class, figureFactory);
    }

    @Test
    public void testGetConsoleFigureFactory() {
        FigureFactoryFactory factory = new FigureFactoryFactory(new FigureReflectionFacade());
        FigureFactory figureFactory = factory.getFactory(2);
        assertInstanceOf(ConsoleFigureFactory.class, figureFactory);
    }

    @Test
    public void testGetFileFigureFactory() {
        String simulatedInput = "\nsrc/test/resources/figure1.txt\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        ScannerSingleton.setInstance(sc);

        FigureFactoryFactory factory = new FigureFactoryFactory(new FigureReflectionFacade());
        FigureFactory figureFactory = factory.getFactory(3);
        assertInstanceOf(FileFigureFactory.class, figureFactory);
    }

    @Test
    public void testInvalidOption() {
        FigureFactoryFactory factory = new FigureFactoryFactory(new FigureReflectionFacade());

        assertThrows(IllegalArgumentException.class, () -> {
            factory.getFactory(4);
        });
    }

    @Test
    public void testGetOptionDescriptions() {
        FigureFactoryFactory factory = new FigureFactoryFactory(new FigureReflectionFacade());
        String[] descriptions = factory.getOptionDescriptions();
        assertEquals(3, descriptions.length);
    }
}
