package proj2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        // create array list to store polynomials
        ArrayList<Polynomial> polynomials = new ArrayList<>();
        // file reader in try catch block to prevent error from empty file
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/polynomials.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                Polynomial poly = new Polynomial(line);
                polynomials.add(poly);
                poly.print();
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("polynomials.txt not found");
        }

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Which polynomials do you want to add? Press -1 to exit");
            // loop through polynomials
            for (int i = 0; i < polynomials.size(); i++){
                System.out.println(i + ": " + polynomials.get(i));
            }
            int index1 = scanner.nextInt();
            // if user enters anything less than 0
            if (index1 < 0){
                break;
            }
            int index2 = scanner.nextInt();
            // don't let user enter values less than 0 or more than the number of polynomials we have
            if (index2 < 0 || index1 > polynomials.size() || index2 > polynomials.size()){
                System.out.println("Invalid input. Please try again!");
            }
            // add polynomial to array
            Polynomial newPoly = Polynomial.add(polynomials.get(index1), polynomials.get(index2));
            polynomials.add(newPoly);

            System.out.println("New Polynomial added: \n");
            System.out.println(newPoly);


            // append new poly to end of file
            try (FileWriter fw = new FileWriter("src/polynomials.txt", true);
                 BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(newPoly + "\n");
            } catch (IOException e) {
                System.err.println("Error appending to file: " + e.getMessage());
            }

        }
        scanner.close();
    }
}