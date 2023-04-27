package Commands;

import Exceptions.NotEnoughArguments;
import Exceptions.WrongArgument;
import Run.CollectionManager;

public class Info implements Command{
    private String name = "info";
    private final CollectionManager manager;

    public Info(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void execute(String[] args) throws WrongArgument, NotEnoughArguments {
        System.out.println(manager.info());
        manager.updateHistory(getName());
    }

    @Override
    public String getDescription() {
        return "print information about the collection (type, initialization date, number of elements, etc.)";
    }
}
