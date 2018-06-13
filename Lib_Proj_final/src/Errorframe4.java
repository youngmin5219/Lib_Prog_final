
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Errorframe4 extends JFrame {//사용자가 선택한 자리가 빈자리가 아닐 때 띠우는 에러창

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Errorframe4 frame = new Errorframe4();
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
	public Errorframe4() {
		setTitle("SKKU Library");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Errorframe4.class.getResource("/pac/images (1).png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 250, 310, 120);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Errorframe4.class.getResource("/pac/\uC0AC\uC6A9\uC911.png")));
		label.setBounds(0, 0, 294, 81);
		contentPane.add(label);
	}

}
