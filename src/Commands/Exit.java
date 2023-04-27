package Commands;

import Exceptions.NotEnoughArguments;
import Exceptions.WrongArgument;

/**
 * Class for Terminating the programm.
 * @author Piven Danila @pivendanila.
 */
public class Exit implements Command{
    private String name = "exit";

    @Override
    public String getName() {

        return this.name;
    }

    @Override
    public void execute(String[] args) throws WrongArgument, NotEnoughArguments {
        System.out.println("Program is terminated.");
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return "terminate program (without saving to file)";
    }
}
