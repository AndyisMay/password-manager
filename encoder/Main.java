package andreaigner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static FileWriter writer;
    public static File data = new File("pw_data.txt");
    public static final String acces_code = "1405";
    public static int[] offset = {0};
    public static String platform;


    public static void main(String args[]) throws IOException {
        if(args[0].equals("del_all")){
            Writer two = new Writer();
            System.exit(1);
        }
        if(args.length < 4){
            throw new IllegalArgumentException("not enought input");
        }
        if(args[4]==null){
            offset[0]=0;
        }
        else{
            offset[0] = Integer.parseInt(args[4]);
        }
        platform = args[0];
        String username = args[1];
        String mail = args[2];
        String pw = args[3];
        Writer one = new Writer(encrypt(username), encrypt(mail), encrypt(pw));
    }

    public static char encryptChar(char a, int[] offset){
        int help = offset[0];
        if(((int)a + help) > 255){
            return (char) ((int) a + help - 255);
        }
        else {
            return (char) ((int) a + help);
        }
    }

    public static String encrypt(String string){
        String output = "";
        for(int n = 0; n < string.length(); n++){
            output += encryptChar(string.charAt(n), offset);
        }
        return output;
    }
}
