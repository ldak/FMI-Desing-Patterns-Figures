package figures.factories;

import utils.ScannerSingleton;
import org.junit.jupiter.api.Test;
import utils.FigureReflectionFacade;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

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
        String simulatedInput = "src/test/resources/figure1.txt\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        FigureFactoryFactory factory = new FigureFactoryFactory(new FigureReflectionFacade());
        FigureFactory figureFactory = factory.getFactory(3);
        assertInstanceOf(FileFigureFactory.class, figureFactory);
    }
}
