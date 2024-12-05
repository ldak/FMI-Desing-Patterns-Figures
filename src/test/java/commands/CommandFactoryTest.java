package commands;

import org.junit.jupiter.api.Test;
import utils.SystemExitHandler;

import java.util.SortedMap;

import static org.junit.jupiter.api.Assertions.*;

public class CommandFactoryTest {

    @Test
    public void testCreateCloseProgramCommand() {
        CommandFactory commandFactory = new CommandFactory(new SystemExitHandler());
        Command command = commandFactory.getCommand(CommandOptionsEnum.EXIT);
        assertInstanceOf(CloseProgramCommand.class, command);
    }

    @Test
    public void testCreateListAllCommand() {
        CommandFactory commandFactory = new CommandFactory(new SystemExitHandler());
        Command command = commandFactory.getCommand(CommandOptionsEnum.LIST_ALL);
        assertInstanceOf(ListAllCommand.class, command);
    }

    @Test
    public void testCreateDuplicateFigureCommand() {
        CommandFactory commandFactory = new CommandFactory(new SystemExitHandler());
        Command command = commandFactory.getCommand(CommandOptionsEnum.DUPLICATE);
        assertInstanceOf(DuplicateFigureCommand.class, command);
    }

    @Test
    public void testCreateDeleteFigureCommand() {
        CommandFactory commandFactory = new CommandFactory(new SystemExitHandler());
        Command command = commandFactory.getCommand(CommandOptionsEnum.DELETE);
        assertInstanceOf(DeleteFigureCommand.class, command);
    }

    @Test
    public void testCreateStoreIntoFileCommand() {
        CommandFactory commandFactory = new CommandFactory(new SystemExitHandler());
        Command command = commandFactory.getCommand(CommandOptionsEnum.STORE_IN_FILE);
        assertInstanceOf(StoreIntoFileCommand.class, command);
    }

    @Test
    public void testGetDescriptions() {
        CommandFactory commandFactory = new CommandFactory(new SystemExitHandler());
        SortedMap<CommandOptionsEnum, String> descriptions = commandFactory.getOptionDescriptions();
        assertEquals(5, descriptions.size());
    }
}
