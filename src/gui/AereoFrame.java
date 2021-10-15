package gui;

import javax.swing.*;

import bean.Aereo;
import services.ServicesCustomer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AereoFrame extends JFrame {

	
    JPanel left = new JPanel();
    JPanel leftN = new JPanel();
    JPanel leftS = new JPanel();
    JPanel right = new JPanel();

    JTextField idField = new JTextField("Inserisci id");
    JTextField tipoAereoField = new JTextField("Inserisci tipo aereo");
    JTextField postiField = new JTextField("Inserisci numero posti");
    JTextField compagniaField = new JTextField("Inserisci compagnia");
    JTextField nomeField = new JTextField("Inserisci nome");

    JButton insertButton = new JButton("Inserisci");
    JButton deleteButton = new JButton("Cancella");
    JButton updateButton = new JButton("Aggiorna");
    JButton idButton= new JButton(" Visualizza ID");
    JButton allButton= new JButton("Visualizza tutto");

    JTextArea areaView = new JTextArea("Risultati",25,27);
 

    AereoFrame(){
    	
        super("Aereo");

        ServicesCustomer service = new ServicesCustomer();

        Container c = this.getContentPane();
        c.setLayout(new GridLayout(1,2));

        left.setLayout(new GridLayout(2,1));
        leftN.setLayout(new GridLayout(6,1));
        leftS.setLayout(new GridLayout(5,1));

        leftN.add(idField);
        leftN.add(tipoAereoField);
        leftN.add(postiField);
        leftN.add(compagniaField);
        leftN.add(nomeField);
        leftN.add(new JPanel());

        leftS.add(insertButton);
        leftS.add(deleteButton);
        leftS.add(updateButton);
        leftS.add(idButton);
        leftS.add(allButton);


        insertButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	
                int aereoId = Integer.parseInt(idField.getText());
                String tipoAereo = tipoAereoField.getText();
                int postiDisponibili = Integer.parseInt(postiField.getText());;
                String compagniaAppartenenza = compagniaField.getText();
                String nomeAereo = nomeField.getText();
               
                Aereo aereo = new Aereo(aereoId, tipoAereo, postiDisponibili, compagniaAppartenenza, nomeAereo);
                boolean flag = service.insertAereo(aereo);
                
                if(flag==true) {
                    JOptionPane.showMessageDialog(c, " aereo inserito correttamente" );
                } else {
                    JOptionPane.showMessageDialog(c, "aereo non inserito");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	  int aereoId = Integer.parseInt(idField.getText());
            	  boolean flag = service.deleteAereo(aereoId);
                  
                  if(flag==true) {
                      JOptionPane.showMessageDialog(c, " aereo cancellato correttamente" );
                  } else {
                      JOptionPane.showMessageDialog(c, "aereo non cacellato");
                  }

            }
        });
        updateButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
            	
                int aereoId = Integer.parseInt(idField.getText());
                String tipoAereo = tipoAereoField.getText();
                int postiDisponibili = Integer.parseInt(postiField.getText());;
                String compagniaAppartenenza = compagniaField.getText();
                String nomeAereo = nomeField.getText();
               
                Aereo aereo = new Aereo(aereoId, tipoAereo, postiDisponibili, compagniaAppartenenza, nomeAereo);
                boolean flag = service.updateAereo(aereo, aereoId);
                
                if(flag==true) {
                    JOptionPane.showMessageDialog(c, " aereo aggiornato correttamente" );
                } else {
                    JOptionPane.showMessageDialog(c, "aereo non aggiornato");
                }

            }
        });
        idButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	int aereoId = Integer.parseInt(idField.getText());
            	Aereo aereo = service.getAereoByPK(aereoId);
            	if( aereo == null) {
            		JOptionPane.showMessageDialog(c, "aereo non trovato");
            	} else {
            		
                    areaView.setText(aereo.toString());
            	}
            }
        });
        allButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	ArrayList<Aereo> lista = service.getAerei();
            	
            	if( lista.size() == 0) {
            		areaView.setText("nessun aereo presente");
            	} else {
                    areaView.setText("");
            		for (Aereo ar: lista)
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
