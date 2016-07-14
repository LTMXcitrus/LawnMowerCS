package model;

import com.sun.javaws.exceptions.InvalidArgumentException;

public class LawnMower {
    private Position position;
    private Orientation orientation;
    private Grid grid;

    public LawnMower(Position position, Orientation orientation, Grid grid) throws InvalidArgumentException {
        if (position.getX() > grid.getLength()
                || position.getY() > grid.getWidth()
                || position.getX() < 0
                || position.getY() < 0) {
            throw new InvalidArgumentException(new String[]{"the mower must not be outside the grid"});
        }
        this.position = position;
        this.orientation = orientation;
        this.grid = grid;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Position getPosition() {
        return position;
    }

    public Grid getGrid() {
        return grid;
    }

    @Override
    public String toString() {
        return getPosition() + " " + getOrientation();
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void move(Instruction instruction) {
        switch (instruction) {
            case D:
                turnRight();
                break;
            case G:
                turnLeft();
                break;
            case A:
                forward();
                break;

        }
    }

    private void forward() {
        switch (getOrientation()) {
            case N:
                this.moveY(1);
                break;
            case E:
                this.moveX(1);
                break;
            case W:
                this.moveX(-1);
                break;
            case S:
                this.moveY(-1);
                break;
        }
    }

    private void moveY(int i) {
        int y = getPosition().getY();
        if (y + i <= getGrid().getWidth() && y + i >= 0) {
            getPosition().incY(i);
        }
    }

    private void moveX(int i) {
        int x = getPosition().getX();
        if (x + i <= getGrid().getLength() && x + i >= 0) {
            getPosition().incX(i);
        }
    }

    public void turnRight() {
        switch (this.getOrientation()) {
            case N:
                this.setOrientation(Orientation.E);
                break;
            case E:
                this.setOrientation(Orientation.S);
                break;
            case W:
                this.setOrientation(Orientation.N);
                break;
            case S:
                this.setOrientation(Orientation.W);
                break;
        }
    }

    public void turnLeft() {
        switch (this.getOrientation()) {
            case N:
                this.setOrientation(Orientation.W);
                break;
            case E:
                this.setOrientation(Orientation.N);
                break;
            case W:
                this.setOrientation(Orientation.S);
                break;
            case S:
                this.setOrientation(Orientation.E);
                break;
        }
    }
}
