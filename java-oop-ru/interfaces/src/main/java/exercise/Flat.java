package exercise;

public class Flat implements Home {
    private double area;
    private double balconArea;
    private int floor;

    public Flat(double area, double balconArea, int floor) {
        this.area = area;
        this.balconArea = balconArea;
        this.floor = floor;
    }
    @Override
    public double getArea() {
        return area + balconArea;
    }

    @Override
    public int compareTo(Home another) {
        if (this.getArea()> another.getArea()) {
            return 1;
        } else if (this.getArea() < another.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getBalconArea() {
        return balconArea;
    }

    public void setBalconArea(double balconArea) {
        this.balconArea = balconArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return ("Квартира площадью " + this.getArea() + " метров на " + this.floor
        + " этаже");
    }
}
