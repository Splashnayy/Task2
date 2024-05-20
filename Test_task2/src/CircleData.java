import java.util.ArrayList;
import java.util.List;

public class CircleData {
    private double centerX;
    private double centerY;
    private double diameter;
    private double resolution;

    public CircleData(double centerX, double centerY, double diameter, double resolution) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.diameter = diameter;
        this.resolution = resolution;
    }

    public List<Point> getPoints() {
        List<Point> points = new ArrayList<>();
        double radius = diameter / 2;

        // Преобразуем миллиметры в пиксели
        double pixelRadius = radius * resolution / 25.4;

        // Цикл по углам от 0 до 360 градусов с шагом 1 градус
        for (int angle = 0; angle < 360; angle++) {
            // Вычисляем координаты точки на окружности
            double x = centerX + pixelRadius * Math.cos(Math.toRadians(angle));
            double y = centerY + pixelRadius * Math.sin(Math.toRadians(angle));

            // Добавляем точку в список
            points.add(new Point(x, y));
        }

        return points;
    }

    // Вспомогательный класс для представления точки
    public static class Point {
        public double x;
        public double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}