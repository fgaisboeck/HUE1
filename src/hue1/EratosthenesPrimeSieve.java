package hue1;

import java.util.Scanner;

public class EratosthenesPrimeSieve implements PrimeSieve {

    private int maxHoehe;
    private boolean[] array;

    public EratosthenesPrimeSieve(int maxHoehe) {
        this.maxHoehe = maxHoehe;
        array = new boolean[maxHoehe];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Geben sie die maximale Höhe ein:");
        int hoehe = Integer.parseInt(sc.nextLine());
        EratosthenesPrimeSieve erat = new EratosthenesPrimeSieve(hoehe);

        for (int i = 2; i < erat.array.length; i++) {
            if (erat.isPrime(i) == true) {
                erat.array[i] = true;
                for (int j = 0; j < erat.array.length; j++) {
                    if (i * j < erat.maxHoehe) {
                        int x = i * j;
                        erat.array[x] = false;
                    }

                }
            }
        }
        for (int i = 0; i < erat.array.length; i++) {
            if (erat.array[i] == true) {
                System.out.println(i);
            }

        }
        erat.printPrimes();
    }

    @Override
    public boolean isPrime(int p) {
        boolean b = true;
        for (int i = 2; i < p; i++) {
            if (p % i == 0) {
                b = false;
                break;
            }
        }
        return b;
    }

    @Override
    public void printPrimes() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == true) {
                System.out.print(i + " ");
            }
        }
    }
}
