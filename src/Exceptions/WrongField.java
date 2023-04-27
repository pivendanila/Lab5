package Exceptions;

/**
 * Class for exception to situation of wrong field.
 * @author Piven Danila @pivendanila.
 */

public class WrongField extends Error {
    public WrongField(String message) {
        super(message);
    }
}