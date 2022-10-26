package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Servidor extends Thread{
    
    
    //Porta de comunicação
    private final String HOST = "127.0.0.1";
    private final int PORTA_RECEBER = 12345;
    private final int PORTA_ENVIAR = 12346;
    private JTextField txtPlacar1;
    private JTextField txtPlacar2;
    public static String nome;
    public static String Msg;
    
    
    
    
    public Servidor(){
        System.out.println("Servidor iniciado na porta " + PORTA_RECEBER);
        
    }

    
    
    public void enviar1 (String msg1){
        try{
            //converter a MSG em bytes
            byte[] buffer = msg1.getBytes();         
            DatagramPacket pct1 = new DatagramPacket(
               buffer,
               buffer.length,
               InetAddress.getByName(HOST),
               PORTA_ENVIAR
            
            );
            
           
        //enviar o pacote
            new DatagramSocket().send(pct1);
            
           
            
        } catch(Exception e){
            System.err.println("ERRO: " + e.getMessage());
        }
    }
    public void enviar2 (String msg2){
        try{
            //converter a MSG em bytes
            byte[] buffer = msg2.getBytes();         
            DatagramPacket pct2 = new DatagramPacket(
               buffer,
               buffer.length,
               InetAddress.getByName(HOST),
               PORTA_ENVIAR
            
            );
            
           
        //enviar o pacote
            new DatagramSocket().send(pct2);
            
           
            
        } catch(Exception e){
            System.err.println("ERRO: " + e.getMessage());
        }
    }
    public void enviar3 (String msg3){
        try{
            //converter a MSG em bytes
            byte[] buffer = msg3.getBytes();         
            DatagramPacket pct3 = new DatagramPacket(
               buffer,
               buffer.length,
               InetAddress.getByName(HOST),
               PORTA_ENVIAR
            
            );
            
           
        //enviar o pacote
            new DatagramSocket().send(pct3);
            
           
            
        } catch(Exception e){
            System.err.println("ERRO: " + e.getMessage());
        }
    }
    public void enviar4 (String msg4){
        try{
            //converter a MSG em bytes
            byte[] buffer = msg4.getBytes();         
            DatagramPacket pct4 = new DatagramPacket(
               buffer,
               buffer.length,
               InetAddress.getByName(HOST),
               PORTA_ENVIAR
            
            );
            
           
        //enviar o pacote
            new DatagramSocket().send(pct4);
            
           
            
        } catch(Exception e){
            System.err.println("ERRO: " + e.getMessage());
        }
    }
    
    
        
        
        
    
   
    
}


