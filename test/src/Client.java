import java.io.BufferedReader;  
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;  
import java.io.OutputStreamWriter;  
import java.io.Writer;  
import java.net.Socket;


public class Client extends Socket{
	public static final String IP_ADDR = "localhost";//服务器地址   
    public static final int PORT = 8899;//服务器端口号    
    private Socket client;
    
    //构造函数
    public Client() throws Exception {  
        super(IP_ADDR, PORT);  
        this.client = this;
    }
    //初始化
	private void init() throws Exception{
			DataOutputStream out = new DataOutputStream(client.getOutputStream());
			DataInputStream input = new DataInputStream(client.getInputStream());
	        new Thread(new ReceiveMsg()).start(); // 启动监听  
	        while(true) {    
	        	String inputMsg = new BufferedReader(new InputStreamReader(System.in)).readLine();
	            out.writeUTF(inputMsg+"\n");  
	            out.flush();
	        }
	        
	}
	//内部类
	class ReceiveMsg implements Runnable {  	
		@Override
		public void run() {
			// TODO 自动生成的方法存根
			try{
				DataInputStream input = new DataInputStream(client.getInputStream());
				while (true) {  
                    String result = input.readUTF();                 
                    System.out.println(result);
                }  
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}  
 
    }
	//主函数
	public static void main(String[] args) {   
    	try{
    		Client client = new Client();
    		client.init();
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }
}
