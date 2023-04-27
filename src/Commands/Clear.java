package Commands;

import Exceptions.NotEnoughArguments;
import Exceptions.WrongArgument;
import Run.CollectionManager;


/**
 * Class for clearing collection.
 * @author Piven Danila @pivendanila.
 */
public class Clear implements Command{
    private String name = "clear";
    private final CollectionManager collectionManager;

    public Clear(CollectionManager manager) {
        this.collectionManager = manager;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void execute(String[] args) throws WrongArgument, NotEnoughArguments {
        collectionManager.clear();
        collectionManager.updateHistory(getName());
    }

    @Override
    public String getDescription() {
        return "clear collection";
    }
}
