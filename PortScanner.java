import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;

public class PortScanner{

    private String targetHost;
    private int startPort;
    private int endPort;

    public PortScanner(){
        targetHost = "http://scanme.nmap.org";
        startPort = 1;
        endPort = 65535; //default scan all ports
    }

    public void scan(){
        System.out.println("testing....")
        //iterate through given ports
        for(int p = this.startPort; p <= this.endPort; p++){
            try{
                //attempt socket connection
                Socket s = new Socket();
                s.connect(new InetSocketAddress(this.targetHost, p), 1000); //timeout = 1s
                //continues if port open
                System.out.println("port " + p + " open");
                s.close();
            }
            catch(Exception e){
                System.out.println("caught");
                //currently only printing open ports
            }
        }
    }

}