public class task1
{
    public static void main(String[] args) {

        if (args.length != 2)
            System.out.println("Ошибка, введите два аргумента");

        else {
            int nn = Integer.parseInt(args [0]);
            int mm = Integer.parseInt(args [1]);
            int current = 1;
            System.out.print("Полученный путь: ");

            do {
                System.out.print(current);
                current = (current + mm - 2) % nn + 1;
            } while (current != 1); }

    }
}