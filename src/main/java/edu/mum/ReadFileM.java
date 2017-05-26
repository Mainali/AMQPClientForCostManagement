package edu.mum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            FileReader fr = new FileReader("d:/uploads/b455a0ae-9a6e-4bf2-93e6-bd3450c82fd0-license.txt");
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while((line=reader.readLine())!=null) {
                System.out.println("field:"+line.substring(0, line.lastIndexOf("="))+" val:"+line.substring(line.lastIndexOf("=")));
            }
        }catch(IOException ex) {
            ex.printStackTrace();
        }
	}

}
