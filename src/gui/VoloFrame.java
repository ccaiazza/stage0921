package gui;

import javax.swing.*;

import bean.Aereo;
import bean.Aeroporto;
import bean.Volo;
import services.ServicesCustomer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class VoloFrame extends JFrame {


	JPanel left = new JPanel();
	JPanel leftN = new JPanel();
	JPanel leftS = new JPanel();
	JPanel right = new JPanel();

	JTextField codiceVoloField = new JTextField("inserisci codice Volo");
	JTextField dataPartenzaField = new JTextField("inserisci data partenza");
	JTextField dataArrivoField = new JTextField("inserisci data arrivo");
	JTextField numeroPasseggeriField = new JTextField("inserisci numero passeggeri");
	JTextField aeroportoPartenzaField = new JTextField("Inserisci aeroporto partenza");
	JTextField aeroportoArrivoField = new JTextField("Inserisci aeroporto arrivo");
	JTextField aereoField = new JTextField("Inserisci aereo");

	JButton insertButton = new JButton("Inserisci");
	JButton deleteButton = new JButton("Cancella");
	JButton updateButton = new JButton("Aggiorna");
	JButton idButton= new JButton(" Visualizza ID");
	JButton allButton= new JButton("Visualizza tutto");

	JTextArea areaView = new JTextArea("Risultati",25,27);


	VoloFrame(){

		super("Aeroporto");

		ServicesCustomer service = new ServicesCustomer();

		Container c = this.getContentPane();
		c.setLayout(new GridLayout(1,2));

		left.setLayout(new GridLayout(2,1));
		leftN.setLayout(new GridLayout(9,1));
		leftS.setLayout(new GridLayout(5,1));

		leftN.add(codiceVoloField);
		leftN.add(dataPartenzaField);
		leftN.add(dataArrivoField);
		leftN.add(numeroPasseggeriField);
		leftN.add(aeroportoPartenzaField);
		leftN.add(aeroportoArrivoField);
		leftN.add(aereoField);

		leftN.add(new JPanel());

		leftS.add(insertButton);
		leftS.add(deleteButton);
		leftS.add(updateButton);
		leftS.add(idButton);
		leftS.add(allButton);


		insertButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				DateFormat format = new SimpleDateFormat("YYYY-MM-DD");

				int codiceVolo = Integer.parseInt(codiceVoloField.getText());
				String dataPartenzaS = dataPartenzaField.getText();
				String dataArrivoS = dataArrivoField.getText();
				int numeroPasseggeri = Integer.parseInt(numeroPasseggeriField.getText());
				int aeroportoPartenzaId = Integer.parseInt(aeroportoPartenzaField.getText());
				int aeroportoArrivoId = Integer.parseInt(aeroportoArrivoField.getText());
				int aereoId = Integer.parseInt(aereoField.getText());

				java.util.Date dataPartenza= new java.util.Date() ;
				java.util.Date dataArrivo = new java.util.Date();

				try {
					dataPartenza = format.parse(dataPartenzaS);
					dataArrivo = format.parse(dataArrivoS);
					System.out.println(dataPartenza);
					System.out.println(dataArrivo);
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				Aeroporto aeroportoArrivo = service.getAeroportoByPK(aeroportoArrivoId);
				Aeroporto aeroportoPartenza = service.getAeroportoByPK(aeroportoPartenzaId);
				Aereo aereo = service.getAereoByPK(aereoId);

				if(aeroportoArrivo==null) {
					JOptionPane.showMessageDialog(c, "aeroportoArrivo mancante");
				} else if (aeroportoPartenza==null) {
					JOptionPane.showMessageDialog(c, "aeroportoPartenza mancante");
				}else if (aereo==null) {
					JOptionPane.showMessageDialog(c, "aereo mancante");
				} else {
					Volo volo = new Volo(codiceVolo, new Date(dataPartenza.getYear(), dataPartenza.getMonth(), dataPartenza.getDay()), 
							new Date(dataArrivo.getYear(), dataArrivo.getMonth(), dataArrivo.getDay()), numeroPasseggeri, aeroportoPartenza, aeroportoArrivo, aereo);
					boolean flag = service.insertVolo(volo);
					if( flag == true) {
						JOptionPane.showMessageDialog(c, " volo inserito correttamente" );
					} else {
						JOptionPane.showMessageDialog(c, "volo non inserito");
					}
				}
			}
		});

		deleteButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int codiceVolo = Integer.parseInt(codiceVoloField.getText());
				boolean flag = service.deletetVolo(codiceVolo);
				
				if(flag==true) {
					JOptionPane.showMessageDialog(c, "Volo cancellato correttamente" );
				} else {
					JOptionPane.showMessageDialog(c, "Volo non cacellato");
				}

			}
		});

		updateButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				DateFormat format = new SimpleDateFormat("YYYY-MM-DD");
				
				int codiceVolo = Integer.parseInt(codiceVoloField.getText());
				String dataPartenzaS = dataPartenzaField.getText();
				String dataArrivoS = dataArrivoField.getText();
				int numeroPasseggeri = Integer.parseInt(numeroPasseggeriField.getText());
				int aeroportoPartenzaId = Integer.parseInt(aeroportoPartenzaField.getText());
				int aeroportoArrivoId = Integer.parseInt(aeroportoArrivoField.getText());
				int aereoId = Integer.parseInt(aereoField.getText());

				java.util.Date dataPartenza= new java.util.Date() ;
				java.util.Date dataArrivo = new java.util.Date();
				
				try {
					dataPartenza = format.parse(dataPartenzaS);
					dataArrivo = format.parse(dataArrivoS);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				Aeroporto aeroportoArrivo = service.getAeroportoByPK(aeroportoArrivoId);
				Aeroporto aeroportoPartenza = service.getAeroportoByPK(aeroportoPartenzaId);
				Aereo aereo = service.getAereoByPK(aereoId);

				if(aeroportoArrivo==null) {
					JOptionPane.showMessageDialog(c, "aeroportoArrivo mancante");
				} else if (aeroportoPartenza==null) {
					JOptionPane.showMessageDialog(c, "aeroportoPartenza mancante");
				}else if (aereo==null) {
					JOptionPane.showMessageDialog(c, "aereo mancante");
				} else {
					Volo volo = new Volo(codiceVolo, new Date(dataPartenza.getYear(), dataPartenza.getMonth(), dataPartenza.getDay()), 
							new Date(dataArrivo.getYear(), dataArrivo.getMonth(), dataArrivo.getDay()), numeroPasseggeri, aeroportoPartenza, aeroportoArrivo, aereo);
					
					boolean flag = service.upadteVolo(volo, codiceVolo);
					if( flag == true) {
						JOptionPane.showMessageDialog(c, "volo aggiornato correttamente" );
					} else {
						JOptionPane.showMessageDialog(c, "volo mancate");
					}
				}

			}
		});
		idButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int codiceVolo = Integer.parseInt(codiceVoloField.getText());
				Volo volo = service.getVoloByPK(codiceVolo);
				if( volo == null) {
					JOptionPane.showMessageDialog(c, "aereo non trovato");
				} else {

					areaView.setText(volo.toString());
				}
			}
		});
		allButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ArrayList<Volo> lista = service.getVoli();

				if( lista.size() == 0) {
					areaView.setText("nessun aereo presente");
				} else {
					areaView.setText("");
					for (Volo v: lista)
						areaView.append(v.toString() + "\n");
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
