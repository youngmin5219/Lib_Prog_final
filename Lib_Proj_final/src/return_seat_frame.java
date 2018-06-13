import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class return_seat_frame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("");
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
					return_seat_frame frame = new return_seat_frame(clientobj,bookobj,user.name,user.id,user.statusflag, seatobj);
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
	public return_seat_frame(ArrayList<Client> clientobj, ArrayList<Book> bookobj,String name, String id, int statusflag, ArrayList<Seat> seatobj) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(return_seat_frame.class.getResource("/pac/images (1).png")));
		this.clientobj=clientobj;
		this.bookobj=bookobj;
		this.user.name=name;
		this.user.id=id;
		this.user.statusflag=statusflag;
		this.seatobj=seatobj;
		
		setTitle("SKKU Library");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 250, 350, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setOpaque(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag =1000;
				for(int i=0; i<60; i++) {
					if(seatobj.get(i).user_id.equals(user.id)&&seatobj.get(i).user_name.equals(user.name)) {
						flag=i;
					}
				}
				if(flag==1000) {
					Errorframe5 frame = new Errorframe5();
					frame.setVisible(true);
				}
				else {
					seatobj.get(flag).user_id="-";
					seatobj.get(flag).user_name="-";
					dispose();
				}
			}
		});
		btnNewButton.setBounds(36, 91, 132, 60);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("");
		button.setBackground(Color.WHITE);
		button.setOpaque(false);
		button.setBorderPainted(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		button.setBounds(180, 91, 142, 60);
		contentPane.add(button);
		lblNewLabel.setIcon(new ImageIcon(return_seat_frame.class.getResource("/pac/\uBC18\uB0A9\uD655\uC778.png")));
		lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 0, 334, 161);
		contentPane.add(lblNewLabel);
	}
}