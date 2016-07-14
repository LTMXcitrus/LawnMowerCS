package model;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void incY(int i) {
        this.setY(this.getY() + i);
    }

    public void incX(int i) {
        this.setX(this.getX() + i);
    }

    @Override
    public String toString() {
        return getX() + " " + getY();
    }
}
