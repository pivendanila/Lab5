package Collections;


public class SpaceMarine {
    private Integer index = 0;
    private Integer id;
    private String name;
    private Coordinates coordinates;
    private java.time.ZonedDateTime creationDate;
    private Float health;
    private boolean loyal;
    private String achievements;
    private AstartesCategory category;
    private Chapter chapter;

    /**
     * Class for Space Marine.
     * @author Piven Danila @pivendanila.
     */
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


