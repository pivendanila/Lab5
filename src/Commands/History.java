package Commands;

import Exceptions.NotEnoughArguments;
import Exceptions.WrongArgument;
import Run.CollectionManager;

/**
 * Class for displaying the History of commands.
 * @author Piven Danila @pivendanila.
 */

public class History implements Command{
    private String name = "history";
    private CollectionManager manager;
    public History(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void execute(String[] args) throws WrongArgument, NotEnoughArguments {
        System.out.println(manager.getHistory());
        manager.updateHistory(this.name);
    }

    @Override
    public String getDescription() {
        return "print the last 8 commands (without their arguments)";
    }
}
