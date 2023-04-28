package Collections;

/**
 * Class for Space Marine Cordinates
 * @author Piven Danila @pivendanila.
 */
public class Coordinates {
    private float x; //Значение поля должно быть больше -374
    private Long y; //Поле не может быть null


    public Coordinates(String coordinates) {
        this.setX(coordinates.split(" ")[0]);
        this.setY(coordinates.split(" ")[1]);
    }
    /**
     * setter for x-coordinate
     */
    public void setX(String x) {
        this.x = Float.parseFloat(x);
    }

    /**
     * setter for y-coordinate
     */
    public void setY(String y) {
        this.y = Long.valueOf(y);
    }

    /**
     * getter for x-coordinate
     */
    public float getX() {
        return x;
    }

    /**
     * getter for y-coordinate
     */
    public Long getY() {
        return y;
    }
}