
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.Gson;



public class Client1 extends javax.swing.JFrame {
	static volatile boolean finished = false;
	public static String name; 
	String filePath = System.getProperty("user.home");
	
    
	
	 
	public Client1() {
        initComponents();
         name = JOptionPane.showInputDialog("User Name", "Gisele");
         
         Message msg = new Message();
         msg.setCode(800);
         msg.setExtension(null);
         msg.setContent(null);
         msg.setName(name);
         Gson gson = new Gson();
         
         sendSocket(gson.toJson(msg));
           
      
    }


	 @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	    private void initComponents() {

	        buttonGroup1 = new javax.swing.ButtonGroup();
	        buttonGroup2 = new javax.swing.ButtonGroup();
	        buttonGroup3 = new javax.swing.ButtonGroup();
	        panel = new javax.swing.JPanel();
	        message = new javax.swing.JTextField();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        conversation = new javax.swing.JTextArea();
	        Button = new javax.swing.JButton();
	        AppName = new javax.swing.JLabel();
	        online = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        userSelect = new javax.swing.JLabel();
	        jScrollPane3 = new javax.swing.JScrollPane();
	        connecte = new javax.swing.JTextArea();
	        Path = new javax.swing.JTextField();
	        sendfichier = new javax.swing.JButton();
	        Disconnect = new javax.swing.JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        panel.setBackground(new java.awt.Color(204, 204, 255));
	        panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

	        message.setText("type your text  ");
	        message.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                messageActionPerformed(evt);
	            }
	        });

	        conversation.setColumns(20);
	        conversation.setRows(5);
	        jScrollPane1.setViewportView(conversation);

	        Button.setText("SEND");
	        Button.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                ButtonActionPerformed(evt);
	            }
	        });

	        AppName.setText("Wechat");

	        online.setText("OnLine");

	        userSelect.setText("           ");

	        connecte.setColumns(20);
	        connecte.setRows(5);
	        jScrollPane3.setViewportView(connecte);

	        Path.setText("entrer le chemin du fichier");

	        sendfichier.setText("SEND");
	        sendfichier.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                sendfichierActionPerformed(evt);
	            }
	        });

	        Disconnect.setText("Déconnexion");
	        Disconnect.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                DisconnectActionPerformed(evt);
	            }
	        });

	        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
	        panel.setLayout(panelLayout);
	        panelLayout.setHorizontalGroup(
	            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(panelLayout.createSequentialGroup()
	                .addGap(19, 19, 19)
	                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(panelLayout.createSequentialGroup()
	                        .addComponent(jLabel3)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(userSelect)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addGroup(panelLayout.createSequentialGroup()
	                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                                    .addComponent(Path, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
	                                    .addComponent(message, javax.swing.GroupLayout.Alignment.LEADING))
	                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                    .addComponent(Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                    .addComponent(sendfichier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
	                        .addGap(19, 19, 19))
	                    .addComponent(AppName, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(panelLayout.createSequentialGroup()
	                        .addGap(30, 30, 30)
	                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addComponent(online, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
	                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
	                    .addGroup(panelLayout.createSequentialGroup()
	                        .addGap(22, 22, 22)
	                        .addComponent(Disconnect)))
	                .addContainerGap(73, Short.MAX_VALUE))
	        );
	        panelLayout.setVerticalGroup(
	            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
	                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(panelLayout.createSequentialGroup()
	                        .addContainerGap()
	                        .addComponent(AppName))
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
	                        .addGap(0, 35, Short.MAX_VALUE)
	                        .addComponent(online)))
	                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(panelLayout.createSequentialGroup()
	                        .addGap(5, 5, 5)
	                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addComponent(userSelect)
	                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                    .addGroup(panelLayout.createSequentialGroup()
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
	                            .addComponent(jScrollPane3)
	                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                        .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGroup(panelLayout.createSequentialGroup()
	                            .addComponent(Button, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addGap(2, 2, 2)))
	                    .addComponent(Disconnect))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(Path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(sendfichier))
	                .addContainerGap(20, Short.MAX_VALUE))
	        );

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );

	        pack();
	    }// </editor-fold>         
    private void messageActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    	ButtonActionPerformed(null);
    }  
    //Bouton envoyer fichier
    private void sendfichierActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    	byte[] input_file = null;
		try {
			input_file = Files.readAllBytes(Paths.get(filePath+Path.getText()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	byte[] encodedBytes = Base64.getEncoder().encode(input_file);
    	String str = null;
		try {
			str = new String(encodedBytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // for UTF-8 encoding
    	Message msg = new Message();
    	msg.setCode(100);
    	msg.setName(name);
    	msg.setContent(str);
    	msg.setExtension(Path.getText());
    	
    	Gson gson = new Gson();
    	sendSocket(gson.toJson(msg));
    	conversation.setText(conversation.getText() + Path.getText() + "\n");
    	
    	Path.setText("");
    }    
    
  
//Bouton envoyer message
    private void ButtonActionPerformed(java.awt.event.ActionEvent evt) {                                       
       
        // TODO add your handling code here:
    	Message msg = new Message();
    	msg.setCode(600);
    	msg.setName(name);
    	msg.setContent(message.getText());
    	msg.setExtension(null);
    	String s = message.getText();
    	

    	
    	
    	 if (s.length() == 0) {
             return;
         }
    	 
    	Gson gson = new Gson();
     	sendSocket(gson.toJson(msg));
    	conversation.setText(conversation.getText() + s + "\n");
    	message.setText("");
    	
    	
    	//ReadThread.run();
    	}     
    //Bouton deconnecte
    private void DisconnectActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    	Message msg = new Message();
        msg.setCode(700);
        msg.setExtension(null);
        msg.setContent(null);
        msg.setName(name);
        Gson gson = new Gson();
        
        sendSocket(gson.toJson(msg));
    	System.exit(0);
    }   

    private void userOnlinePerformed(java.awt.event.ActionEvent evt){
        
    }

//----creation du socket pour l'envoie du message
public static void sendSocket(String m) {
	
	try
	{ 
		//choix d'une adresse multicast  (224.0.0.0 à 239.255.255.255) 
		InetAddress group = InetAddress.getByName("224.0.0.1");
		//le port choisi		
		int port = 2244; 
		//creation du socket multicast
		MulticastSocket socket = new MulticastSocket(port);
		//TTL
		socket.setTimeToLive(2);
		//joindre le ggroupe de diffusion
		socket.joinGroup(group);
		Thread t = new Thread(new ReadThread(socket,group,port));
		t.start();
		
		 while(true) {
			 String message =  m; 
			byte[] buffer = message.getBytes(); 
			//creation du datagram
			DatagramPacket datagram = new
			DatagramPacket(buffer,buffer.length,group,port); 
			//envoie du datagram par le socket
			socket.send(datagram); 
			break; 
			} 
		    
		 	
	} 
	catch(SocketException se) 
	{ 
		System.out.println("Error creating socket"); 
		se.printStackTrace(); 
	} 
	catch(IOException ie) 
	{ 
		System.out.println("Error reading/writing from/to socket"); 
		ie.printStackTrace(); 
	} 
	
}	 

//fonction main----------------------------------------------------
public static void main(String args[]) {
	//utiliser IPv4 socket
	System.setProperty("java.net.preferIPv4Stack", "true");
	
    java.awt.EventQueue.invokeLater(new Runnable() {

        public void run() {
            new Client1().setVisible(true);
        }
    });
    
}
//end fonction man--------------------------------------------------



public static javax.swing.JTextArea getConversation() {
	return conversation;
}


public void setConversation(javax.swing.JTextArea conversation) {
	this.conversation = conversation;
}
public static javax.swing.JTextArea getConnecte() {
	return connecte;
}


public void setConnecte(javax.swing.JTextArea connecte) {
	this.connecte = connecte;
}
//----------------------------------------------------------------------------

//Variables declaration de l'interface Graphique (ne pas modifier)                     
private javax.swing.JLabel AppName;
private javax.swing.JButton Button;
private javax.swing.JButton Disconnect;
private javax.swing.ButtonGroup buttonGroup1;
private javax.swing.ButtonGroup buttonGroup2;
private javax.swing.ButtonGroup buttonGroup3;
public static javax.swing.JTextArea connecte;
public static javax.swing.JTextArea conversation;
private javax.swing.JLabel jLabel3;
private javax.swing.JScrollPane jScrollPane1;
private javax.swing.JScrollPane jScrollPane3;
private javax.swing.JTextField Path;
private javax.swing.JTextField message;
private javax.swing.JLabel online;
private javax.swing.JPanel panel;
private javax.swing.JButton sendfichier;
private javax.swing.JLabel userSelect;
private boolean firstMessage = false;
// End of variables declaration--------------------------------------------------     
}
class ReadThread  implements Runnable 
{ 
	private MulticastSocket socket; 
	private InetAddress group; 
	private int port; 
	private static final int MAX_LEN = 16384; 
	int user=1;
	public static List<String> status = new ArrayList<>();
	ArrayList<String> filtre=new ArrayList<String>();
	
	
	ReadThread(MulticastSocket socket,InetAddress group,int port) 
	{ 
		this.socket = socket; 
		this.group = group; 
		this.port = port; 
	} 
	
	@Override
	public void run() 
	{ 
		//List<String> status = new ArrayList<>();
		status.add(Client1.name+" OnLine");
		while(!Client1.finished) 
		{ 
				byte[] buffer = new byte[ReadThread.MAX_LEN]; 
				DatagramPacket datagram = new
				DatagramPacket(buffer,buffer.length,group,port); 
				String message; 
			try
			{ 
				//reception du datagram
				socket.receive(datagram); 
				message = new
				String(buffer,0,datagram.getLength(),"UTF-8");
				Gson gson = new Gson();
				Message msg = gson.fromJson(message, Message.class);
				//test sur le champ code du datagram
				if(!Client1.name.equalsIgnoreCase(msg.getName())) {
					//si le champ code est egal a 800 il repond pour dire qu'il est connecte aussi afin de mettre 
					//sa liste de connection a jour
					
					
						
					 if(msg.code==800) {
						if(msg.content==null) {
							status.add( msg.name+" OnLine");
						
						Message msg1 = new Message();
				        msg1.setCode(800);
				        msg1.setExtension(null);
				        String json = new Gson().toJson(status);
				        
				        msg1.setContent(json);
				        msg1.setName(null);
				        Gson gson2 = new Gson();
				        Client1.sendSocket(gson2.toJson(msg1));
				        
						
						
						
						
							}if(msg.content!=null) {
//								ObjectMapper mapper = new ObjectMapper();
//						    	mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
//						    	ArrayList<String> strings = mapper.readValue(msg.getContent(), ArrayList.class);
//						    	for(int i=0; i<strings.size(); i++) {
//						    		System.out.println(strings.get(i));
//						    		Client1.connecte.setText(Client1.connecte.getText()+strings.get(i)+"\n");
//						    		
//						    	}
							}

					
						
				//si le code est egal a 600 c'est un message texte	
					}else if(msg.code==600) {
						
						
						
							Client1.conversation.setText(Client1.conversation.getText()+msg.getName()+": "+msg.getContent()+"\n");
						
					
						
						
				//si le code est egal a 100 c'est un fichier il va enregistrer le fichier dans le repertoire 
				//personnel de l'utilisateur
					}else if(msg.code==100) {
						byte[] decodedBytes = Base64.getDecoder().decode(msg.getContent().getBytes());
					
						File file = new File(System.getProperty("user.home"), "/"+msg.getExtension());
						FileOutputStream fos = new FileOutputStream(file);
						fos.write(decodedBytes);
						fos.flush();
				        fos.close();
				        
				        Client1.getConversation().setText(Client1.getConversation().getText() +msg.getName()+":"+System.getProperty("user.home")+msg.getExtension()+"\n") ;
						System.out.println(msg.getCode()+":"+msg.getName()+":"+msg.getContent());
						System.out.println(decodedBytes);
						
			        
					//code 700 l'utilisateur envoie un message de deconnexion status mise a jour "offline"
				}else if(msg.code==700){
					Client1.connecte.setText(Client1.connecte.getText() + msg.getName()+": offline"+"\n");
				}
					
				}
				
				
		
		
				
			} 
			catch(IOException e) 
			{ 
				System.out.println("Socket closed!"); 
			} 
		} 
	}

	
}




