package Commands;

import Collections.SpaceMarine;
import Exceptions.NotEnoughArguments;
import Exceptions.WrongArgument;
import Run.CollectionManager;

import java.util.LinkedList;

/**
 * Class for Printing Descending of collection.
 * @author Piven Danila @pivendanila.
 */
public class PrintDescending implements Command{
    private String name = "print_descending";
    private CollectionManager manager;
    public PrintDescending(CollectionManager manager) {
        this.manager=manager;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void execute(String[] args) throws WrongArgument, NotEnoughArguments {
        manager.updateHistory(getName());
        LinkedList<SpaceMarine> marines = manager.getSpacemarines();
        System.out.println(manager.show(marines));
    }

    @Override
    public String getDescription() {
        return "display the elements of the collection in descending order";
    }
}
