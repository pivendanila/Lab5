package Commands;

import Exceptions.NotEnoughArguments;
import Exceptions.WrongArgument;
import Exceptions.WrongField;
import Run.CollectionManager;

import java.util.Scanner;

public class RemoveById implements Command{
    private String name = "remove_by_id";
    private CollectionManager manager;

    public RemoveById(CollectionManager manager) {
        this.manager=manager;
        while (true) {
            Scanner commandReader = new Scanner(System.in);
            try {
                System.out.println("Enter ID of Marine");
                manager.remove_at_index(manager.getById(Integer.parseInt(commandReader.nextLine())));
                break;
            } catch (WrongField | NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Wrong name. " + e.getMessage());
            }
        }
        manager.updateHistory(getName());
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
        return "remove element from collection by its id";
    }
}
