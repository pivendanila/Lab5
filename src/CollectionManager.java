import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import Collection.SpaceMarine;
import java.nio.file.Path;
import java.util.LinkedList;

public class CollectionManager {
    private final Path path;
    private final LinkedList<SpaceMarine> spacemarines;


    public CollectionManager(Path filepath) {
        path = filepath;
        spacemarines = new LinkedList<>();
    }

    public void add(SpaceMarine spacemarine){
        spacemarines.add(spacemarine);
    }

    public void clear(){
        spacemarines.clear();
    }

    public void remove_at_index(int index) {
        spacemarines.remove(index);
    }

    public void remove_by_id(int id){
        for(int index = 0; index < spacemarines.size(); index++){
            if(spacemarines.get(index).get_id() == id){
                this.remove_at_index(index);
            }
        }
    }
}
