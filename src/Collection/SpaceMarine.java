package Collection;

import Collection.AstartesCategory;
import Collection.Chapter;
import Collection.Coordinates;

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

    public int get_id(){
        return id;
    }
}


