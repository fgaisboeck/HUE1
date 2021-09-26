package hue1;

import java.util.ArrayList;
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

        //Prinzip
        for (int i = 2; i < erat.array.length; i++) {
            if (erat.isPrime(i) == true) {
                erat.array[i] = true;
                for (int j = 2; j < erat.array.length; j++) {
                    if (i * j < erat.maxHoehe) {
                        erat.array[i * j] = false;
                    }
                }
            }
        }
        erat.printPrimes();
        
        System.out.println("");
        
        erat.findeSummen(erat.array);
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
                System.out.print(i + ",");
            }
        }
    }
    
    public void findeSummen(boolean []primesBoolean)
    {
        ArrayList<Integer> N_gerade = new ArrayList<>();
        ArrayList<Integer> primes = new ArrayList<>();
        ArrayList<String> erg = new ArrayList<>();
        
       
        
        //N 
        for (int i = 1; i < primesBoolean.length; i++) {
            if(i%2 == 0)
               N_gerade.add(i);
        }
        
        //Primzahlen
        for (int i = 0; i < primesBoolean.length; i++) {
            if(primesBoolean[i]==true)
            {
                primes.add(i);
            }
        }
        
        //funktioniert halb
        /*
        for (int i = 0; i < primes.size(); i++) {
            for (int j = 0; j <primes.size() ; j++) {
                int zwischenSumme = primes.get(i)+ primes.get(j);
                if(N_gerade.contains(zwischenSumme)==true)
                {
                    
                    int ergebnis = primes.get(i)+ primes.get(j);
                    erg.add(ergebnis + " summe: " + ergebnis + " = " + primes.get(i)+" + "+ primes.get(j));
                }
            }
        }
        */
        
        for (int i = 0; i < N_gerade.size(); i++) {
            
            for (int j = 0; j < primes.size(); j++) {
                for (int k = 0; k < primes.size(); k++) {
                   if(N_gerade.get(i)== primes.get(j)+primes.get(k))
                   {
                    int ergebnis = primes.get(j)+ primes.get(k);
                    erg.add(ergebnis + " summe: " + ergebnis + " = " + primes.get(j)+" + "+ primes.get(k));
                   }
                    
                }
                
            }
            
        }
        
        for (int i = 0; i < erg.size(); i++) {
            System.out.println(erg.get(i)); 
        }
        
         System.out.println("N_gerade: " + N_gerade.size());
        System.out.println("primes: " + primes.size());
        System.out.println("erg: " + erg.size());
    }
}
