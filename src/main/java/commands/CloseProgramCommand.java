package commands;

import figures.Figure;

import java.util.List;

public class CloseProgramCommand implements Command{
    @Override
    public void execute(List<Figure> figures) {
        System.exit(0);
    }
}
