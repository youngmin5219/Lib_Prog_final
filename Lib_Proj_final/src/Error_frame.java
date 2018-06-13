import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Error_frame extends JFrame {//로그인한 사람이 사용자 목록에 없는 경우 띄우주는 에러창

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Error_frame frame = new Error_frame();
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
	public Error_frame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Error_frame.class.getResource("/pac/images (1).png")));
		setTitle("SKKU Library");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 250, 311, 120);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setIcon(new ImageIcon(Error_frame.class.getResource("/pac/\uC774\uB984_\uD559\uBC88.png")));
		lblNewLabel.setBounds(0, 0, 304, 81);
		contentPane.add(lblNewLabel);
	}

}