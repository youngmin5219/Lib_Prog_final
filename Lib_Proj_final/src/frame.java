import java.util.ArrayList;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class frame extends JFrame{

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
	public static ArrayList<Seat> seatobj = new ArrayList<Seat>();//좌석의 배정 상태를 저장함
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
					frame frame = new frame(clientobj,bookobj,user.name,user.id,user.statusflag,seatobj);
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
	public frame(ArrayList<Client> clientobj, ArrayList<Book> bookobj,String name, String id, int statusflag, ArrayList<Seat> seatobj) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(frame.class.getResource("/pac/images (1).png")));
		this.clientobj=clientobj;
		this.bookobj=bookobj;
		this.user.name=name;
		this.user.id=id;
		this.user.statusflag=statusflag;
		this.seatobj=seatobj;

		setTitle("SKKU Library");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 980, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");//로그아웃 버튼
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setOpaque(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Main_frame frame = new Main_frame(clientobj,bookobj,user.name,user.id,user.statusflag,seatobj);
				frame.setVisible(true);	
				/*
				frame.setclientobj(clientobj);
				frame.setbookobj(bookobj);
				frame.setuser(user.name, user.id, user.statusflag);
				*/
			}
		});
		
		JLabel lblNewLabel = new JLabel(user.name);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBounds(737, 46, 71, 21);
		contentPane.add(lblNewLabel);
		btnNewButton.setBounds(871, 21, 93, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");//도서 검색창으로 이동하는 버튼
		btnNewButton_1.setFont(new Font("휴먼편지체", Font.BOLD, 30));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search_frame frame = new search_frame(clientobj,bookobj,user.name,user.id,user.statusflag,seatobj);
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(717, 121, 247, 84);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");//도서 반납창으로 이동하는 버튼
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Return_frame frame = new Return_frame(clientobj,bookobj,user.name,user.id,user.statusflag,seatobj);
				frame.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("휴먼편지체", Font.BOLD, 30));
		btnNewButton_2.setIcon(null);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(717, 212, 247, 84);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");//좌석 반납창으로 이동하는 버튼
		btnNewButton_3.setOpaque(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				return_seat_frame frame = new return_seat_frame(clientobj,bookobj,user.name,user.id,user.statusflag,seatobj);
				frame.setVisible(true);

			}
		});
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setFont(new Font("휴먼편지체", Font.BOLD, 28));
		btnNewButton_3.setBounds(717, 409, 247, 84);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");//좌석 배정창으로 이동하는 버튼
		btnNewButton_4.setOpaque(false);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seat_frame frame = new seat_frame(clientobj,bookobj,user.name,user.id,user.statusflag,seatobj);
				frame.setVisible(true);
			}
		});
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setFont(new Font("휴먼편지체", Font.BOLD, 28));
		btnNewButton_4.setBounds(717, 315, 247, 84);
		contentPane.add(btnNewButton_4);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(frame.class.getResource("/pac/\uD504\uB808\uC784.png")));
		label.setBounds(0, 0, 964, 512);
		contentPane.add(label);
	}
}
