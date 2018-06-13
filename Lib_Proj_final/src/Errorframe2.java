
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Errorframe2 extends JFrame {//책을 반납하려는 사람이 책을 빌린 적 없을 때 나오는 에러창

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Errorframe2 frame = new Errorframe2();
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
	public Errorframe2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Errorframe2.class.getResource("/pac/images (1).png")));
		setTitle("SKKU Library");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 250, 310, 120);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Errorframe2.class.getResource("/pac/\uB300\uC5EC\uD558\uC9C0\uC54A\uC740\uB3C4\uC11C.png")));
		lblNewLabel.setBounds(0, 0, 294, 81);
		contentPane.add(lblNewLabel);
	}

}
