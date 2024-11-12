package commands;

import figures.Figure;

import java.util.List;
import java.util.Scanner;

public class ListAllCommand implements Command{
    @Override
    public void execute(List<Figure> figures, Scanner scanner) {
        if(figures.isEmpty()){
            System.out.println("No figures to show");
            return;
        }
        for (Figure figure : figures) {
            System.out.println(figure);
        }
    }
}
