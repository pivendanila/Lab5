package Commands;

import Exceptions.NotEnoughArguments;
import Exceptions.WrongArgument;
import Run.CollectionManager;

public class Show implements Command{
    private String name = "show";
    private final CollectionManager manager;

    public Show(CollectionManager manager) {
        this.manager = manager;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void execute(String[] args) throws WrongArgument, NotEnoughArguments {
        System.out.println(manager.show());
        manager.updateHistory(getName());
    }

    @Override
    public String getDescription() {
        return "print all elements of the collection in string representation";
    }
}
