import Run.CollectionManager;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        CollectionManager manager = new CollectionManager(Path.of("C:/Users/piven/Desktop/ITMO/Prog/Java/Lab5/1.xml"));
        manager.fill_from_file();
        manager.save();
    }
}
