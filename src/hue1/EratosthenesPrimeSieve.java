package hue1;

import java.util.ArrayList;
import java.util.Scanner;

public class EratosthenesPrimeSieve implements PrimeSieve {

    private int maxHoehe;
    private boolean[] array;

    public EratosthenesPrimeSieve(int maxHoehe) {
        this.maxHoehe = maxHoehe;
        array = new boolean[maxHoehe];
        for (int i = 0; i < array.length; i++) {
            array[i] = true;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Geben sie die maximale Höhe ein:");
        int hoehe = Integer.parseInt(sc.nextLine());
        EratosthenesPrimeSieve erat = new EratosthenesPrimeSieve(hoehe);

        //Prinzip
        erat.array[0] = false;
        erat.array[1] = false;
        erat.array[2] = true;
        for (int i = 2; i < erat.array.length; i++) {
            for (int j = 2; j < erat.array.length && erat.array[i] == true && i * j < erat.array.length; j++) {
                erat.array[i * j] = false;
            }
        }

        erat.printPrimes();

        System.out.println("");

        erat.findeSummen(erat.array);
    }

    @Override
    public boolean isPrime(int p) {
        if (array[p] == true) {
            return true;
        }
        return false;

    }

    @Override
    public void printPrimes() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == true) {
                System.out.print(i + ",");
            }
        }
    }

    public void findeSummen(boolean[] primesBoolean) {
        ArrayList<Integer> primes = new ArrayList<>();
        ArrayList<String> erg = new ArrayList<>();

        //Primzahlen
        for (int i = 0; i < primesBoolean.length; i++) {
            if (primesBoolean[i] == true) {
                primes.add(i);
            }
        }

        //Algo
        boolean b = true;
        for (int i = 2; i < primesBoolean.length; i += 2) {
            b = true;
            for (int j = 0; j < primes.size() && b == true; j++) {

                for (int k = 0; k < primes.size() && b == true; k++) {
                    if (i == primes.get(j) + primes.get(k)) {
                        b = false;
                        int ergebnis = primes.get(j) + primes.get(k);
                        erg.add(ergebnis + " summe: " + ergebnis + " = " + primes.get(j) + " + " + primes.get(k));
                    }
                }
            }
        }
        for (int i = 0; i < erg.size(); i++) {
            System.out.println(erg.get(i));

        }
    }
}
