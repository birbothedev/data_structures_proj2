package proj2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        // create array list to store polynomials
        ArrayList<Polynomial> polynomials = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("polynomials.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            Polynomial poly = new Polynomial(line);
            polynomials.add(poly);
            poly.print();
        }
        br.close();


    }
}