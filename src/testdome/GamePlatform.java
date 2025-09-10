package testdome;

public class GamePlatform {
    public static double calculateFinalSpeed(double initialSpeed, int[] inclinations) {
        double answer = initialSpeed;
        for (int inc : inclinations) {
            if (inc > 0) {
                answer -= inc;
            } else {
                answer += Math.abs(inc);
            }
        }
        return Math.max(answer, 0);
    }

    public static void main(String[] args) {
        System.out.println(calculateFinalSpeed(60.0, new int[]{0, 30, 0, -45, 0}));
    }
}
