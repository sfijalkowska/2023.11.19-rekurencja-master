package pl.comarch.camp.it.rekurencja;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Silnia {
    public static void main(String[] args) {
        System.out.println(silnia(-1));
        System.out.println(arithmeticNElement(5, 7, 15));
        System.out.println(fibonacciNElement(10));
        System.out.println(power(2, 10));

        HashMap<Integer, Integer> map = new HashMap<>();
        dicesRoll(map, 5600);
        System.out.println(map);
    }

    public static int silnia(int x) {
        if(x <= 0) {
            return 1;
        }
        return x * silnia(x-1);
    }

    public static int arithmeticNElement(int n, int first, int step) {
        if(n == 0) {
            return first;
        }
        return step + arithmeticNElement(n-1, first, step);
    }

    public static int fibonacciNElement(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return fibonacciNElement(n-1) + fibonacciNElement(n-2);
    }

    public static int power(int x, int y) {
        if(y == 0) {
            return 1;
        }
        return x * power(x, y-1);
    }

    public static void dicesRoll(HashMap<Integer, Integer> map, int n) {
        if(n == 0) {
            return;
        }
        Random random = new Random();
        int twoDiceSum = random.nextInt(1, 7) + random.nextInt(1, 7);
        if(map.get(twoDiceSum) == null) {
            map.put(twoDiceSum, 1);
        } else {
            map.put(twoDiceSum, map.get(twoDiceSum)+1);
        }
        dicesRoll(map, n-1);
    }
}
