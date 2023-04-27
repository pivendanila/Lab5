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
 * Class for updating the element by ID.
 * @author Piven Danila @pivendanila.
 */
public class Update implements Command{
    public String name = "update_id";
    private CollectionManager manager;

    public Update(CollectionManager manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void execute(String[] args) throws WrongArgument, NotEnoughArguments {
        manager.updateHistory(getName());
        int id = 0;
        SpaceMarine marine = null;
        while (true) {
            Scanner commandReader = new Scanner(System.in);
            try {
                System.out.println("Enter the ID");
                id = Integer.parseInt(commandReader.nextLine());
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
        manager.insert_at_index(manager.getById(id), marine);
        manager.updateHistory(getName());
    }

    @Override
    public String getDescription() {
        return "update the value of the collection element whose id is equal to the given one";
    }
}
