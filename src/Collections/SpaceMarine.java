package Collections;

import java.time.ZonedDateTime;

public class SpaceMarine {
    private Integer index = 0;
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Float health; //Поле не может быть null, Значение поля должно быть больше 0
    private boolean loyal;
    private String achievements; //Поле может быть null
    private AstartesCategory category; //Поле не может быть null
    private Chapter chapter; //Поле может быть null

    public SpaceMarine() {
        this.setCreationDate();
    }


    public void setIndex(Integer index) {
        this.index = index;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = new Coordinates(coordinates);
    }

    public void setHealth(Float health) {
        this.health = health;
    }

    public void setLoyal(boolean loyal) {
        this.loyal = loyal;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public void setCategory(AstartesCategory category) {
        this.category = category;
    }

    public void setChapter(String chapter) {
        this.chapter = new Chapter(chapter);
    }

    public void setCreationDate() {
        this.creationDate = java.time.ZonedDateTime.now();
    }

    public String getName() {
        return this.name;
    }

    public AstartesCategory getCategory() {
        return this.category;
    }

    public String getChapter() {
        return this.chapter.getName() + " " + this.chapter.getParentLegion();
    }

    public String getCoordinates() {
        return this.coordinates.getX() + " " + this.coordinates.getY();
    }

    public Float getHealth() {
        return this.health;
    }

    public String getAchievements() {
        return this.achievements;
    }

    public String getCreationDate() {
        return this.creationDate.getDayOfMonth() + "." + this.creationDate.getMonth() + "." + this.creationDate.getYear()
                + " " + this.creationDate.getHour() + ":" + this.creationDate.getMinute();
    }

    public boolean getLoyal() {
        return this.loyal;
    }

    public Integer getIndex() {
        return this.index;
    }

    public Integer getId() {
        return this.id;
    }
}

