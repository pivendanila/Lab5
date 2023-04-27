package Commands;

import Exceptions.NotEnoughArguments;
import Exceptions.WrongArgument;
import Run.CollectionManager;

import javax.naming.NoPermissionException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExecuteScript implements Command{
    CollectionManager manager;
    HashMap<String, Command> commands;
    private static final ArrayList<Integer> recursionHistory = new ArrayList<>();

    public ExecuteScript(CollectionManager manager, HashMap<String, Command> commands) {
        this.commands = commands;
        this.manager = manager;
    }

    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public void execute(String[] args) throws WrongArgument, NotEnoughArguments {
        if(args.length < 2) throw new NotEnoughArguments("Command requires \"path\" argument");
        Path path;
        path = Paths.get(args[1]);
        recursionHistory.add(args[1].hashCode());

        try{
            // check file permissions
            if(!Files.exists(path)) throw new FileNotFoundException("File " + path + " not found");
            if(!Files.isReadable(path)) throw new NoPermissionException("Cannot read file.");
            if(!Files.isWritable(path)) throw new NoPermissionException("Cannot write to file.");
        }
        catch (FileNotFoundException e){
            System.out.println("File " + path + " not found.");
            return;
        }
        catch (NoPermissionException e){
            System.out.print("No enough permissions to " + path + " - " + e.getMessage()); // permissions deny
            return;
        }

        try(BufferedInputStream inputStream = new BufferedInputStream(Files.newInputStream(path));){
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println("Running " + path);
            run(reader);
            recursionHistory.clear();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private void run(BufferedReader reader) throws IOException {

        while (true) {
            String raw = reader.readLine();
            if (raw == null) return;
            String[] args = this.parseInput(raw);
            Command command = this.getCommand(args[0]);
            if (command == null){
                System.out.println(args[0] + " is not a command. Try again.");
                continue;
            }
            try {
                runCommand(command, args);
            }
            catch (WrongArgument e) {
                System.out.println("Error while running " + args[0] + " command.");
                System.out.println("Wrong argument! " + e.getMessage() + " Command skipped");
            } catch (NotEnoughArguments e) {
                System.out.println("Error while running " + args[0] + " command.");
                System.out.println("Not enough arguments. " + e.getMessage() + " Command skipped");
            }
        }
    }

    private void runCommand(Command command, String[] args) throws WrongArgument, NotEnoughArguments, NotEnoughArguments {
        if (command.getClass() == ExecuteScript.class) {
            if (ExecuteScript.recursionHistory.contains(args[1].hashCode())) {
                System.out.println("Recursion! Command skipped!");
                System.out.println(ExecuteScript.recursionHistory);
                return;
            }
            ExecuteScript.recursionHistory.add(args[0].hashCode());
        }
        command.execute(args);
    }

    @Override
    public String getDescription() {
        return "execute script in specified file";
    }
    private String[] parseInput(String line) {
        if(line.length() == 0) return new String[]{""};
        Matcher mather = Pattern.compile("[^\" ]+|\"[^\"]*\"").matcher(line);

        ArrayList<String> list = new ArrayList<>();
        while (mather.find()){
            list.add(mather.group().replaceAll("\"", ""));
        }
        String[] argsArray = new String[list.size()];
        argsArray = list.toArray(argsArray);
        argsArray[0] = argsArray[0].toLowerCase();
        return argsArray;
    }
    private Command getCommand(String command){
        if(!this.commands.containsKey(command)){
            return null;
        }
        return this.commands.get(command);
    }
}
