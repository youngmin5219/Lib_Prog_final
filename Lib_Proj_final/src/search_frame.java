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
import javax.swing.RowFilter;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;

public class search_frame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
	public search_frame(ArrayList<Client> clientobj, ArrayList<Book> bookobj,String name, String id, int statusflag, ArrayList<Seat> seatobj) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(search_frame.class.getResource("/pac/images (1).png")));
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
		
		JComboBox comboBox = new JComboBox();	//�˻���� ����(����, ����, ���ǻ�)
		comboBox.setFont(new Font("����", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uB3C4\uC11C\uBA85", "\uC800\uC790", "\uCD9C\uD310\uC0AC"}));
		comboBox.setBounds(226, 17, 77, 32);
		contentPane.add(comboBox);
		
		textField = new JTextField();//�˻�â
		textField.setFont(new Font("����", Font.PLAIN, 13));
		textField.setBounds(315, 17, 640, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		String category2[] = {"����", "����", "���ǻ�", "û����ȣ", "�뿩��Ȳ"};//�˻������ ������ �� å�� ���� ������ �뿩 ��Ȳ
		DefaultTableModel model2 = new DefaultTableModel(category2, 1000);
		
		//button �ݺ������� å �Ǽ���ŭ �����(button���� �̷���� ��̷�. button[0], button[1], button[2], button[3] ���)
		
		
		
		String[][] Object = new String[bookobj.size()][5];
		for(int i=1; i<bookobj.size(); i++) {
			Object[i-1][0]=bookobj.get(i).title;
			Object[i-1][1]=bookobj.get(i).author;
			Object[i-1][2]=bookobj.get(i).publisher;
			Object[i-1][3]=bookobj.get(i).location;
			Object[i-1][4]=bookobj.get(i).lender;
		}
		

		JTable personTable = new JTable(new DefaultTableModel(
				Object,
				new String[] {"\uC81C\uBAA9", "\uC800\uC790\r", "\uCD9C\uD310\uC0AC\r", "\uCCAD\uAD6C\uAE30\uD638\r", "\uB300\uC5EC\uC0C1\uD669\r"
				}
				));
		
		JScrollPane tbl_sp2 = new JScrollPane(personTable);
		tbl_sp2.setToolTipText("");
		tbl_sp2.setBounds(12, 59, 1037, 445);
		contentPane.add(tbl_sp2);		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tbl_sp2.setColumnHeaderView(lblNewLabel);
		lblNewLabel.setIcon(null);
		
		
		
		JButton btnNewButton = new JButton("");		//�뿩 ��ư
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setOpaque(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int book = personTable.getSelectedRow();		//���°�� �����ߴ��� ��Ÿ���� ����
				for(int i=1; i<bookobj.size(); i++) {
					if((personTable.getValueAt(personTable.getSelectedRow(), 3)).equals(bookobj.get(i).location)&&(personTable.getValueAt(personTable.getSelectedRow(), 0)).equals(bookobj.get(i).title)){
						if(bookobj.get(i).lender.equals("-")){//�뿩�� ������ ����ִ�->�뿩����->�뿩�� ���� ������Ʈ
							bookobj.get(i).lender=user.name;
							bookobj.get(i).lenderid=user.id;
							borrowcheckframe frame = new borrowcheckframe(clientobj,bookobj,user.name,user.id,user.statusflag,seatobj);
							frame.setVisible(true);
						}	
					}
				}
				DefaultTableModel model = (DefaultTableModel) personTable.getModel();
			      model.setRowCount(0);
			      for(int i=1; i<bookobj.size(); i++) {
			    		 model.addRow(new String[] {(String)bookobj.get(i).title, bookobj.get(i).author, bookobj.get(i).publisher, bookobj.get(i).location, bookobj.get(i).lender});
			      }
			}
		});
		btnNewButton.setFont(new Font("����", Font.BOLD, 13));
		btnNewButton.setBounds(1065, 223, 119, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");		//�ݳ� ��ư
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int book = personTable.getSelectedRow();//���°�� �����ߴ��� ��Ÿ���� ����
				int flag =1;
				for(int i=1; i<bookobj.size(); i++) {
					if((personTable.getValueAt(personTable.getSelectedRow(), 3)).equals(bookobj.get(i).location)){
						if(bookobj.get(i).lender.equals(user.name)&&bookobj.get(i).lenderid.equals(user.id)) {
							returncheckframe frame = new returncheckframe(clientobj,bookobj,user.name,user.id,user.statusflag);
							frame.setVisible(true);
							bookobj.get(i).lender="-";		//�ݳ��Ǿ����Ƿ� ���� �ʱ�ȭ
							bookobj.get(i).lenderid="-";
							flag=0;
						}
					}
				}
				if(flag==1) {		//�ݳ��Ϸ��� ����� å�� ������ �������
					Errorframe2 frame = new Errorframe2();	//����â
					frame.setVisible(true);
				}
				DefaultTableModel model = (DefaultTableModel) personTable.getModel();
			      model.setRowCount(0);
			      for(int i=1; i<bookobj.size(); i++) {
			    		 model.addRow(new String[] {(String)bookobj.get(i).title, bookobj.get(i).author, bookobj.get(i).publisher, bookobj.get(i).location, bookobj.get(i).lender});
			      }
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.BOLD, 13));
		btnNewButton_1.setBounds(1065, 273, 119, 40);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("");
		button.setBackground(Color.WHITE);
		button.setOpaque(false);
		button.setBorderPainted(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				int[] bookcheck = new int[bookobj.size()];// �̹� �ش��ϴ� �˻�� �־� ��µ� å�� 1, �ƴ� å�� 0
				ArrayList<String> inputString = new ArrayList<String>();//���μҹ����̰� ������� �˻���
				inputString.add("");
			      for(int i=1; i<bookobj.size(); i++) {
			         String target_word;
			         if(comboBox.getSelectedIndex() == 0){//������ �˻�
			            target_word = bookobj.get(i).title.toLowerCase();//���� �ҹ��ڷ�
			         }
			         else if(comboBox.getSelectedIndex() == 1){//���� �˻�
			            target_word = bookobj.get(i).author.toLowerCase();//���� �ҹ��ڷ�
			         }
			         else{
			            target_word = bookobj.get(i).publisher.toLowerCase();//���� �ҹ��ڷ�
			         }
			         target_word = target_word.trim();//��������
			         inputString.add(target_word);
			      }
			      //
			      String findword=textField.getText();
			      findword = findword.toLowerCase();//�ҹ��ڷ�
			      String[] target = findword.split(" ");//�˻�� ����� ����

			      //��ü �˻�� ���� �˻� ���
			      findword = findword.trim();//��������
			      for(int i=1; i<bookobj.size(); i++) {
			         String book = inputString.get(i);
			         if(book.contains(findword) && bookcheck[i]==0) {//�˻�� å �̸��� ���Ե� ���
			            bookcheck[i]=1;
			         }
			      }
			      //

			      //����� ������ �˻�� ���� ���
			      for(int i=0; i<target.length; i++) {
			         for(int j=1; j<bookobj.size(); j++) {
			            String book = inputString.get(j);
			            if(book.contains(target[i]) && bookcheck[j]==0) {//�˻�� å �̸��� ���Ե� ���
			               bookcheck[j]=1;
			            }
			         }
			      }
			      int num=0;
			      for(int i=1; i<bookobj.size(); i++) {
			    	  if(bookcheck[i]==1) {
			    		  num++;
			    	  }
			      }
			      DefaultTableModel model = (DefaultTableModel) personTable.getModel();
			      model.setRowCount(0);
			      for(int i=1; i<bookobj.size(); i++) {
			    	  if(bookcheck[i]==1) {
			    		  model.addRow(new String[] {(String)bookobj.get(i).title, bookobj.get(i).author, bookobj.get(i).publisher, bookobj.get(i).location, bookobj.get(i).lender});
			    	  }
			      }
			      
			}
		});
		button.setFont(new Font("����", Font.BOLD, 13));
		button.setBounds(967, 10, 82, 36);
		contentPane.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(search_frame.class.getResource("/pac/\uD504\uB808\uC820\uD14C\uC774\uC1581.png")));
		lblNewLabel_1.setBounds(0, 0, 1184, 511);
		contentPane.add(lblNewLabel_1);
		
	}
	
}