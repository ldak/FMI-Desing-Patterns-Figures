package commands;

import figures.Figure;

import java.util.List;
import java.util.Scanner;

public interface Command {
    void execute(List<Figure> figures);
}
