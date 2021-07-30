/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package gere.tetel;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Acer
 */
public class GereTetel {

  private void printProgress() {
  }

  /**
   * @param args the command line arguments
   */
  static final int MAX_NUM_PRIMES = 10000000;

  public static void main(String[] args) throws IOException {
    int prim[] = new int[MAX_NUM_PRIMES];
    prim[0] = 2;
    prim[1] = 3;
    int pf = 2;
    int o = 2;
    int j = 1;
    int i = 2;
    int g = 0;
    int k = 3;
    int max = 2;
    int maxi = 2;
    int ii = 0;
    int ik = i;

    boolean a = true;
    boolean b = true;
    boolean c = true;
    boolean d = true;
    boolean e = true;
    boolean f = true;
    boolean gg = true;
    boolean h = true;
    boolean hh = true;

    while (k < 1000000) {

      if (max < prim[g]) {
        ik = i; // muvelet
        prim[i] = pf + prim[g];
        o++;
        // System.out.println(prim[i]);
        k = prim[i];

        if (k > 100000 && a) {
          System.out.println("100.000 ig eddig fut le =  " + o);
          a = false;
        }
        if (k > 200000 && b) {
          System.out.println("200.000 ig eddig fut le =  " + o);
          b = false;
        }
        if (k > 300000 && c) {
          System.out.println("300.000 ig eddig fut le =  " + o);
          c = false;
        }
        if (k > 400000 && d) {
          System.out.println("400.000 ig eddig fut le =  " + o);
          d = false;
        }
        if (k > 500000 && e) {
          System.out.println("500.000 ig eddig fut le =  " + o);
          e = false;
        }
        if (k > 600000 && f) {
          System.out.println("600.000 ig eddig fut le =  " + o);
          f = false;
        }
        if (k > 700000 && gg) {
          System.out.println("700.000 ig eddig fut le =  " + o);
          gg = false;
        }
        if (k > 800000 && h) {
          System.out.println("800.000 ig eddig fut le =  " + o);
          h = false;
        }
        if (k > 900000 && hh) {
          System.out.println("900.000 ig eddig fut le =  " + o);
          hh = false;
        }

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
    k = 0;
    i = 0;
    System.out.println("Osszetett szamok kisyelektalasa");
    while (prim[k] < 1000) {
      if (prim[i] % prim[k] == 0 && prim[k] != prim[i]) {

        ii = i;
        while (ii < maxi) {
          prim[ii] = prim[ii + 1];
          ii++;

        }
        maxi = maxi - 1;
        i = i - 1;
      }
      if (i == maxi) {

        i = k;
        k++;
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
