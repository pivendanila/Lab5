package Collection;

import Collection.AstartesCategory;
import Collection.Chapter;
import Collection.Coordinates;

import java.lang.reflect.Array;
import java.time.ZonedDateTime;

public class SpaceMarine {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float health; //Поле не может быть null, Значение поля должно быть больше 0
    private boolean loyal;
    private String achievements; //Поле может быть null
    private AstartesCategory category; //Поле не может быть null
    private Chapter chapter; //Поле может быть null

    public void SpaceMarine(){
        this.setCreationDate();
    }
    public int get_id(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setCoordinates(String coordinates){
        this.coordinates = new Coordinates(coordinates);
    }
    public void setHealth(Float health){
        this.health = health;
    }
    public void setLoyal(boolean loyal){
        this.loyal = loyal;
    }
    public void setAchievements(String achievements){
        this.achievements = achievements;
    }
    public void setCategory(AstartesCategory category){
        this.category = category;
    }
    public void setChapter(String name, String legion){
        this.chapter.setName(name);
        this.chapter.setParentLegion(legion);
    }
    public void setCreationDate(){
        this.creationDate = java.time.ZonedDateTime.now();
    }

    public String getName() {
        return this.name;
    }
    public AstartesCategory getCategory() {
        return this.category;
    }
    public Chapter getChapter() {
        return this.chapter;
    }
    public Coordinates getCoordinates() {
        return this.coordinates;
    }
    public Float getHealth() {
        return this.health;
    }
    public Integer getId() {
        return this.id;
    }
    public String getAchievements() {
        return this.achievements;
    }
    public ZonedDateTime getCreationDate() {
        return this.creationDate;
    }
    public boolean getLoyal(){
        return this.loyal;
    }
}


