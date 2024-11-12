package commands;

import figures.Figure;
import main.ScannerSingleton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class StoreIntoFileCommand implements Command{
    @Override
    public void execute(List<Figure> figures) {
        System.out.println("Enter the file name: ");
        String fileName = ScannerSingleton.getInstance().nextLine();

        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("File already exists. Do you want to overwrite it? (y/n)");
            String answer = ScannerSingleton.getInstance().nextLine();
            if (!answer.equals("y")) {
                return;
            }
        }
        try {
            PrintWriter writer = new PrintWriter(file);
            for (Figure figure : figures) {
                writer.println(figure.toString());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
