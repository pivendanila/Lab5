package Commands;

import Collections.SpaceMarine;
import Exceptions.NotEnoughArguments;
import Exceptions.WrongArgument;
import Exceptions.WrongField;
import Run.CollectionManager;

import java.util.LinkedList;
import java.util.Scanner;

public class FilterGreater implements Command{
    private String name = "filter_greater_than_loyal";
    private CollectionManager manager;

    public FilterGreater(CollectionManager manager) {
        this.manager=manager;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void execute(String[] args) throws WrongArgument, NotEnoughArguments {
        manager.updateHistory(getName());
        LinkedList<SpaceMarine> cur_marines = new LinkedList<>();
        LinkedList<SpaceMarine> marines = manager.getSpacemarines();
        Scanner commandReader = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter a Marine Loyalty value");
                boolean value = Boolean.parseBoolean(commandReader.nextLine());
                for(SpaceMarine marine : marines){
                    if(marine.getLoyal() == value){
                        cur_marines.add(marine);
                    }
                }
                break;
            } catch (WrongField | IllegalArgumentException e) {
                System.out.println("Wrong Loyalty. " + e.getMessage());
            }
        }
        manager.show(cur_marines);
    }

    @Override
    public String getDescription() {
        return "display elements whose value of the loyal field is greater than the given one";
    }
}
