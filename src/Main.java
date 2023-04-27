import Run.CollectionManager;
import Run.Executor;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        CollectionManager manager = new CollectionManager(Path.of("C:/Users/piven/Desktop/ITMO/Прога/Java/Lab5/1.xml"));
        manager.fill_from_file();
        Executor exec = new Executor(manager);
        exec.interactiveMod();
    }
}
