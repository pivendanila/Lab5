package Commands;

import Collections.AstartesCategory;
import Collections.SpaceMarine;
import Exceptions.NotEnoughArguments;
import Exceptions.WrongArgument;
import Exceptions.WrongField;
import Run.CollectionManager;

import java.util.LinkedList;
import java.util.Scanner;

public class CountGreater implements Command{
    private String name = "count_greater_than_health";
    private CollectionManager manager;

    public CountGreater(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void execute(String[] args) throws WrongArgument, NotEnoughArguments {
        manager.updateHistory(getName());
        LinkedList<SpaceMarine> cur_marines = manager.getSpacemarines();
        Scanner commandReader = new Scanner(System.in);
        int cnt = 0;

        while (true) {
            try {
                System.out.println("Enter a Marine Health value");
                int value = Integer.parseInt(commandReader.nextLine());
                for(SpaceMarine marine : cur_marines){
                    if(marine.getHealth() > value){
                        cnt++;
                    }
                }
                break;
            } catch (WrongField | IllegalArgumentException e) {
                System.out.println("Wrong Health. " + e.getMessage());
            }
        }
        System.out.println(cnt);
    }

    @Override
    public String getDescription() {
        return "display the number of elements whose health field value is greater than the given one";
    }
}
