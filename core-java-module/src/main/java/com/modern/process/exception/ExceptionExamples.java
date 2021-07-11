package com.modern.process.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionExamples {

    // checked exception with throws
    private static void checkedExceptionWithThrows() throws FileNotFoundException {
        File file = new File("not_exsisting_file.txt");
        FileInputStream stream = new FileInputStream(file);
    }

    // checked exception with try catch
    private static void checkedExceptionWithTryCatch(){
        File file = new File("not_exsisting_file.txt");
        try {
            FileInputStream stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void runtimeNullPointerException(){
        String name = null;
        try {
            name.length();
        } catch (NullPointerException exp){
            System.out.printf("Object reference cannot be null");
        }
    }


    public int getPlayerScoreFinally(String playerFile){
        Scanner contents = null;
        try {
            contents = new Scanner(new File(playerFile));
            return Integer.parseInt(contents.nextLine());
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } finally {
            if (contents != null){
                contents.close();
            }
        }
        return 0;
    }

    public int getPlayerScoreTryWithResource(String playerFile){
       try (Scanner contents = new Scanner(new File(playerFile))){
           return Integer.parseInt(contents.nextLine());
       } catch (FileNotFoundException e) {
           System.out.println("File not found");
       }
        return 0;
    }

}
