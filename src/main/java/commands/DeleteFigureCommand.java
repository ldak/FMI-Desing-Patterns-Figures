package commands;

import figures.Figure;
import main.ScannerSingleton;

import java.util.List;
import java.util.Scanner;

public class DeleteFigureCommand implements Command{
    @Override
    public void execute(List<Figure> figures) {
        System.out.println("Select the figure to delete:");
        int i = ScannerSingleton.getInstance().nextInt();

        if (i > figures.size() || i < 1) {
            System.out.println("Invalid figure index");
            return;
        }
        figures.remove(i - 1);
    }
}
