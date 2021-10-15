package gui;

import javax.swing.*;

import bean.Aereo;
import bean.Aeroporto;
import services.ServicesCustomer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AeroportoFrame extends JFrame {

	
    JPanel left = new JPanel();
    JPanel leftN = new JPanel();
    JPanel leftS = new JPanel();
    JPanel right = new JPanel();

    JTextField idField = new JTextField("Inserisci id");
    JTextField cittaField = new JTextField("Inserisci città aeroporto");
    JTextField nomeField = new JTextField("Inserisci nome aeroporto");
    JTextField nazioneField = new JTextField("Inserisci nazione aeroporto");
    JTextField numeroPisteField = new JTextField("Inserisci numero piste aeroporto");
    

    JButton insertButton = new JButton("Inserisci");
    JButton deleteButton = new JButton("Cancella");
    JButton updateButton = new JButton("Aggiorna");
    JButton idButton= new JButton(" Visualizza ID");
    JButton allButton= new JButton("Visualizza tutto");

    JTextArea areaView = new JTextArea("Risultati",25,27);
 

    AeroportoFrame(){
    	
        super("Aeroporto");

        ServicesCustomer service = new ServicesCustomer();

        Container c = this.getContentPane();
        c.setLayout(new GridLayout(1,2));

        left.setLayout(new GridLayout(2,1));
        leftN.setLayout(new GridLayout(6,1));
        leftS.setLayout(new GridLayout(5,1));

        leftN.add(idField);
        leftN.add(cittaField);
        leftN.add(nomeField);
        leftN.add(nazioneField);
        leftN.add(numeroPisteField);
        
        leftN.add(new JPanel());

        leftS.add(insertButton);
        leftS.add(deleteButton);
        leftS.add(updateButton);
        leftS.add(idButton);
        leftS.add(allButton);


        insertButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	
                int aeroportoId = Integer.parseInt(idField.getText());
                String citta = cittaField.getText();
                String nazione = nazioneField.getText();
                String nome = nomeField.getText();
                int numeropiste = Integer.parseInt(numeroPisteField.getText());
               
                Aeroporto aeroporto = new Aeroporto(aeroportoId, citta, nazione, nome, numeropiste);
                boolean flag = service.insertAeroporto(aeroporto);
                
                if(flag==true) {
                    JOptionPane.showMessageDialog(c, "aeroporto inserito correttamente");
                } else {
                    JOptionPane.showMessageDialog(c, "aeroporto non inserito");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	  int aeroportoId = Integer.parseInt(idField.getText());
            	  boolean flag = service.deleteAeroporto(aeroportoId);
                  
                  if(flag==true) {
                      JOptionPane.showMessageDialog(c, " aeroporto cancellato correttamente" );
                  } else {
                      JOptionPane.showMessageDialog(c, "aeroporto non cacellato");
                  }

            }
        });
        
        updateButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
            	
        		  int aeroportoId = Integer.parseInt(idField.getText());
                  String citta = cittaField.getText();
                  String nazione = nazioneField.getText();
                  String nome = nomeField.getText();
                  int numeropiste = Integer.parseInt(numeroPisteField.getText());
               
                  Aeroporto aeroporto = new Aeroporto(aeroportoId, citta, nazione, nome, numeropiste);
                  boolean flag = service.updateAeroporto(aeroporto,aeroportoId);
                  
                if(flag==true) {
                    JOptionPane.showMessageDialog(c, " aereo aggiornato correttamente" );
                } else {
                    JOptionPane.showMessageDialog(c, "aereo non aggiornato");
                }

            }
        });
        idButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	int aeroportoId = Integer.parseInt(idField.getText());
            	Aeroporto aeroporto = service.getAeroportoByPK(aeroportoId);
            	if( aeroporto == null) {
            		JOptionPane.showMessageDialog(c, "aereo non trovato");
            	} else {
            		
                    areaView.setText(aeroporto.toString());
            	}
            }
        });
        allButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	ArrayList<Aeroporto> lista = service.getAeroporti();
            	
            	if( lista.size() == 0) {
            		areaView.setText("nessun aereo presente");
            	} else {
                    areaView.setText("");
            		for (Aeroporto ar: lista)
            			areaView.append(ar.toString() + "\n");
            	}
            }
        });


        areaView.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaView);
       // scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
       // scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        right.add(scrollPane);

        left.add(leftN);
        left.add(leftS);
        left.setSize(250,500);
        c.add(left);
        c.add(right);
        this.setSize(800,500);
    	this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);
    }
}
