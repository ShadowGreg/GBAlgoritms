/*
 Дано целое число N из отрезка[1;1000].Также даны N целых чисел Ai из отрезка[1;1000000].Требуется для каждого числа Ai
 вывести количество различных делителей этого числа.В этой задаче несколько верных решений,попробуйте найти наиболее
 оптимальное.Для полученного решения укажите сложность в О-нотации.
  */


import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Введите целое число ои зотрезка [1;1000] >");
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        int n = scanner.nextInt(); //[1;1000]
        for (int i = 0; i < n; i++) {
            int ai = rnd.nextInt(1000000);
            int count = 0;
            for (int j = 1; j <= (int) Math.sqrt(ai) + 1; j++) {
                if (ai % j == 0) {
                    count += 2;
                }
            }
            if (Math.sqrt(ai) == (int) Math.sqrt(ai)) {
                count--;
            }
            System.out.printf("%d количество делителй -> %d %n", ai, count);
        }
    }
}
