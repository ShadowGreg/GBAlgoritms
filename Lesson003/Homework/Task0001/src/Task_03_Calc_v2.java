import java.util.Scanner;
import java.util.logging.*;
import java.io.FileWriter;
import java.io.IOException;

public class Task_03_Calc_v2 {
    
    private static final Logger LOG = Logger.getLogger(Logger.class.getName());
  
    public static void main(String[] args) throws IOException {
        // Реализовать простой калькулятор (пользователь вводит 2 числа и
        // вводит операцию (+ - / *). int a ; int b; String op (op!=”Stop”); (char !=
        // ’b’)
        // добавить логгер

        Scanner sc = new Scanner(System.in);
        FileHandler fh = new FileHandler("calclog.log", true);
        LOG.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        LOG.setUseParentHandlers(false);
        LOG.setLevel(Level.ALL);
        LOG.log(Level.INFO, "Message");

        Character breaker = chrInput("Input any key to continue or q for quit ", sc);
        result(breaker, sc);

    }

    
    
    public static void result(Character breaker, Scanner sc) {

        while (breaker != 'q') {
            Double x = numberInput("Input number 1: ", sc);
            Double y = numberInput("Input number 2: ", sc);
            Double res = 0.0;
            Character op = operCheck(sc);
            res = calc(x, y, op);
            String resStr = "";
            resStr = resStr + x + op + y + "=" + res;
            strWriter(resStr);
            System.out.printf("%s %s %s = %s \n", x, op, y, res);
            breaker = chrInput("Input any key to continue or q for quit ", sc);
        }
    }
    public static void strWriter(String str) {

        // Charset append;
        try (FileWriter fw = new FileWriter("calclog.txt", true);) {//если фалсе - то перезапишет, если тру - добавит
            fw.write(str);
            fw.append('\n'); // записывает только чар
            // fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            LOG.log(Level.INFO, "My exeption: {}", ex.getMessage());
        }
    }

    public static Character operCheck(Scanner sc) {
        Character op = chrInput("Input operation: ", sc);
        boolean flag = op.equals('+') || op.equals('-') || op.equals('*') || op.equals('/');
        while (!flag) {
            op = chrInput("Wrong operation character. Input operation: ", sc);
            // System.out.printf("Current op %s \n", op);
            switch (op) {
                case '+', '-', '*', '/' -> flag = true;
            }
        }
        return op;
    }

    public static Double numberInput(String message, Scanner sc) {
        boolean flag = false;
        double result = 0.0;
        while (!flag) {
            System.out.print(message);
            String temp = sc.next();
            try {
                result = Double.parseDouble(temp);
                flag = true;

            } catch (NumberFormatException ex) {
                System.out.println("Wrong input, try again!");
            }
        }
        return result;
    }

    public static Character chrInput(String message, Scanner sc) {
        System.out.print(message);
        Character chr = sc.next().charAt(0);
        return chr;
    }

    public static double calc(double x, double y, Character chr) {

        double res = 0.0;
        switch (chr) {
            case '+' -> res = x + y;
            case '-' -> res = x - y;
            case '*' -> res = x * y;
            case '/' -> res = x / y;
        }
        return res;
    }
}
