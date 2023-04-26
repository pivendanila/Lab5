package Collection;

public class Chapter {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String parentLegion;

    public Chapter(String chapter){
        this.setName(chapter.split(" ")[0]);
        this.setParentLegion(chapter.split(" ")[1]);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParentLegion(String parentLegion) {
        this.parentLegion = parentLegion;
    }

    public String getName() {
        return name;
    }

    public String getParentLegion() {
        return parentLegion;
    }
}