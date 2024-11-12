package commands;

import figures.Figure;
import utils.ScannerSingleton;

import java.util.List;

public class DuplicateFigureCommand implements Command{
    @Override
    public void execute(List<Figure> figures) {
        System.out.println("Enter the index of the figure you want to duplicate:");
        try {
            int index = ScannerSingleton.getInstance().nextInt();
            if (index < 1 || index > figures.size()) {
                System.out.println("Invalid index");
                return;
            }
            Figure figure = figures.get(index - 1);
            Figure duplicate = figure.clone();
            figures.add(duplicate);
        }catch (Exception e){
            System.out.println("Invalid index");
            return;
        }

    }
}
