package commands;

import org.junit.jupiter.api.Test;
import utils.ExitHandler;

import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.*;

public class CloseProgramCommandTest {

    @Test
    public void testCloseProgramCommand() {
        ExitHandler mockExitHandler = mock(ExitHandler.class);
        CloseProgramCommand closeProgramCommand = new CloseProgramCommand(mockExitHandler);
        closeProgramCommand.execute(List.of());
        verify(mockExitHandler).exit(0);
    }
}
