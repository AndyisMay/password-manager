package andreaigner;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private final String username;
    private final String email;
    private final String password;

    public Writer(String username, String email, String password) throws IOException {
        if(password == null){
            throw new IllegalArgumentException("password required");
        }
        if(username == null && email == null){
            throw new IllegalArgumentException("data incomplete");
        }
        if(username == email){
            throw new IllegalArgumentException("username and email cant be the same");
        }
        this.username = username;
        this.email = email;
        this.password = password;

        Main.writer = new FileWriter(Main.data, true);
        Main.writer.write(Main.encrypt(Main.platform) + " " + username + " " + email + " " + password + " " + (Main.offset[0]*Main.offset[0]) + " ");
        Main.writer.flush();
        Main.writer.close();
    }

    public Writer() throws IOException {
        this.username = null;
        this.email = null;
        this.password = null;

        Main.writer = new FileWriter(Main.data);
        Main.writer.write("");
        Main.writer.flush();
        Main.writer.close();
    }
}
