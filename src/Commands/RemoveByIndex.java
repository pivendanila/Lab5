package Commands;

import Exceptions.NotEnoughArguments;
import Exceptions.WrongArgument;
import Exceptions.WrongField;
import Run.CollectionManager;

import java.util.Scanner;

/**
 * Class for Removing elements by Index.
 * @author Piven Danila @pivendanila.
 */
public class RemoveByIndex implements Command{
    private String name = "remove_at";
    CollectionManager manager;
    public RemoveByIndex(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {

        return this.name;
    }

    @Override
    public void execute(String[] args) throws WrongArgument, NotEnoughArguments {
        while (true) {
            Scanner commandReader = new Scanner(System.in);
            try {
                System.out.println("Enter index of Marine");
                manager.remove_at_index(Integer.parseInt(commandReader.nextLine()));
                break;
            } catch (WrongField | NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Wrong name. " + e.getMessage());
            }
        }
        manager.updateHistory(getName());
    }

    @Override
    public String getDescription() {
        return "remove the element at the given position in the collection (index)";
    }
}
