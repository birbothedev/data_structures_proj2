package proj2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//        // create polynomials file
//        File polynomialsFile = new File("polynomial.txt");
//        //write to file
//        try {
//            FileWriter myWriter = new FileWriter("polynomial.txt");
//            myWriter.write("Files in Java might be tricky, but it is fun enough!");
//            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }

        // create array list to store polynomials
        ArrayList<Polynomial> polynomials = new ArrayList<>();
        // file reader in try catch block to prevent error from empty file
        try {
            BufferedReader br = new BufferedReader(new FileReader("polynomials.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                Polynomial poly = new Polynomial(line);
                polynomials.add(poly);
                poly.print();
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("polynomials.txt not found. You can manually enter polynomials.");
        }

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Which polynomials do you want to add? Press -1 to exit");
            for (int i = 0; i < polynomials.size(); i++){
                System.out.println(i + ": " + polynomials.get(i));
            }
        }



    }
}