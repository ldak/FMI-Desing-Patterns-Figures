package commands;

import figures.Figure;

import java.util.List;
import java.util.Scanner;

public class DuplicateFigureCommand implements Command{
    @Override
    public void execute(List<Figure> figures, Scanner scanner) {
        System.out.println("Enter the index of the figure you want to duplicate:");
        int index = scanner.nextInt();
        if (index < 1 || index > figures.size()) {
            System.out.println("Invalid index");
            return;
        }
        Figure figure = figures.get(index - 1);
        Figure duplicate = figure.clone();
        figures.add(duplicate);
    }
}
