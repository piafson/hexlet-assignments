package exercise;

public class App {
    public static void main(String... args) throws NegativeRadiusException {
        Point point = new Point(5, 7);
        Circle circle = new Circle(point, 4);
        App.printSquare(circle);

        Circle circle1 = new Circle(point, -2);
        App.printSquare(circle1);
    }

    public static void printSquare(Circle circle) {
        try {
            System.out.println(Math.round(circle.getSquare()));
        } catch (NegativeRadiusException e) {
            System.out.println("Не удалось посчитать площадь");
        } finally {
            System.out.println("Вычисление окончено");
        }
    }
}
