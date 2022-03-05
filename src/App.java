import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedList<String> nameList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        Menu menu = new Menu(nameList, scanner);
        menu.run();
    }
}
