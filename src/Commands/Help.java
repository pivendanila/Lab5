package Commands;

import Exceptions.NotEnoughArguments;
import Exceptions.WrongArgument;
import Run.CollectionManager;

import java.util.HashMap;

/**
 * Class for displaying Help information.
 * @author Piven Danila @pivendanila.
 */
public class Help implements Command{
    private String name = "help";
    private CollectionManager manager;

    private final HashMap<String, Command> commands;

    public Help(HashMap<String, Command> commands, CollectionManager manager) {
        this.commands = commands;
        this.manager = manager;
    }

    @Override
    public String getName() {

        return this.name;
    }

    @Override
    public void execute(String[] args) throws WrongArgument, NotEnoughArguments {
        for(String command : this.commands.keySet()){
            System.out.println(command + ": " + this.commands.get(command).getDescription());
        }
        manager.updateHistory(getName());
    }

    @Override
    public String getDescription() {
        return "display help on available commands";
    }
}
