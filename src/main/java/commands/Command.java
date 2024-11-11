package commands;

import figures.Figure;

import java.util.List;

public interface Command {
    void execute(List<Figure> figures);
}
