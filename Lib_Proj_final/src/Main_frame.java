import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class Main_frame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	
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
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Reader1 reading1= new Reader1();		//client ���� �о studentobj, professorobj�� �����ϴ� reading1
		clientobj = reading1.read();
		
		Reader reading = new Reader();		//å���� �о bookobj�� �����ϴ� reading
		bookobj = reading.read();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_frame frame = new Main_frame(clientobj,bookobj,user.name,user.id,user.statusflag,seatobj);
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
	public Main_frame(ArrayList<Client> clientobj, ArrayList<Book> bookobj,String name, String id, int statusflag, ArrayList<Seat> seatobj) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main_frame.class.getResource("/pac/images (1).png")));
		this.clientobj=clientobj;
		this.bookobj=bookobj;
		this.user.name=name;
		this.user.id=id;
		this.user.statusflag=statusflag;
		this.seatobj=seatobj;
		
		setTitle("SKKU Library");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");		//�α��� â�� ���� ���� ��ư
		buttonGroup_1.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(652, 249, 21, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");		//�α��� â�� �л� ���� ��ư
		buttonGroup_1.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(727, 249, 21, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JButton button = new JButton("");		//�α��� Ȯ�� ��ư
		button.setBackground(Color.WHITE);
		button.setOpaque(false);
		button.setBorderPainted(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //�α��� �Ǹ� �Էµ� �й�, �̸� ������
				String client_name=textField.getText();
				String client_id=textField_1.getText();
				
				int name_flag=0;//����� ��Ͽ� �α��� �õ��� ��� �ִ��� Ȯ��
				for(int i=1; i<clientobj.size(); i++) {
					if(clientobj.get(i).name.matches(client_name)) {
						name_flag=i;		//nameflag�� ����� ���° �ٿ� �ִ� ������� ����
					}
				}
				if(name_flag==0) {//��Ͽ� �ش� ����� ����
					Error_frame frame = new Error_frame();		//����â ���
					frame.setVisible(true);
				}
				else{//�����ϴ� �̸� �α��� �� ���, �̸�,�й� ��ġ�ϴ��� Ȯ��
					if(clientobj.get(name_flag).id.matches(client_id)) {
					}
					else {//�ٸ���� ����â ���
						Error_frame frame = new Error_frame();
						frame.setVisible(true);
					}
					
					if(rdbtnNewRadioButton.isSelected()&&(clientobj.get(name_flag).statusflag==1)) {
						user.name=client_name;
						user.id=client_id;
						frame frame5 = new frame(clientobj,bookobj,user.name,user.id,user.statusflag,seatobj);
						frame5.setVisible(true);
					}
					
					else if(rdbtnNewRadioButton_1.isSelected()&&(clientobj.get(name_flag).statusflag==0)) {
						user.name=client_name;
						user.id=client_id;
						frame frame5 = new frame(clientobj,bookobj,user.name,user.id,user.statusflag,seatobj);
						frame5.setVisible(true);
					}
					else {//����,�л� ���� ���Ѱ�� ����â ���
						Error_frame frame = new Error_frame();
						frame.setVisible(true);
					}
				}
				
			}
		});
		button.setBounds(727, 187, 52, 37);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setBounds(628, 172, 97, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(628, 211, 97, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Main_frame.class.getResource("/pac/\uB85C\uADF8\uC778.PNG")));
		lblNewLabel_2.setBounds(0, 0, 791, 415);
		contentPane.add(lblNewLabel_2);
	}
}


