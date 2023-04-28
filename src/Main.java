import Run.CollectionManager;
import Run.Executor;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        CollectionManager manager = new CollectionManager();
        manager.fill_from_file(Path.of(args[0]));
        Executor exec = new Executor(manager);
        exec.interactiveMod();
    }
}
