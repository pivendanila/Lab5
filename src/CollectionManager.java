import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import Collection.AstartesCategory;
import Collection.Chapter;
import Collection.Coordinates;
import Collection.SpaceMarine;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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

    public void remove_at_id(int id){
        for(int index = 0; index < spacemarines.size(); index++){
            if(spacemarines.get(index).get_id() == id){
                this.remove_at_index(index);
            }
        }
    }

    public void insert_at_index(int index, SpaceMarine spacemarine){
        spacemarines.add(index, spacemarine);
    }

    public void update_id(int id, SpaceMarine spacemarine){
        this.remove_at_id(id);
    }

    public String show(){
        String result = "";
        for (SpaceMarine spacemarine : spacemarines) {
            System.out.println(spacemarine.getName());
            System.out.println(spacemarine.getAchievements());
            System.out.println(spacemarine.getCategory());
            System.out.println(spacemarine.getHealth());
            System.out.println(spacemarine.getChapter());
            System.out.println(spacemarine.getCreationDate());
            System.out.println(spacemarine.getLoyal());
            System.out.println(spacemarine.getCoordinates());
        }
        return result.toString();
    }

    public void fill_from_file() {
        try {
            int cnt = 0;
            String name = "";
            Coordinates coordinates;
            java.time.ZonedDateTime creationDate;
            Float health;
            boolean loyal;
            String achievements;
            AstartesCategory category;
            Chapter chapter;

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(String.valueOf(path.toUri()));
            Node root = document.getDocumentElement();
            NodeList books = root.getChildNodes();
            for (int i = 0; i < books.getLength(); i++) {
                Node book = books.item(i);
                SpaceMarine spacemarine = new SpaceMarine();
                if (book.getNodeType() != Node.TEXT_NODE) {
                    NodeList bookProps = book.getChildNodes();
                    for(int j = 0; j < bookProps.getLength(); j++) {
                        Node bookProp = bookProps.item(j);
                        if (bookProp.getNodeType() != Node.TEXT_NODE) {
                            if (i % 2 != 0 && j % 2 != 0) {
                                System.out.println(bookProp.getChildNodes().item(0).getTextContent());
                                switch (bookProp.getNodeName()) {
                                    case "name":
                                        spacemarine.setName(bookProp.getChildNodes().item(0).getTextContent());
                                        break;
                                    case "coordinates":
                                        spacemarine.setCoordinates(bookProp.getChildNodes().item(0).getTextContent());
                                        break;
                                    case "health":
                                        spacemarine.setHealth(Float.parseFloat(bookProp.getChildNodes().item(0).getTextContent()));
                                        break;
                                    case "loyal":
                                        spacemarine.setLoyal(Boolean.parseBoolean(bookProp.getChildNodes().item(0).getTextContent()));
                                        break;
                                    case "achievements":
                                        spacemarine.setAchievements(bookProp.getChildNodes().item(0).getTextContent());
                                        break;
                                    case "category":
                                        spacemarine.setCategory(AstartesCategory.valueOf(bookProp.getChildNodes().item(0).getTextContent()));
                                        break;
                                    case "chapter":
                                        spacemarine.setName(bookProp.getChildNodes().item(0).getTextContent());
                                        break;
                                }
                            }
                        }
                    }
                }
                if(i % 2 != 0) {
                    cnt++;
                    spacemarines.add(spacemarine);
                    System.out.println("End of "+cnt);
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
