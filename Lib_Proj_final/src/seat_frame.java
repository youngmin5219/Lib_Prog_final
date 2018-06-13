import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class seat_frame extends JFrame {

	private JPanel contentPane;
	public static ArrayList<Client> clientobj = new ArrayList<Client>();
	public static ArrayList<Book> bookobj = new ArrayList<Book>();
	public void setclientobj(ArrayList<Client> clientobj) {
		this.clientobj = clientobj;
	}
	public static ArrayList<Client> getclientobj() {
		return clientobj;
	}
	public void setbookobj(ArrayList<Book> bookobj) {
		this.bookobj = bookobj;
	}
	public static ArrayList<Book> getbookobj() {
		return bookobj;
	}
	public static Client user = new Client();
	public void setuser(String name, String studentid, int statusflag) {
		this.user.name=name;
		this.user.id=studentid;
		this.user.statusflag=statusflag;
	}
	public static Client getuser() {
		return user;
	}
	public static ArrayList<Seat> seatobj = new ArrayList<Seat>();
	public void setseatobj(ArrayList<Seat> seatobj) {
		this.seatobj = seatobj;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					seat_frame frame = new seat_frame(clientobj,bookobj,user.name,user.id,user.statusflag,seatobj);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public seat_frame(ArrayList<Client> clientobj, ArrayList<Book> bookobj,String name, String id, int statusflag, ArrayList<Seat> seatobj) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(seat_frame.class.getResource("/pac/images (1).png")));
		this.clientobj=clientobj;
		this.bookobj=bookobj;
		this.user.name=name;
		this.user.id=id;
		this.user.statusflag=statusflag;
		this.seatobj=seatobj;
		
		for(int i=0; i<60; i++) {//좌석 정보 초기화
			Seat seat = new Seat(Integer.toString(i),"-","-");
			seatobj.add(seat);
		}
		
		int emptyseat=0;
		for(int i=0; i<60; i++) {
			if(seatobj.get(i).user_id.equals("-")) {
				emptyseat++;
			}
		}
		setTitle("SKKU Library");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1120, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("1");
		if(!seatobj.get(0).user_id.equals("-")) {		//좌석이 발권되어있는 경우 버튼 안눌리게 설정
			btnNewButton.setEnabled(false);
		}
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(0).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(0).user_id=user.id;
							seatobj.get(0).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							btnNewButton.setEnabled(false);
						}
				}	
			}
		});
		btnNewButton.setBounds(12, 64, 74, 83);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("2");
		if(!seatobj.get(1).user_id.equals("-")) {
			button.setEnabled(false);
		}
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(1).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(1).user_id=user.id;
							seatobj.get(1).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button.setEnabled(false);
						}
				}	
			}
		});
		button.setBounds(12, 145, 74, 83);
		contentPane.add(button);
		
		JButton button_1 = new JButton("3");
		if(!seatobj.get(2).user_id.equals("-")) {
			button_1.setEnabled(false);
		}
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(2).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(2).user_id=user.id;
							seatobj.get(2).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_1.setEnabled(false);
						}
				}	
			}
		});
		button_1.setBounds(12, 226, 74, 83);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("4");
		if(!seatobj.get(3).user_id.equals("-")) {
			button_2.setEnabled(false);
		}
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(3).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(3).user_id=user.id;
							seatobj.get(3).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_2.setEnabled(false);
						}
				}	
			}
		});
		button_2.setBounds(12, 308, 74, 83);
		contentPane.add(button_2);
		
		
		
		
		
		JButton button_3 = new JButton("5");
		if(!seatobj.get(4).user_id.equals("-")) {
			button_3.setEnabled(false);
		}
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(4).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(4).user_id=user.id;
							seatobj.get(4).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_3.setEnabled(false);
						}
				}	
			}
		});
		button_3.setBounds(12, 390, 74, 83);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("6");
		if(!seatobj.get(5).user_id.equals("-")) {
			button_4.setEnabled(false);
		}
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(5).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(5).user_id=user.id;
							seatobj.get(5).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_4.setEnabled(false);
						}
				}	
			}
		});
		button_4.setBounds(87, 63, 74, 83);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("7");
		if(!seatobj.get(6).user_id.equals("-")) {
			button_5.setEnabled(false);
		}
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(6).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(6).user_id=user.id;
							seatobj.get(6).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_5.setEnabled(false);
						}
				}	
			}
		});
		button_5.setBounds(87, 144, 74, 83);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("8");
		if(!seatobj.get(7).user_id.equals("-")) {
			button_6.setEnabled(false);
		}
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(7).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(7).user_id=user.id;
							seatobj.get(7).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_6.setEnabled(false);
						}
				}	
			}
		});
		button_6.setBounds(87, 225, 74, 83);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("9");
		if(!seatobj.get(8).user_id.equals("-")) {
			button_7.setEnabled(false);
		}
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(8).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(8).user_id=user.id;
							seatobj.get(8).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_7.setEnabled(false);
						}
				}	
			}
		});
		button_7.setBounds(87, 307, 74, 83);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("10");
		if(!seatobj.get(9).user_id.equals("-")) {
			button_8.setEnabled(false);
		}
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(9).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(9).user_id=user.id;
							seatobj.get(9).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_8.setEnabled(false);
						}
				}	
			}
		});
		button_8.setBounds(87, 389, 74, 83);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("11");
		if(!seatobj.get(10).user_id.equals("-")) {
			button_9.setEnabled(false);
		}
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(10).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(10).user_id=user.id;
							seatobj.get(10).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_9.setEnabled(false);
						}
				}	
			}
		});
		button_9.setBounds(195, 63, 74, 83);
		contentPane.add(button_9);
		
		JButton button_10 = new JButton("12");
		if(!seatobj.get(11).user_id.equals("-")) {
			button_10.setEnabled(false);
		}
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(11).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(11).user_id=user.id;
							seatobj.get(11).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_10.setEnabled(false);
						}
				}	
			}
		});
		button_10.setBounds(195, 144, 74, 83);
		contentPane.add(button_10);
		
		JButton button_11 = new JButton("13");
		if(!seatobj.get(12).user_id.equals("-")) {
			button_11.setEnabled(false);
		}
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(12).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(12).user_id=user.id;
							seatobj.get(12).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_11.setEnabled(false);
						}
				}	
			}
		});
		button_11.setBounds(195, 225, 74, 83);
		contentPane.add(button_11);
		
		JButton button_12 = new JButton("14");
		if(!seatobj.get(13).user_id.equals("-")) {
			button_12.setEnabled(false);
		}
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(13).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(13).user_id=user.id;
							seatobj.get(13).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_12.setEnabled(false);
						}
				}	
			}
		});
		button_12.setBounds(195, 307, 74, 83);
		contentPane.add(button_12);
		
		JButton button_13 = new JButton("15");
		if(!seatobj.get(14).user_id.equals("-")) {
			button_13.setEnabled(false);
		}
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(14).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(14).user_id=user.id;
							seatobj.get(14).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_13.setEnabled(false);
						}
				}	
			}
		});
		button_13.setBounds(195, 389, 74, 83);
		contentPane.add(button_13);
		
		JButton button_14 = new JButton("16");
		if(!seatobj.get(15).user_id.equals("-")) {
			button_14.setEnabled(false);
		}
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(15).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(15).user_id=user.id;
							seatobj.get(15).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_14.setEnabled(false);
						}
				}	
			}
		});
		button_14.setBounds(267, 64, 74, 83);
		contentPane.add(button_14);
		
		JButton button_15 = new JButton("17");
		if(!seatobj.get(16).user_id.equals("-")) {
			button_15.setEnabled(false);
		}
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(16).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(16).user_id=user.id;
							seatobj.get(16).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_15.setEnabled(false);
						}
				}	
			}
		});
		button_15.setBounds(267, 145, 74, 83);
		contentPane.add(button_15);
		
		JButton button_16 = new JButton("18");
		if(!seatobj.get(17).user_id.equals("-")) {
			button_16.setEnabled(false);
		}
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(17).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(17).user_id=user.id;
							seatobj.get(17).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_16.setEnabled(false);
						}
				}	
			}
		});
		button_16.setBounds(267, 226, 74, 83);
		contentPane.add(button_16);
		
		JButton button_17 = new JButton("19");
		if(!seatobj.get(18).user_id.equals("-")) {
			button_17.setEnabled(false);
		}
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(18).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(18).user_id=user.id;
							seatobj.get(18).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_17.setEnabled(false);
						}
				}	
			}
		});
		button_17.setBounds(267, 308, 74, 83);
		contentPane.add(button_17);
		
		JButton button_18 = new JButton("20");
		if(!seatobj.get(19).user_id.equals("-")) {
			button_18.setEnabled(false);
		}
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(19).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(19).user_id=user.id;
							seatobj.get(19).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_18.setEnabled(false);
						}
				}	
			}
		});
		button_18.setBounds(267, 390, 74, 83);
		contentPane.add(button_18);
		
		JButton button_19 = new JButton("21");
		if(!seatobj.get(20).user_id.equals("-")) {
			button_19.setEnabled(false);
		}
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(20).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(20).user_id=user.id;
							seatobj.get(20).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_19.setEnabled(false);
						}
				}	
			}
		});
		button_19.setBounds(371, 64, 74, 83);
		contentPane.add(button_19);
		
		JButton button_20 = new JButton("22");
		if(!seatobj.get(21).user_id.equals("-")) {
			button_20.setEnabled(false);
		}
		button_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(21).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(21).user_id=user.id;
							seatobj.get(21).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_20.setEnabled(false);
						}
				}	
			}
		});
		button_20.setBounds(371, 145, 74, 83);
		contentPane.add(button_20);
		
		JButton button_21 = new JButton("23");
		if(!seatobj.get(22).user_id.equals("-")) {
			button_21.setEnabled(false);
		}
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(22).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(22).user_id=user.id;
							seatobj.get(22).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_21.setEnabled(false);
						}
				}	
			}
		});
		button_21.setBounds(371, 226, 74, 83);
		contentPane.add(button_21);
		
		JButton button_22 = new JButton("24");
		if(!seatobj.get(23).user_id.equals("-")) {
			button_22.setEnabled(false);
		}
		button_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(23).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(23).user_id=user.id;
							seatobj.get(23).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_22.setEnabled(false);
						}
				}	
			}
		});
		button_22.setBounds(371, 308, 74, 83);
		contentPane.add(button_22);
		
		JButton button_23 = new JButton("25");
		if(!seatobj.get(24).user_id.equals("-")) {
			button_23.setEnabled(false);
		}
		button_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(24).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(24).user_id=user.id;
							seatobj.get(24).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_23.setEnabled(false);
						}
				}	
			}
		});
		button_23.setBounds(371, 390, 74, 83);
		contentPane.add(button_23);
		
		JButton button_24 = new JButton("26");
		if(!seatobj.get(25).user_id.equals("-")) {
			button_24.setEnabled(false);
		}
		button_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(25).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(25).user_id=user.id;
							seatobj.get(25).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_24.setEnabled(false);
						}
				}	
			}
		});
		button_24.setBounds(444, 64, 74, 83);
		contentPane.add(button_24);
		
		JButton button_25 = new JButton("27");
		if(!seatobj.get(26).user_id.equals("-")) {
			button_25.setEnabled(false);
		}
		button_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(26).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(26).user_id=user.id;
							seatobj.get(26).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_25.setEnabled(false);
						}
				}	
			}
		});
		button_25.setBounds(444, 145, 74, 83);
		contentPane.add(button_25);
		
		JButton button_26 = new JButton("28");
		if(!seatobj.get(27).user_id.equals("-")) {
			button_26.setEnabled(false);
		}
		button_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(27).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(27).user_id=user.id;
							seatobj.get(27).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_26.setEnabled(false);
						}
				}	
			}
		});
		button_26.setBounds(444, 226, 74, 83);
		contentPane.add(button_26);
		
		JButton button_27 = new JButton("29");
		if(!seatobj.get(28).user_id.equals("-")) {
			button_27.setEnabled(false);
		}
		button_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(28).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(28).user_id=user.id;
							seatobj.get(28).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_27.setEnabled(false);
						}
				}	
			}
		});
		button_27.setBounds(444, 308, 74, 83);
		contentPane.add(button_27);
		
		JButton button_28 = new JButton("30");
		if(!seatobj.get(29).user_id.equals("-")) {
			button_28.setEnabled(false);
		}
		button_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(29).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(29).user_id=user.id;
							seatobj.get(29).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_28.setEnabled(false);
						}
				}	
			}
		});
		button_28.setBounds(444, 390, 74, 83);
		contentPane.add(button_28);
		
		JButton button_29 = new JButton("31");
		if(!seatobj.get(30).user_id.equals("-")) {
			button_29.setEnabled(false);
		}
		button_29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(30).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(30).user_id=user.id;
							seatobj.get(30).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_29.setEnabled(false);
						}
				}	
			}
		});
		button_29.setBounds(557, 64, 74, 83);
		contentPane.add(button_29);
		
		JButton button_30 = new JButton("32");
		if(!seatobj.get(31).user_id.equals("-")) {
			button_30.setEnabled(false);
		}
		button_30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(31).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(31).user_id=user.id;
							seatobj.get(31).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_30.setEnabled(false);
						}
				}	
			}
		});
		button_30.setBounds(557, 145, 74, 83);
		contentPane.add(button_30);
		
		JButton button_31 = new JButton("33");
		if(!seatobj.get(32).user_id.equals("-")) {
			button_31.setEnabled(false);
		}
		button_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(32).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(32).user_id=user.id;
							seatobj.get(32).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_31.setEnabled(false);
						}
				}	
			}
		});
		button_31.setBounds(557, 226, 74, 83);
		contentPane.add(button_31);
		
		JButton button_32 = new JButton("34");
		if(!seatobj.get(33).user_id.equals("-")) {
			button_32.setEnabled(false);
		}
		button_32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(33).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(33).user_id=user.id;
							seatobj.get(33).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_32.setEnabled(false);
						}
				}	
			}
		});
		button_32.setBounds(557, 308, 74, 83);
		contentPane.add(button_32);
		
		JButton button_33 = new JButton("35");
		if(!seatobj.get(34).user_id.equals("-")) {
			button_33.setEnabled(false);
		}
		button_33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(34).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(34).user_id=user.id;
							seatobj.get(34).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_33.setEnabled(false);
						}
				}	
			}
		});
		button_33.setBounds(557, 390, 74, 83);
		contentPane.add(button_33);
		
		JButton button_34 = new JButton("36");
		if(!seatobj.get(35).user_id.equals("-")) {
			button_34.setEnabled(false);
		}
		button_34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(35).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(35).user_id=user.id;
							seatobj.get(35).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_34.setEnabled(false);
						}
				}	
			}
		});
		button_34.setBounds(631, 64, 74, 83);
		contentPane.add(button_34);
		
		JButton button_35 = new JButton("37");
		if(!seatobj.get(36).user_id.equals("-")) {
			button_35.setEnabled(false);
		}
		button_35.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(36).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(36).user_id=user.id;
							seatobj.get(36).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_35.setEnabled(false);
						}
				}	
			}
		});
		button_35.setBounds(631, 145, 74, 83);
		contentPane.add(button_35);
		
		JButton button_36 = new JButton("38");
		if(!seatobj.get(37).user_id.equals("-")) {
			button_36.setEnabled(false);
		}
		button_36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(37).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(37).user_id=user.id;
							seatobj.get(37).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_36.setEnabled(false);
						}
				}	
			}
		});
		button_36.setBounds(631, 226, 74, 83);
		contentPane.add(button_36);
		
		JButton button_37 = new JButton("39");
		if(!seatobj.get(38).user_id.equals("-")) {
			button_37.setEnabled(false);
		}
		button_37.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(38).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(38).user_id=user.id;
							seatobj.get(38).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_37.setEnabled(false);
						}
				}	
			}
		});
		button_37.setBounds(631, 308, 74, 83);
		contentPane.add(button_37);
		
		JButton button_38 = new JButton("40");
		if(!seatobj.get(39).user_id.equals("-")) {
			button_38.setEnabled(false);
		}
		button_38.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(39).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(39).user_id=user.id;
							seatobj.get(39).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_38.setEnabled(false);
						}
				}	
			}
		});
		button_38.setBounds(631, 390, 74, 83);
		contentPane.add(button_38);
		
		JButton button_39 = new JButton("41");
		if(!seatobj.get(40).user_id.equals("-")) {
			button_39.setEnabled(false);
		}
		button_39.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(40).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(40).user_id=user.id;
							seatobj.get(40).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_39.setEnabled(false);
						}
				}	
			}
		});
		button_39.setBounds(744, 64, 74, 83);
		contentPane.add(button_39);
		
		JButton button_40 = new JButton("42");
		if(!seatobj.get(41).user_id.equals("-")) {
			button_40.setEnabled(false);
		}
		button_40.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(41).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(41).user_id=user.id;
							seatobj.get(41).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_40.setEnabled(false);
						}
				}	
			}
		});
		button_40.setBounds(744, 145, 74, 83);
		contentPane.add(button_40);
		
		JButton button_41 = new JButton("43");
		if(!seatobj.get(42).user_id.equals("-")) {
			button_41.setEnabled(false);
		}
		button_41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(42).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(42).user_id=user.id;
							seatobj.get(42).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_41.setEnabled(false);
						}
				}	
			}
		});
		button_41.setBounds(744, 226, 74, 83);
		contentPane.add(button_41);
		
		JButton button_42 = new JButton("44");
		if(!seatobj.get(43).user_id.equals("-")) {
			button_42.setEnabled(false);
		}
		button_42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(43).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(43).user_id=user.id;
							seatobj.get(43).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_42.setEnabled(false);
						}
				}	
			}
		});
		button_42.setBounds(744, 308, 74, 83);
		contentPane.add(button_42);
		
		JButton button_43 = new JButton("45");
		if(!seatobj.get(44).user_id.equals("-")) {
			button_43.setEnabled(false);
		}
		button_43.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(44).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(44).user_id=user.id;
							seatobj.get(44).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_43.setEnabled(false);
						}
				}	
			}
		});
		button_43.setBounds(744, 390, 74, 83);
		contentPane.add(button_43);
		
		JButton button_44 = new JButton("46");
		if(!seatobj.get(45).user_id.equals("-")) {
			button_44.setEnabled(false);
		}
		button_44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(45).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(45).user_id=user.id;
							seatobj.get(45).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_44.setEnabled(false);
						}
				}	
			}
		});
		button_44.setBounds(817, 64, 74, 83);
		contentPane.add(button_44);
		
		JButton button_45 = new JButton("47");
		if(!seatobj.get(46).user_id.equals("-")) {
			button_45.setEnabled(false);
		}
		button_45.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(46).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(46).user_id=user.id;
							seatobj.get(46).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_45.setEnabled(false);
						}
				}	
			}
		});
		button_45.setBounds(817, 145, 74, 83);
		contentPane.add(button_45);
		
		JButton button_46 = new JButton("48");
		if(!seatobj.get(47).user_id.equals("-")) {
			button_46.setEnabled(false);
		}
		button_46.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(47).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(47).user_id=user.id;
							seatobj.get(47).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_46.setEnabled(false);
						}
				}	
			}
		});
		button_46.setBounds(817, 226, 74, 83);
		contentPane.add(button_46);
		
		JButton button_47 = new JButton("49");
		if(!seatobj.get(48).user_id.equals("-")) {
			button_47.setEnabled(false);
		}
		button_47.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(48).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(48).user_id=user.id;
							seatobj.get(48).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_47.setEnabled(false);
						}
				}	
			}
		});
		button_47.setBounds(817, 308, 74, 83);
		contentPane.add(button_47);
		
		JButton button_48 = new JButton("50");
		if(!seatobj.get(49).user_id.equals("-")) {
			button_48.setEnabled(false);
		}
		button_48.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(49).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(49).user_id=user.id;
							seatobj.get(49).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_48.setEnabled(false);
						}
				}	
			}
		});
		button_48.setBounds(817, 390, 74, 83);
		contentPane.add(button_48);
		
		JButton button_49 = new JButton("51");
		if(!seatobj.get(50).user_id.equals("-")) {
			button_49.setEnabled(false);
		}
		button_49.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(50).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(50).user_id=user.id;
							seatobj.get(50).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_49.setEnabled(false);
						}
				}	
			}
		});
		button_49.setBounds(943, 64, 74, 83);
		contentPane.add(button_49);
		
		JButton button_50 = new JButton("52");
		if(!seatobj.get(51).user_id.equals("-")) {
			button_50.setEnabled(false);
		}
		button_50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(51).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(51).user_id=user.id;
							seatobj.get(51).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_50.setEnabled(false);
						}
				}	
			}
		});
		button_50.setBounds(943, 145, 74, 83);
		contentPane.add(button_50);
		
		JButton button_51 = new JButton("53");
		if(!seatobj.get(52).user_id.equals("-")) {
			button_51.setEnabled(false);
		}
		button_51.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(52).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(52).user_id=user.id;
							seatobj.get(52).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_51.setEnabled(false);
						}
				}	
			}
		});
		button_51.setBounds(943, 226, 74, 83);
		contentPane.add(button_51);
		
		JButton button_52 = new JButton("54");
		if(!seatobj.get(53).user_id.equals("-")) {
			button_52.setEnabled(false);
		}
		button_52.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(53).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(53).user_id=user.id;
							seatobj.get(53).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_52.setEnabled(false);
						}
				}	
			}
		});
		button_52.setBounds(943, 308, 74, 83);
		contentPane.add(button_52);
		
		JButton button_53 = new JButton("55");
		if(!seatobj.get(54).user_id.equals("-")) {
			button_53.setEnabled(false);
		}
		button_53.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(54).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(54).user_id=user.id;
							seatobj.get(54).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_53.setEnabled(false);
						}
				}	
			}
		});
		button_53.setBounds(943, 390, 74, 83);
		contentPane.add(button_53);
		
		JButton button_54 = new JButton("56");
		if(!seatobj.get(55).user_id.equals("-")) {
			button_54.setEnabled(false);
		}
		button_54.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(55).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(55).user_id=user.id;
							seatobj.get(55).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_54.setEnabled(false);
						}
				}	
			}
		});
		button_54.setBounds(1016, 64, 74, 83);
		contentPane.add(button_54);
		
		JButton button_55 = new JButton("57");
		if(!seatobj.get(56).user_id.equals("-")) {
			button_55.setEnabled(false);
		}
		button_55.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(56).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(56).user_id=user.id;
							seatobj.get(56).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_55.setEnabled(false);
						}
				}	
			}
		});
		button_55.setBounds(1016, 145, 74, 83);
		contentPane.add(button_55);
		
		JButton button_56 = new JButton("58");
		if(!seatobj.get(57).user_id.equals("-")) {
			button_56.setEnabled(false);
		}
		button_56.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(57).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(57).user_id=user.id;
							seatobj.get(57).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_56.setEnabled(false);
						}
				}	
			}
		});
		button_56.setBounds(1016, 226, 74, 83);
		contentPane.add(button_56);
		
		JButton button_57 = new JButton("59");
		if(!seatobj.get(58).user_id.equals("-")) {
			button_57.setEnabled(false);
		}
		button_57.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(58).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(58).user_id=user.id;
							seatobj.get(58).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_57.setEnabled(false);
						}
				}	
			}
		});
		button_57.setBounds(1016, 308, 74, 83);
		contentPane.add(button_57);
		
		JButton button_58 = new JButton("60");
		if(!seatobj.get(59).user_id.equals("-")) {
			button_58.setEnabled(false);
		}
		button_58.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int flag=0;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						Errorframe3 frame = new Errorframe3();
						frame.setVisible(true);
						flag=1;
					}	
				}
				if(flag==0) {
						if(!seatobj.get(59).user_id.equals("-")) {
							Errorframe4 frame= new Errorframe4();
							frame.setVisible(true);
						}
						else {
							seatobj.get(59).user_id=user.id;
							seatobj.get(59).user_name=user.name;
							Seatlendframe frame = new Seatlendframe();
							frame.setVisible(true);
							button_58.setEnabled(false);
						}
				}	
			}
		});
		button_58.setBounds(1016, 390, 74, 83);
		contentPane.add(button_58);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(seat_frame.class.getResource("/pac/seat.png")));
		lblNewLabel_2.setBackground(new Color(240, 240, 240));
		lblNewLabel_2.setBounds(0, 0, 1104, 481);
		contentPane.add(lblNewLabel_2);
	}
}