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
		
		JComboBox comboBox = new JComboBox();	//검색방법 선택(제목, 저자, 출판사)
		comboBox.setFont(new Font("굴림", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uB3C4\uC11C\uBA85", "\uC800\uC790", "\uCD9C\uD310\uC0AC"}));
		comboBox.setBounds(226, 17, 77, 32);
		contentPane.add(comboBox);
		
		textField = new JTextField();//검색창
		textField.setFont(new Font("굴림", Font.PLAIN, 13));
		textField.setBounds(315, 17, 640, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		String category2[] = {"제목", "저자", "출판사", "청구기호", "대여상황"};//검색결과를 보여줄 때 책에 대한 정보와 대여 상황
		DefaultTableModel model2 = new DefaultTableModel(category2, 1000);
		
		//button 반복문으로 책 권수만큼 만들기(button으로 이루어진 어레이로. button[0], button[1], button[2], button[3] 등등)
		
		
		
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
		
		
		
		JButton btnNewButton = new JButton("");		//대여 버튼
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setOpaque(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int book = personTable.getSelectedRow();		//몇번째열 선택했는지 나타내는 변수
				for(int i=1; i<bookobj.size(); i++) {
					if((personTable.getValueAt(personTable.getSelectedRow(), 3)).equals(bookobj.get(i).location)&&(personTable.getValueAt(personTable.getSelectedRow(), 0)).equals(bookobj.get(i).title)){
						if(bookobj.get(i).lender.equals("-")){//대여자 정보가 비어있다->대여가능->대여자 정보 업데이트
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
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 13));
		btnNewButton.setBounds(1065, 223, 119, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");		//반납 버튼
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int book = personTable.getSelectedRow();//몇번째열 선택했는지 나타내는 변수
				int flag =1;
				for(int i=1; i<bookobj.size(); i++) {
					if((personTable.getValueAt(personTable.getSelectedRow(), 3)).equals(bookobj.get(i).location)){
						if(bookobj.get(i).lender.equals(user.name)&&bookobj.get(i).lenderid.equals(user.id)) {
							returncheckframe frame = new returncheckframe(clientobj,bookobj,user.name,user.id,user.statusflag);
							frame.setVisible(true);
							bookobj.get(i).lender="-";		//반납되었으므로 정보 초기화
							bookobj.get(i).lenderid="-";
							flag=0;
						}
					}
				}
				if(flag==1) {		//반납하려는 사람이 책을 빌리지 않은경우
					Errorframe2 frame = new Errorframe2();	//에러창
					frame.setVisible(true);
				}
				DefaultTableModel model = (DefaultTableModel) personTable.getModel();
			      model.setRowCount(0);
			      for(int i=1; i<bookobj.size(); i++) {
			    		 model.addRow(new String[] {(String)bookobj.get(i).title, bookobj.get(i).author, bookobj.get(i).publisher, bookobj.get(i).location, bookobj.get(i).lender});
			      }
			}
		});
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 13));
		btnNewButton_1.setBounds(1065, 273, 119, 40);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("");
		button.setBackground(Color.WHITE);
		button.setOpaque(false);
		button.setBorderPainted(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				int[] bookcheck = new int[bookobj.size()];// 이미 해당하는 검색어가 있어 출력된 책은 1, 아닌 책은 0
				ArrayList<String> inputString = new ArrayList<String>();//전부소문자이고 공백없는 검색어
				inputString.add("");
			      for(int i=1; i<bookobj.size(); i++) {
			         String target_word;
			         if(comboBox.getSelectedIndex() == 0){//도서명 검색
			            target_word = bookobj.get(i).title.toLowerCase();//전부 소문자로
			         }
			         else if(comboBox.getSelectedIndex() == 1){//저자 검색
			            target_word = bookobj.get(i).author.toLowerCase();//전부 소문자로
			         }
			         else{
			            target_word = bookobj.get(i).publisher.toLowerCase();//전부 소문자로
			         }
			         target_word = target_word.trim();//공백제거
			         inputString.add(target_word);
			      }
			      //
			      String findword=textField.getText();
			      findword = findword.toLowerCase();//소문자로
			      String[] target = findword.split(" ");//검색어를 띄어쓰기로 구분

			      //전체 검색어에 대한 검색 결과
			      findword = findword.trim();//공백제거
			      for(int i=1; i<bookobj.size(); i++) {
			         String book = inputString.get(i);
			         if(book.contains(findword) && bookcheck[i]==0) {//검색어가 책 이름에 포함된 경우
			            bookcheck[i]=1;
			         }
			      }
			      //

			      //띄어쓰기로 구분한 검색어에 대한 결과
			      for(int i=0; i<target.length; i++) {
			         for(int j=1; j<bookobj.size(); j++) {
			            String book = inputString.get(j);
			            if(book.contains(target[i]) && bookcheck[j]==0) {//검색어가 책 이름에 포함된 경우
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
		button.setFont(new Font("굴림", Font.BOLD, 13));
		button.setBounds(967, 10, 82, 36);
		contentPane.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(search_frame.class.getResource("/pac/\uD504\uB808\uC820\uD14C\uC774\uC1581.png")));
		lblNewLabel_1.setBounds(0, 0, 1184, 511);
		contentPane.add(lblNewLabel_1);
		
	}
	
}