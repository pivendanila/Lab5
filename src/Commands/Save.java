package Commands;

import Exceptions.NotEnoughArguments;
import Exceptions.WrongArgument;
import Run.CollectionManager;

import java.io.IOException;

/**
 * Class for savinf the collection to the file with generated uniq name.
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
    public void execute(String[] args) throws WrongArgument, NotEnoughArguments, IOException {
        manager.updateHistory(getName());
        manager.save();
    }

    @Override
    public String getDescription() {
        return "save collection to the file";
    }
}
