package Run;

import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import Collections.AstartesCategory;
import Collections.Chapter;
import Collections.Coordinates;
import Collections.SpaceMarine;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.nio.file.Path;
import java.util.LinkedList;

/**
 * Class of Manager working with collection of Space Marines.
 * * @author Piven Danila @pivendanila.
*/
public class CollectionManager {
    private final Path path;
    final LinkedList<SpaceMarine> spacemarines;
    final private String type;
    final private java.time.ZonedDateTime date;
    private int number_of_marines = -1;
    private String history = "";


    public CollectionManager(Path filepath) {
        this.path = filepath;
        this.spacemarines = new LinkedList<>();
        this.type = String.valueOf(spacemarines.getClass());
        this.date = java.time.ZonedDateTime.now();
    }
    /**
     * Method of updating History of commands.
     */
    public void updateHistory(String name){
        this.history += name+" ";
    }
    /**
     * Method of updating indexes of Space Marines in collection.
     */
    public void update(){
        number_of_marines=-1;
        for(int i = 0; i < this.spacemarines.size(); i++){
            this.spacemarines.get(i).setIndex(i);
            number_of_marines++;
        }
    }
    /**
     * getter for History
     */
    public String getHistory() {
        return history;
    }
    /**
     * Method for forming information about info.
     */
    public String info() {
        String result = "";
        result += "Type: " + this.type + "\n" + "Init. Date: " + this.date.getDayOfMonth() + "." + this.date.getMonth()
                + "." + this.date.getYear() + " " + this.date.getHour() + ":" + this.date.getMinute() +
                "\nSpacemarines: " + this.spacemarines.size();
        return result;
    }
    /**
     * Method of adding new element to the collection.
     */
    public void add(SpaceMarine spacemarine) {
        this.number_of_marines++;
        spacemarine.setIndex(number_of_marines);
        spacemarine.setId(idGenerator());
        spacemarines.add(spacemarine);
    }

    /**
     * Method of clearing the collection.
     */
    public void clear() {
        spacemarines.clear();
    }

    /**
     * Method of getting element from collection by ID.
     */
    public int getById(int Id) {
        for (SpaceMarine marine : spacemarines) {
            if (marine.getId() == Id) {
                return marine.getIndex();
            }
        }
        return 0;
    }

    /**
     * Method of removing element by Index.
     */
    public void remove_at_index(int index) {
        spacemarines.remove(index);
        update();
    }

    /**
     * Method of removing.
     */
    public void remove_at_id(int id) {
        for (int index = 0; index < spacemarines.size(); index++) {
            if (spacemarines.get(index).getId() == id) {
                this.remove_at_index(index);
            }
        }
    }

    /**
     * Method of inserting element by index to the collection.
     */
    public void insert_at_index(int index, SpaceMarine marine) {
        spacemarines.add(index, marine);
        update();
    }

    /**
     * getter for collection of Space Marines.
     */
    public LinkedList<SpaceMarine> getSpacemarines() {
        return spacemarines;
    }

    /**
     * Method of updating element by ID.
     */
    public void update_id(int id, SpaceMarine spacemarine) {
        this.remove_at_id(id);
    }

    /**
     * Method of displaying content of the collection.
     */
    public String show() {
        String result = "";
        int i = 0;
        if (spacemarines.size() == 0) {
            return "Collection is empty";
        } else {
            for (SpaceMarine spacemarine : this.spacemarines) {
                ++i;
                result += "Space Marine ID: " + spacemarine.getId() + "\nSpace Marine #" + spacemarine.getIndex() + "\nName: " + spacemarine.getName() + "\n" + "Coordinates: " + spacemarine.getCoordinates() + "\n"
                        + "Health: " + spacemarine.getHealth() + "\n" + "Loyal: " + spacemarine.getLoyal() + "\n"
                        + "Achievements: " + spacemarine.getAchievements() + "\n" + "Category: " + spacemarine.getCategory()
                        + "\n" + "Chapter: " + spacemarine.getChapter() + "\n" + "CreationDate " + spacemarine.getCreationDate() + "\n";
                if (i != this.spacemarines.size()) result += "\n";

            }
            return result;
        }
    }
    /**
     * Generator of enough random IDs
     */
    public int idGenerator(){
        String letters = "12345";
        char[] chars = letters.toCharArray();
        int cnt = letters.length();
        int nano = java.time.ZonedDateTime.now().getNano();
        String result = "";
        char[] val = new char[5];
        String.valueOf(nano).getChars(0, 5, val, 0);
        for(int i = 0; i < 5; i++){
            result += String.valueOf(Integer.parseInt(String.valueOf(val[i]))*Integer.parseInt(String.valueOf(chars[i])));
        }
        return Integer.parseInt(result);
    }

    /**
     * Method of displaying content of certain collection
     */
    public String show(LinkedList<SpaceMarine> marines) {
        String result = "";
        if (marines.size() == 0) {
            return "Collection is empty";
        } else {
            for(int i = marines.size()-1; i >= 0; i--) {
                result += "Space Marine ID: " + marines.get(i).getId() + "\nSpace Marine #" + marines.get(i).getIndex() + "\nName: " + marines.get(i).getName() + "\n"
                        + "Coordinates: " + marines.get(i).getCoordinates() + "\n"
                        + "Health: " + marines.get(i).getHealth() + "\n" + "Loyal: " + marines.get(i).getLoyal() + "\n"
                        + "Achievements: " + marines.get(i).getAchievements() + "\n" + "Category: "
                        + marines.get(i).getCategory()
                        + "\n" + "Chapter: " + marines.get(i).getChapter() + "\n" + "CreationDate "
                        + marines.get(i).getCreationDate() + "\n";
                if (i != 0) result += "\n";

            }
            return result;
        }
    }

    /**
     * Method of filling collection from .xml file
     */
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
                    for (int j = 0; j < bookProps.getLength(); j++) {
                        Node bookProp = bookProps.item(j);
                        if (bookProp.getNodeType() != Node.TEXT_NODE) {
                            if (i % 2 != 0 && j % 2 != 0) {
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
                                        spacemarine.setChapter(bookProp.getChildNodes().item(0).getTextContent());
                                        break;
                                }
                            }
                        }
                    }
                }
                if (i > 0 && i % 2 != 0) {
                    number_of_marines++;
                    spacemarine.setIndex(number_of_marines);
                    spacemarine.setId(idGenerator());
                    spacemarines.add(spacemarine);
                }

            }

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    /**
     * Method of saving collection to the .xml file
     */
    public void save() throws IOException {
        FileWriter fw = new FileWriter( "saved.xml");
        fw.write("<?xml version=\"1.0\"?>\n");
        fw.write("<SpaceMarines>\n");
        for(SpaceMarine marine : spacemarines) {
            fw.write("\t<SpaceMarine>\n");
            fw.write("\t\t<name>"+marine.getName()+"</name>\n");
            fw.write("\t\t<coordinates>"+marine.getCoordinates()+"</coordinates>\n");
            fw.write("\t\t<health>"+marine.getHealth()+"</health>\n");
            fw.write("\t\t<loyal>"+marine.getLoyal()+"</loyal>\n");
            fw.write("\t\t<achievements>" + marine.getAchievements()+ "</achievements>\n");
            fw.write("\t\t<category>"+marine.getCategory()+"</category>\n");
            fw.write("\t\t<chapter>"+marine.getChapter()+"</chapter>\n");
            fw.write("\t</SpaceMarine>\n");
        }
        fw.write("</SpaceMarines>");

        fw.close();

    }

}
