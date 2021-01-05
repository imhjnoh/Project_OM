package practice;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class OMWindow extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../imgs/noname.png")));

	private ImageIcon exitButtonEntered = new ImageIcon(Main.class.getResource("../imgs/exit0.png"));
	private ImageIcon exitButtonDefault = new ImageIcon(Main.class.getResource("../imgs/exit1.png"));
	private JButton exitButton = new JButton(exitButtonDefault);
	
	public OMWindow() {
		setUndecorated(true);
		setTitle("Project_OM");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		exitButtonSetting();
		add(exitButton);
		
		
		
		menuBar.setBounds(0, 0, 1280, 30);
		add(menuBar);
		
	}
	
	private void exitButtonSetting() {
		exitButton.setBounds(1250, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEntered);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonDefault);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics g) {
		//g.drawImage(buttons.getBackground(), 0, 0, null);
		paintComponents(g);
		//this.repaint();
	}
}
