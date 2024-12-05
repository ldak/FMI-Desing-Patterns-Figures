package commands;

import utils.ExitHandler;

import java.util.SortedMap;
import java.util.TreeMap;

public class CommandFactory {
    private ExitHandler exitHandler;

    public CommandFactory(ExitHandler exitHandler) {
        this.exitHandler = exitHandler;
    }

    public Command getCommand(CommandOptionsEnum option) {
        switch (option) {
            case LIST_ALL:
                return new ListAllCommand();
            case DUPLICATE:
                return new DuplicateFigureCommand();
            case DELETE:
                return new DeleteFigureCommand();
            case STORE_IN_FILE:
                return new StoreIntoFileCommand();
            case EXIT:
                return new CloseProgramCommand(this.exitHandler);
        }
        throw new IllegalArgumentException("Invalid option");
    }

    public SortedMap<CommandOptionsEnum, String> getOptionDescriptions() {
        return new TreeMap<>() {{
            put(CommandOptionsEnum.LIST_ALL, "List all figures");
            put(CommandOptionsEnum.DUPLICATE, "Duplicate a figure");
            put(CommandOptionsEnum.DELETE, "Delete a figure");
            put(CommandOptionsEnum.STORE_IN_FILE, "Store figures into a file");
            put(CommandOptionsEnum.EXIT, "Close the program");
        }};
    }
}
