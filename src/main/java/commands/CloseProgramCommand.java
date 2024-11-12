package commands;

import figures.Figure;
import main.ScannerSingleton;
import utils.ExitHandler;

import java.util.List;
import java.util.Scanner;

public class CloseProgramCommand implements Command{
    private final ExitHandler exitHandler;

    public CloseProgramCommand(ExitHandler exitHandler) {
        this.exitHandler = exitHandler;
    }

    @Override
    public void execute(List<Figure> figures) {
        ScannerSingleton.close();
        this.exitHandler.exit(0);
    }
}
