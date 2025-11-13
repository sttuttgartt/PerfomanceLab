import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;


public class task4 {

    public static void main(String[] args) throws IOException {

      File file = new File(args[0]);
       // File file = new File("C:\\Users\\HONOR\\IdeaProjects\\task4\\src\\file.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String Line;
        String nullLine = "";

        while ((Line = br.readLine()) != null) {
            nullLine = nullLine + Line + " ";
        }

        String[] nullLineSpl = nullLine.split(" ");

        int[] nums = new int[nullLineSpl.length];

        for (int i = 0; i < nullLineSpl.length; i++)
        {nums[i] = Integer.parseInt(nullLineSpl[i]);}

        Arrays.sort(nums);

        int median = nums[nums.length / 2];

        int moves = 0;
        for (int number : nums) {
            moves += Math.abs(number - median);}
        if (moves <= 20) {
            System.out.println("Минимальное количество ходов: " + moves);
        } else {
            System.out.println("20 ходов недостаточно для приведения всех элементов массива к одному числу");
        }

        br.close();
    }
}