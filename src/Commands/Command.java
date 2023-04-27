package Commands;

import Exceptions.NotEnoughArguments;
import Exceptions.WrongArgument;


public interface Command {
    public String getName();

    public void execute(String[] args) throws WrongArgument, NotEnoughArguments;

    public String getDescription();
}