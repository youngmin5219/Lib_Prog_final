import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Errorframe3 extends JFrame {//좌석을 배정받으려 하는 사람이 배정된 이미 자리가 있는 경우 띄우는 에러창

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Errorframe3 frame = new Errorframe3();
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
	public Errorframe3() {
		setTitle("SKKU Library");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Errorframe3.class.getResource("/pac/images (1).png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 250, 310, 120);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Errorframe3.class.getResource("/pac/\uB354\uC774\uC0C1\uBC1C\uAD8C\uC548\uB310.png")));
		label.setBounds(0, 0, 294, 81);
		contentPane.add(label);
	}

}
