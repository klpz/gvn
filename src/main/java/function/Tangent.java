package function;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.*;

public class Tangent {

    private static Map<Long, Double> bernulli = new HashMap<>();

    private static double bink(long n, long k){
        return 1.0d * factorial(n) / factorial(k) / factorial(n - k);
    }
    private static long factorial (long k){
        long result = 1;
        for (int factor = 2; factor <= k; factor++) {
            result *= factor;
        }
        return result;
    }

    private static double bernulli(long n) {
        if(bernulli.get(n) != null){
            return bernulli.get(n);
        }
        if (n <= 0){
            return 1;
        }
        if(n % 2 == 1 && n != 1){
            return 0;
        }
        double sum = 0;
        for(long k = 1; k <= n; k++){
            sum += bink(n + 1,k + 1) * bernulli(n - k);
        }
        bernulli.put(n, (-1.0d) / (n + 1) * sum);
        return  (-1.0d) / (n + 1) * sum;
    }

    private static double taylorTgNext(double x, long n){
        return bernulli(2 * n) * pow(-4.0d, n) * (1- pow(4, n)) * pow(x, 2 * n - 1) / factorial(2 * n);
    }

    public static double tg(double x, double delta){
        double prev;
        double sum = 0.0d;
        int n = 1;
        if(abs(x) > PI / 2.0d) {
            x = x - PI * (round(x / PI));
        }

        if(abs(x) > PI / 2 - delta && abs(x) < PI / 2 + delta){
            return Double.NaN;
        }
        do{
            prev = sum;
            sum += taylorTgNext(x, n++);
        } while (abs(sum - prev) >= delta && (n < 100));
        return sum;
    }
}
