package Run;

import Commands.*;
import Exceptions.NotEnoughArguments;
import Exceptions.WrongArgument;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Executor {
    private final CollectionManager manager;
    public final HashMap<String, Command> commands;

    /**
     * Class of Executor. Works with command line. Read commands and execute them.
     *
     * @author Piven Danila @pivendanila.
     */
    public Executor(CollectionManager collectionManager) {
        this.manager = collectionManager;
        this.commands = new HashMap<>();
        Help help = new Help(commands, manager);
        Info info = new Info(manager);
        Show show = new Show(manager);
        Add add = new Add(manager);
        Update update = new Update(manager);
        RemoveById removeid = new RemoveById(manager);
        Clear clear = new Clear(manager);
        Save save = new Save(manager);
        ExecuteScript execute = new ExecuteScript(manager, this.commands);
        Exit exit = new Exit();
        Insert insert = new Insert(manager);
        RemoveByIndex removeindex = new RemoveByIndex(manager);
        History history_func = new History(manager);
        CountGreater count = new CountGreater(manager);
        FilterGreater filter = new FilterGreater(manager);
        PrintDescending print = new PrintDescending(manager);
        commands.put(help.getName(), help);
        commands.put(info.getName(), info);
        commands.put(show.getName(), show);
        commands.put(add.getName(), add);
        commands.put(update.getName(), update);
        commands.put(removeid.getName(), removeid);
        commands.put(clear.getName(), clear);
        commands.put(save.getName(), save);
        commands.put(execute.getName(), execute);
        commands.put(exit.getName(), exit);
        commands.put(insert.getName(), insert);
        commands.put(removeindex.getName(), removeindex);
        commands.put(history_func.getName(), history_func);
        commands.put(count.getName(), count);
        commands.put(filter.getName(), filter);
        commands.put(print.getName(), print);
    }

    /**
     * Method for entering the Interective mode.
     */
    public void interactiveMod() {
        System.out.println("Interective mode entered");
        Scanner commandReader = new Scanner(System.in);
        boolean t = true;
        while (t) {
            System.out.println("\nEnter the command");
            try {
                String[] argsArray = parseInput(commandReader.nextLine());

                Command command = getCommand(argsArray[0]);

                if (command == null) {
                    System.out.println("Not a command.");
                    continue;
                }
                command.execute(argsArray);


            } catch (WrongArgument e) {
                System.out.println("Wrong argument." + e.getMessage());
            } catch (NotEnoughArguments | NoSuchElementException e) {
                t = false;
                System.out.println("Not enough arguments. " + e.getMessage());
            }
        }

    }

    private String[] parseInput(String line) {
        if (line.length() == 0) return new String[]{""};
        Matcher mather = Pattern.compile("[^\" ]+|\"[^\"]*\"").matcher(line);

        ArrayList<String> list = new ArrayList<>();
        while (mather.find()) {
            list.add(mather.group().replaceAll("\"", ""));
        }
        String[] argsArray = new String[list.size()];
        argsArray = list.toArray(argsArray);
        argsArray[0] = argsArray[0].toLowerCase();
        return argsArray;
    }

    private Command getCommand(String command) {
        if (!commands.containsKey(command)) {
            return null;
        }
        return commands.get(command);
    }
}