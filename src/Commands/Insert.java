package Commands;

import Collections.AstartesCategory;
import Collections.SpaceMarine;
import Exceptions.NotEnoughArguments;
import Exceptions.WrongArgument;
import Exceptions.WrongField;
import Run.CollectionManager;

import java.util.Locale;
import java.util.Scanner;

/**
 * Class for Inserting the element in collection by index.
 * @author Piven Danila @pivendanila.
 */

public class Insert implements Command{
    private String name = "insert_at";
    private CollectionManager manager;
    public Insert(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void execute(String[] args) throws WrongArgument, NotEnoughArguments {
        int index = 0;
        SpaceMarine marine = null;
        while (true) {
            Scanner commandReader = new Scanner(System.in);
            try {
                System.out.println("Enter the index");
                index = Integer.parseInt(commandReader.nextLine());
                marine = new SpaceMarine();
                while (true) {
                    try {
                        System.out.println("Enter a Marine name");
                        marine.setName(commandReader.nextLine());
                        break;
                    } catch (WrongField e) {
                        System.out.println("Wrong name. " + e.getMessage());
                    }
                }
                while (true) {
                    try {
                        System.out.println("Enter a Marine coordinates");
                        marine.setCoordinates(commandReader.nextLine());
                        break;
                    }catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
                        System.out.println("Wrong coordinates. " + e.getMessage());
                    }
                }
                while (true) {
                    try {
                        System.out.println("Enter a Marine health");
                        marine.setHealth(Float.valueOf(commandReader.nextLine()));
                        break;
                    } catch (WrongField | NumberFormatException e) {
                        System.out.println("Wrong health. " + e.getMessage());
                    }
                }
                while (true) {
                    try {
                        System.out.println("Enter a Marine loyalty (True/False)");
                        marine.setLoyal(Boolean.parseBoolean(commandReader.nextLine().toLowerCase(Locale.ROOT)));
                        break;
                    } catch (WrongField e) {
                        System.out.println("Wrong loyalty. " + e.getMessage());
                    }
                }
                while (true) {
                    try {
                        System.out.println("Enter a Marine achievements");
                        marine.setAchievements(commandReader.nextLine());
                        break;
                    } catch (WrongField e) {
                        System.out.println("Wrong Achievements. " + e.getMessage());
                    }
                }
                while (true) {
                    try {
                        System.out.println("Enter a Marine category from:\n-SCOUT\n-DREADNOUGHT\n-ASSAULT\n-TERMINATOR");
                        marine.setCategory(AstartesCategory.valueOf(commandReader.nextLine()));
                        break;
                    } catch (WrongField | IllegalArgumentException e) {
                        System.out.println("Wrong category. " + e.getMessage());
                    }
                }
                while (true) {
                    try {
                        System.out.println("Enter a Marine chapter: Name and Parent Region");
                        marine.setChapter(commandReader.nextLine());
                        break;
                    } catch (WrongField | ArrayIndexOutOfBoundsException e) {
                        System.out.println("Wrong chapter. " + e.getMessage());
                    }
                }
                break;
            }catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
                System.out.println("Wrong coordinates. " + e.getMessage());
            }
        }
        manager.insert_at_index(index, marine);
        manager.updateHistory(getName());
    }

    @Override
    public String getDescription() {
        return "add a new element at a given position(index)";
    }
}
