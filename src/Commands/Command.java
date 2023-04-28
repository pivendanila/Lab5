package Commands;

import Exceptions.NotEnoughArguments;
import Exceptions.WrongArgument;

import java.io.IOException;

/**
 * Base interface of Commands
 * @author Piven Danila @pivendanila.
 */
public interface Command {
    String getName();
    void execute(String[] args) throws WrongArgument, NotEnoughArguments, IOException;
    String getDescription();
}