package commands;

import utils.ExitHandler;

public class CommandFactory {
    private ExitHandler exitHandler;

    public CommandFactory(ExitHandler exitHandler) {
        this.exitHandler = exitHandler;
    }

    public Command getCommand(int option) {
        switch (option) {
            case 1:
                return new ListAllCommand();
            case 2:
                return new DuplicateFigureCommand();
            case 3:
                return new DeleteFigureCommand();
            case 4:
                return new StoreIntoFileCommand();
            case 5:
                return new CloseProgramCommand(this.exitHandler);
        }
        throw new IllegalArgumentException("Invalid option");
    }

    public String[] getOptionDescriptions() {
        return new String[] {
            "1. List all figures",
            "2. Duplicate a figure",
            "3. Delete a figure",
            "4. Store figures into a file",
            "5. Close the program"
        };
    }
}
