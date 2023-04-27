package Collections;

import Exceptions.WrongField;

public class Coordinates {
    private float x; //Значение поля должно быть больше -374
    private Long y; //Поле не может быть null

    public Coordinates(String coordinates) {
        this.setX(coordinates.split(" ")[0]);
        this.setY(coordinates.split(" ")[1]);

    }
    public void setX(String x) {
        this.x = Float.parseFloat(x);
    }
    public void setY(String y) {
        this.y = Long.valueOf(y);
    }
    public float getX() {
        return x;
    }
    public Long getY() {
        return y;
    }
}