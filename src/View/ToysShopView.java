package View;

import java.util.Scanner;

public class ToysShopView {

    public void showMessage(String prompt){
        System.out.println(prompt);
    }

    public String inputData(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        String result = in.nextLine();
     //   in.close();
        return result;
    }
}
