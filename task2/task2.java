import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class task2 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Нужно 2 файла");
            return;
        }

        try {
            File CentrRadius = new File(args[0]);
            // ("C:\Users\HONOR\IdeaProjects\task2\src\\CentrRadius.txt");

            File Tochka = new File(args[1]);
            //  "C:\Users\HONOR\IdeaProjects\task2\src\\Tochka.txt");

            BufferedReader reader1 = new BufferedReader(new FileReader(args[0]));
            String line1 = reader1.readLine();
            String line2 = reader1.readLine();
            reader1.close();

            String[] center = line1.split(" ");
            String[] radius = line2.split(" ");

            double cx = Double.parseDouble(center[0]);
            double cy = Double.parseDouble(center[1]);
            double rx = Double.parseDouble(radius[0]);
            double ry = Double.parseDouble(radius[1]);

            BufferedReader reader2 = new BufferedReader(new FileReader(args[1]));
            String line;

            while ((line = reader2.readLine()) != null) {
                String[] point = line.split(" ");
                double px = Double.parseDouble(point[0]);
                double py = Double.parseDouble(point[1]);

                double dx = (px - cx) / rx;
                double dy = (py - cy) / ry;
                double value = dx * dx + dy * dy;

                if (Math.abs(value - 1.0) < 0.0000000001) {
                    System.out.println(0);
                } else if (value < 1.0) {
                    System.out.println(1);
                } else {
                    System.out.println(2);
                }
            }
            reader2.close();

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}