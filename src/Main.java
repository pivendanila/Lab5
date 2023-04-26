import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        CollectionManager manager = new CollectionManager(Path.of("C:/Users/piven/Desktop/ITMO/Прога/Java/Lab5/1.xml"));
        manager.fill_from_file();
        //System.out.println(manager.spacemarines);
        System.out.println(manager.show());
    }
}
