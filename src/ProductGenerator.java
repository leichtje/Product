import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductGenerator {public static void main(String[] args) {

    ArrayList<Product> products = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    boolean done = false;
    String record = "";
    String ID = "";
    String name = "";
    String description = "";
    double cost = 0;
    String fileName = "";
    Product pro;

    do {
        ID = SafeInput.getNonZeroLenString(in, "Enter the ID of the product [6 Digits]" );
        name = SafeInput.getNonZeroLenString(in, "Enter the name of the product");
        description = SafeInput.getNonZeroLenString(in, "Enter a short description of the product");
        cost = SafeInput.getDouble(in,"Enter cost of the product");

        pro = new Product(ID,name,description,cost);
        products.add(pro);

        done = SafeInput.getYNConfirm(in, "Do you have any more records to add?");

    }while(done);

//    for( String f: products)
//        System.out.println(f);

    fileName = SafeInput.getNonZeroLenString(in, "What do you want to name your file?");
    File workingDirectory = new File(System.getProperty("user.dir"));
    Path file = Paths.get(workingDirectory.getPath() + "//src//" + fileName + ".txt");

    try{
        OutputStream out = new BufferedOutputStream(Files.newOutputStream(file,CREATE));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

        String n;
        for (Product rec: products){
            n = rec.toCSVDataRecord();
            System.out.println(n);
            writer.write(n,0,n.length());
            writer.newLine();
        }
        writer.close();
        System.out.println("Data has been successfully written");

    }catch (IOException ex){
        ex.printStackTrace();
    }


}
}
