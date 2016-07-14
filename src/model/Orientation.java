package model;

import com.sun.javaws.exceptions.InvalidArgumentException;

public enum Orientation {
    N, E, W, S;

    public static Orientation getOrientation(String s) throws InvalidArgumentException {
        switch (s) {
            case "N":
                return Orientation.N;
            case "E":
                return Orientation.E;
            case "W":
                return Orientation.W;
            case "S":
                return Orientation.S;
            default:
                throw new InvalidArgumentException(new String[]{"Orientation values can only be one among \"N\", \"E\", \"W\", \"S\""});
        }
    }
}
