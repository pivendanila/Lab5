package Collection;

public class Chapter {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String parentLegion;

    public void setName(String name) {
        this.name = name;
    }

    public void setParentLegion(String parentLegion) {
        this.parentLegion = parentLegion;
    }
}