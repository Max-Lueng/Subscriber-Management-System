import java.io.BufferedReader;  
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;  
import java.io.OutputStreamWriter;  
import java.io.Writer;  
import java.net.Socket;


public class Client extends Socket{
	public static final String IP_ADDR = "localhost";//��������ַ   
    public static final int PORT = 8899;//�������˿ں�    
    private Socket client;
    
    //���캯��
    public Client() throws Exception {  
        super(IP_ADDR, PORT);  
        this.client = this;
    }
    //��ʼ��
	private void init() throws Exception{
			DataOutputStream out = new DataOutputStream(client.getOutputStream());
			DataInputStream input = new DataInputStream(client.getInputStream());
	        new Thread(new ReceiveMsg()).start(); // ��������  
	        while(true) {    
	        	String inputMsg = new BufferedReader(new InputStreamReader(System.in)).readLine();
	            out.writeUTF(inputMsg+"\n");  
	            out.flush();
	        }
	        
	}
	//�ڲ���
	class ReceiveMsg implements Runnable {  	
		@Override
		public void run() {
			// TODO �Զ����ɵķ������
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
	//������
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
