package poo.file;

import java.io.*;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) throws IOException {
        File f = new File("C:\\Users\\king_\\Desktop\\file.txt");
        // Usando FileWrite e FileReader
        FileWriter writer = new FileWriter(f);
        writer.write("Hello World!");

        writer.close();

        FileReader reader = new FileReader(f);
        String str = "";
        int c;
        while ((c = reader.read())!=-1) {
           str+=(char) c;
        }
        System.out.println("Using FileReader: "+str);

        // Usando Files
        String text = "Hello World!";
        File f2 = new File("C:\\Users\\king_\\Desktop\\file2.txt");

        Files.write(f2.toPath(), text.getBytes());

        String read = Files.readString(f2.toPath());
        System.out.println("Using Files: " + read);
    }
}
