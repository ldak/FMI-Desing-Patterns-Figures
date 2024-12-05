package figures.factories;

import utils.ScannerSingleton;
import org.junit.jupiter.api.Test;
import utils.FigureReflectionFacade;

import java.io.ByteArrayInputStream;
import java.util.Random;
import java.util.Scanner;
import java.util.SortedMap;

import static org.junit.jupiter.api.Assertions.*;

public class FigureFactoryFactoryTest {

    @Test
    public void testGetRandomFigureFactory() {
        String simulatedInput = "6\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        ScannerSingleton.setInstance(sc);
        FigureFactoryFactory factory = new FigureFactoryFactory(new FigureReflectionFacade(), new Random());
        FigureFactory figureFactory = factory.getFactory(FigureFactoryOptionsEnum.RANDOM_FIGURE_FACTORY);
        assertInstanceOf(RandomFigureFactory.class, figureFactory);
    }

    @Test
    public void testGetConsoleFigureFactory() {
        FigureFactoryFactory factory = new FigureFactoryFactory(new FigureReflectionFacade(), new Random());
        FigureFactory figureFactory = factory.getFactory(FigureFactoryOptionsEnum.CONSOLE_FIGURE_FACTORY);
        assertInstanceOf(ConsoleFigureFactory.class, figureFactory);
    }

    @Test
    public void testGetFileFigureFactory() {
        String simulatedInput = "\nsrc/test/resources/figure1.txt\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        ScannerSingleton.setInstance(sc);

        FigureFactoryFactory factory = new FigureFactoryFactory(new FigureReflectionFacade(), new Random());
        FigureFactory figureFactory = factory.getFactory(FigureFactoryOptionsEnum.FILE_FIGURE_FACTORY);
        assertInstanceOf(FileFigureFactory.class, figureFactory);
    }

    @Test
    public void testGetOptionDescriptions() {
        FigureFactoryFactory factory = new FigureFactoryFactory(new FigureReflectionFacade(), new Random());
        SortedMap<FigureFactoryOptionsEnum, String> options = factory.getOptionDescriptions();
        assertEquals(3, options.size());
    }
}
