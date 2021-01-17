import java.util.*;

public class Dav {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int d;
        System.out.print("Enter d : ");
        d = scan.nextInt();
        while (d <= 0) {
            System.out.println("Please enter positive number");
            System.out.print("Enter d : ");
            d = scan.nextInt();
        }
        String result = "0";
        result = davison(result, d);
        System.out.println(result);
    }

    public static String davison(String result, int d) {
        if (d == 0)
            return result;
        else {
            System.out.println(result);
            int len = result.length();
            char input[] = result.toCharArray();
            for (int i = 0; i < len; i++) {
                if (input[i] == '1')
                    input[i] = '0';
                else
                    input[i] = '1';
            }
            String answer = String.valueOf(input);
            result = result.concat(answer);
            return davison(result, d - 1);
        }
    }
}
