import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class Return_frame extends JFrame {

	private JPanel contentPane;
	public static ArrayList<Client> clientobj = new ArrayList<Client>();
	public static ArrayList<Book> bookobj = new ArrayList<Book>();
	public void setclientobj(ArrayList<Client> clientobj) {
		frame.clientobj = clientobj;
	}
	public static ArrayList<Client> getclientobj() {
		return clientobj;
	}
	public void setbookobj(ArrayList<Book> bookobj) {
		frame.bookobj = bookobj;
	}
	public static ArrayList<Book> getbookobj() {
		return bookobj;
	}
	public static Client user = new Client();
	public void setuser(String name, String studentid, int statusflag) {//�α��� �� ����� ������ ����� ������ ó��
		this.user.name=name;
		this.user.id=studentid;
		this.user.statusflag=statusflag;
	}
	public static Client getuser() {
		return user;
	}
	public static ArrayList<Seat> seatobj = new ArrayList<Seat>();	//�¼� ���� ������ ������ �迭
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
					search_frame frame = new search_frame(clientobj,bookobj,user.name,user.id,user.statusflag,seatobj);
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
	public Return_frame(ArrayList<Client> clientobj, ArrayList<Book> bookobj,String name, String id, int statusflag, ArrayList<Seat> seatobj) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Return_frame.class.getResource("/pac/images (1).png")));
		this.clientobj=clientobj;
		this.bookobj=bookobj;
		this.user.name=name;
		this.user.id=id;
		this.user.statusflag=statusflag;
		this.seatobj=seatobj;
		
		setTitle("SKKU Library");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String category2[] = {"����", "����", "���ǻ�", "û����ȣ", "�뿩��Ȳ"};
		DefaultTableModel model2 = new DefaultTableModel(category2, 30);	
		
		//button �ݺ������� å �Ǽ���ŭ �����(button���� �̷���� ��̷�. button[0], button[1], button[2], button[3] ���)
		JTable personTable = new JTable(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
					"\uC81C\uBAA9", "\uC800\uC790\r","\uCD9C\uD310\uC0AC\r" ,"\uCCAD\uAD6C\uAE30\uD638\r", "\uB300\uC5EC\uC0C1\uD669\r"
			}
		));

		JScrollPane tbl_sp2 = new JScrollPane(personTable);
		tbl_sp2.setToolTipText("");
		tbl_sp2.setBounds(12, 59, 1026, 445);
		contentPane.add(tbl_sp2);
		
		JButton btnNewButton_1 = new JButton("");		//�ݳ� ��ư
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int book = personTable.getSelectedRow();		//���°�� �����ߴ��� ��Ÿ���� ����
				for(int i=1; i<bookobj.size(); i++) {
					if((personTable.getValueAt(personTable.getSelectedRow(), 3)).equals(bookobj.get(i).location)){
						if(bookobj.get(i).lender.equals(user.name)&&bookobj.get(i).lenderid.equals(user.id)) {
							returncheckframe frame = new returncheckframe(clientobj,bookobj,user.name,user.id,user.statusflag);
							frame.setVisible(true);
							bookobj.get(i).lender="-";	//�뿩�� ���� �ʱ�ȭ
							bookobj.get(i).lenderid="-";
						}
					}
				}
				DefaultTableModel model = (DefaultTableModel) personTable.getModel();
			      model.setRowCount(0);
			      for(int i=1; i<bookobj.size(); i++) {
			    	  if(bookobj.get(i).lender.equals(user.name)&&bookobj.get(i).lenderid.equals(user.id)) {
			    		 model.addRow(new String[] {(String)bookobj.get(i).title, bookobj.get(i).author, bookobj.get(i).publisher, bookobj.get(i).location, bookobj.get(i).lender});
			      }
			      }
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.BOLD, 13));
		btnNewButton_1.setBounds(1050, 239, 134, 40);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Return_frame.class.getResource("/pac/returnframe.png")));
		lblNewLabel.setBounds(0, 0, 1184, 511);
		contentPane.add(lblNewLabel);
		
		DefaultTableModel model = (DefaultTableModel) personTable.getModel();
	    model.setRowCount(0);
	      
	    for(int i=1; i<bookobj.size(); i++) {
				if(bookobj.get(i).lender.equals(user.name)&&bookobj.get(i).lenderid.equals(user.id)) {
					 model.addRow(new String[] {(String)bookobj.get(i).title, bookobj.get(i).author, bookobj.get(i).publisher, bookobj.get(i).location, bookobj.get(i).lender});
			}
	      }
	}
}