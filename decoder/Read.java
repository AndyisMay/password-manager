package andreaigner;

public class Read {
    public String platform;
    public String username;
    public String email;
    public String password;
    public int offset;


    public Read(){
        this.platform = null;
        this.username = null;
        this.email = null;
        this.password = null;
        this.offset = 0;
    }
    public String getPlatform(){
        return platform;
    }
    public void toArray(){
        Main.allReads[Main.allReadsCounter]=this;
    }
    public String toString(){
        String output = "platform: " + this.platform + "\nusername: " + this.username + "\nemail: " + this.email + "\npassword: " + password + "\n";
        return output;
    }
}
