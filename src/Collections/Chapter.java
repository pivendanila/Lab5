package Collections;

/**
 * Class for Space Marine Chapter.
 * @author Piven Danila @pivendanila.
 */
public class Chapter {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String parentLegion;

    public Chapter(String chapter){
        this.setName(chapter.split(" ")[0]);
        this.setParentLegion(chapter.split(" ")[1]);
    }
    /**
     *setter for name of Chapter.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *setter for ParentRegion of Chapter
     */
    public void setParentLegion(String parentLegion) {
        this.parentLegion = parentLegion;
    }
    /**
     * getter for name of Chapter
     */
    public String getName() {
        return name;
    }

    /**
     * getter for ParentLegion of Chapter
     */
    public String getParentLegion() {
        return parentLegion;
    }
}