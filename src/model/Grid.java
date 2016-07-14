package model;

import com.sun.javaws.exceptions.InvalidArgumentException;

public class Grid {
    private int length;
    private int width;

    public Grid(int length, int width) throws InvalidArgumentException {
        if (length < 0 || width < 0) {
            throw new InvalidArgumentException(new String[]{"A grid length or width must be > 0"});
        }
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
}
