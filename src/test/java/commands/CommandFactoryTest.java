package commands;

import org.junit.jupiter.api.Test;
import utils.SystemExitHandler;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommandFactoryTest {

    @Test
    public void testCreateCloseProgramCommand() {
        CommandFactory commandFactory = new CommandFactory(new SystemExitHandler());
        Command command = commandFactory.getCommand(5);
        assertInstanceOf(CloseProgramCommand.class, command);
    }

    @Test
    public void testCreateListAllCommand() {
        CommandFactory commandFactory = new CommandFactory(new SystemExitHandler());
        Command command = commandFactory.getCommand(1);
        assertInstanceOf(ListAllCommand.class, command);
    }

    @Test
    public void testCreateDuplicateFigureCommand() {
        CommandFactory commandFactory = new CommandFactory(new SystemExitHandler());
        Command command = commandFactory.getCommand(2);
        assertInstanceOf(DuplicateFigureCommand.class, command);
    }

    @Test
    public void testCreateDeleteFigureCommand() {
        CommandFactory commandFactory = new CommandFactory(new SystemExitHandler());
        Command command = commandFactory.getCommand(3);
        assertInstanceOf(DeleteFigureCommand.class, command);
    }

    @Test
    public void testCreateStoreIntoFileCommand() {
        CommandFactory commandFactory = new CommandFactory(new SystemExitHandler());
        Command command = commandFactory.getCommand(4);
        assertInstanceOf(StoreIntoFileCommand.class, command);
    }

    @Test
    public void testCreateInvalidOption() {
        CommandFactory commandFactory = new CommandFactory(new SystemExitHandler());
        assertThrows(IllegalArgumentException.class, () -> commandFactory.getCommand(6));
    }

    @Test
    public void testCreateInvalidOptionNegative() {
        CommandFactory commandFactory = new CommandFactory(new SystemExitHandler());
        assertThrows(IllegalArgumentException.class, () -> commandFactory.getCommand(-1));
    }
}
