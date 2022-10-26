package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.StringTokenizer;
import javax.swing.JTextField;


public class Cliente extends Thread{
    
    private final String HOST = "127.0.0.1";
    private final int PORTA_ENVIAR = 12345;
    private final int PORTA_RECEBER = 12346;
    private JTextField txtPlacar1;
    private JTextField txtPlacar2;
    private JTextField txtNomeTime1;
    private JTextField txtNomeTime2;
    public Cliente(JTextField txtPlacar1,JTextField txtPlacar2,JTextField txtNomeTime1,JTextField txtNomeTime2){
        this.txtPlacar1 = txtPlacar1;
        this.txtPlacar2 = txtPlacar2;
        this.txtNomeTime1 = txtNomeTime1;
        this.txtNomeTime2 = txtNomeTime2;
    }
    
    
    public void enviar (String msg){
        try{
            //converter a MSG em bytes
            byte[] buffer = msg.getBytes();
            
            DatagramPacket pct = new DatagramPacket(
               buffer,
               buffer.length,
               InetAddress.getByName(HOST),
               PORTA_ENVIAR
            
            );
            
           
        //enviar o pacote
            new DatagramSocket().send(pct);
            
           
            
        } catch(Exception e){
            System.err.println("ERRO: " + e.getMessage());
        }
    }
    
    @Override
    public void run(){
        
        try {   
            //criar um novo SOCKET
            DatagramSocket srv = new DatagramSocket(PORTA_RECEBER);
            
            while(true){
                //definir o buffer da mensagem
                
                byte[] buffer = new byte[266];
                byte[] buffer2 = new byte[266];
                byte[] buffer3 = new byte[266];
                byte[] buffer4 = new byte[266];
                DatagramPacket pct1 = new DatagramPacket(
                    buffer,
                       buffer.length
                );
                DatagramPacket pct2 = new DatagramPacket(
                    buffer2,
                       buffer2.length
                );
                DatagramPacket pct3 = new DatagramPacket(
                    buffer3,
                       buffer3.length
                );
                DatagramPacket pct4 = new DatagramPacket(
                    buffer4,
                       buffer4.length
                );
                
                //receber o pacote
                //impede que o looping fique consumindo memoria e trave a aplicação
                srv.receive(pct1);
                srv.receive(pct2);
                srv.receive(pct3);
                srv.receive(pct4);
                //tranformar o pacto no tipo esperado
                String msg1 = new String(pct1.getData()).trim();
                String msg2 = new String(pct2.getData()).trim();
                String msg3 = new String(pct3.getData()).trim();
                String msg4 = new String(pct4.getData()).trim();
                
                //exibir a mensagem no servidor             
                txtPlacar1.setText(msg1);
                txtPlacar2.setText(msg2);
                txtNomeTime1.setText(msg3);
                txtNomeTime2.setText(msg4);
                
                
            }
            
        }catch(Exception e){
            System.err.println("ERRO: " + e.getMessage());
        }
        
}
}
