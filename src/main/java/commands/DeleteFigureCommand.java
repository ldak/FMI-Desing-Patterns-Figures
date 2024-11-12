package commands;

import figures.Figure;
import utils.ScannerSingleton;

import java.util.List;

public class DeleteFigureCommand implements Command{
    @Override
    public void execute(List<Figure> figures) {
        System.out.println("Select the figure to delete:");
        try {
            int i = ScannerSingleton.getInstance().nextInt();
            if (i > figures.size() || i < 1) {
                System.out.println("Invalid figure index");
                return;
            }
            figures.remove(i - 1);
        }catch (Exception e){
            System.out.println("Invalid figure index");
            ScannerSingleton.getInstance().nextLine();
        }
    }
}
