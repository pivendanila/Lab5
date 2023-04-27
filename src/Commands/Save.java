package Commands;

import Exceptions.NotEnoughArguments;
import Exceptions.WrongArgument;
import Run.CollectionManager;

/**
 * Class for savinf the collection to the file.
 * @author Piven Danila @pivendanila.
 */
public class Save implements Command{
    private String name = "save";
    private CollectionManager manager;
    public Save(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {

        return this.name;
    }

    @Override
    public void execute(String[] args) throws WrongArgument, NotEnoughArguments {
        manager.updateHistory(getName());
    }

    @Override
    public String getDescription() {
        return "save collection to the file";
    }
}
