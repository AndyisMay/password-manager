package andreaigner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
public static Read[] allReads = new Read[500];
public static int allReadsCounter = 0;
public static Scanner s;
public static File data = new File("C://passwords//pw_data.txt");

    public static char encryptChar(char a, int offset){
        int help = offset;
        if((int)a - help < 0){
            return (char) ((int) a - help + 255);
        }
        else {
            return (char) ((int) a - help);
        }
    }
    public static String encrypt(String string, int offset){
        String output = "";
        for(int n = 0; n < string.length(); n++){
            output += encryptChar(string.charAt(n), offset);
        }
        return output;
    }

public static void decode(Read character){
    int os = (int)Math.sqrt(character.offset);
    String output_platform = encrypt(character.platform, os);
    String output_username = encrypt(character.username, os);
    String output_email = encrypt(character.email, os);
    String output_password = encrypt(character.password, os);

    character.platform = output_platform;
    character.username = output_username;
    character.email = output_email;
    character.password = output_password;
}
    public static void main(String[] args) throws FileNotFoundException {
        s = new Scanner(data);
        while(s.hasNext()) {
            if (s.hasNext()) {
                String platform = s.next();
                String username = s.next();
                String email = s.next();
                String pw = s.next();
                int offset = Integer.parseInt(s.next());
                Read read = new Read();
                read.platform = platform;
                read.username = username;
                read.email = email;
                read.password = pw;
                read.offset = offset;
                decode(read);
                read.toArray();
                System.out.println(allReads[allReadsCounter].toString());
            }
        }
        s.close();
    }
}

