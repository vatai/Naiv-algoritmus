/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package gere.tetel;
// javac GereTetel.java && java GereTetel >| stdout && (md5sum stdout && md5sum prims.txt) | diff gold -

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Acer
 */
public class GereTetel {

  static private int printProgressPrimeLimit = 100000;

  static private void printProgress(int prime, int numPrimes) {
    if (prime > printProgressPrimeLimit) {
      int start = prime / 1000;
      if (start < 1000) // This is should be removed.
        System.out.println(start + ".000 ig eddig fut le =  " + numPrimes);
      printProgressPrimeLimit += 100000;
    }
  }

  static final int MAX_NUM_PRIMES = 10000000;
  static final int MAX_PRIME = 1000000;

  public static void main(String[] args) throws IOException {
    int prim[] = new int[MAX_NUM_PRIMES];
    prim[0] = 2;
    prim[1] = 3;
    int pf = 2;
    int numPrimes = 2;
    int j = 1;
    int i = 2;
    int g = 0;
    int prime = 3;
    int max = 2;
    int maxi = 2;
    int ii = 0;
    int ik = i;

    while (prime < MAX_PRIME) {

      if (max < prim[g]) {
        ik = i; // muvelet
        prim[i] = pf + prim[g];
        numPrimes++;
        // System.out.println(prim[i]);
        prime = prim[i];
        printProgress(prime, numPrimes);
        g = g + 1;
      } else {

        i = i - 1;
        g = g + 1;
      }
      if (prim[ik] > pf * prim[j]) { // ha novegszik
        pf = pf * prim[j];
        max = prim[j];

        j = j + 1;
        maxi = ik;
        ik = 0; // kikel selejtezni ami nem prim
        while (ik < maxi) {

          if (prim[ik] % max == 0 && max != prim[ik]) {

            ii = ik;
            while (ii < maxi) {
              prim[ii] = prim[ii + 1];
              ii++;

            }
            i = i - 1;
          }
          ik++;
        }
        g = 0;

      }
      i = i + 1;

    }

    maxi = i;
    prime = 0;
    i = 0;
    System.out.println("Osszetett szamok kisyelektalasa");
    while (prim[prime] < 1000) {
      if (prim[i] % prim[prime] == 0 && prim[prime] != prim[i]) {

        ii = i;
        while (ii < maxi) {
          prim[ii] = prim[ii + 1];
          ii++;

        }
        maxi = maxi - 1;
        i = i - 1;
      }
      if (i == maxi) {

        i = prime;
        prime++;
      }
      i++;
    }
    maxi = maxi + 1;

    String p;

    FileWriter fw = new FileWriter("prims.txt");
    PrintWriter pw = new PrintWriter(fw);
    i = 0;
    while (i <= maxi) {
      p = String.valueOf(prim[i]);
      pw.println(p);
      i++;
    }
    fw.close();
    pw.close();

  }

}
