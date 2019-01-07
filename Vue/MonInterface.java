package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

public class MonInterface {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonInterface window = new MonInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MonInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 659, 438);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JCheckBox chckbxIntgrerExtension = new JCheckBox("Int\u00E9grer Extension");
		chckbxIntgrerExtension.setBounds(216, 69, 196, 29);
		frame.getContentPane().add(chckbxIntgrerExtension);
		
		JRadioButton rdbtnJeuxPrincipal = new JRadioButton("Jeux principal");
		buttonGroup.add(rdbtnJeuxPrincipal);
		rdbtnJeuxPrincipal.setBounds(11, 127, 155, 29);
		frame.getContentPane().add(rdbtnJeuxPrincipal);
		
		JRadioButton rdbtnVariante = new JRadioButton("Variante 1");
		buttonGroup.add(rdbtnVariante);
		rdbtnVariante.setBounds(231, 127, 155, 29);
		frame.getContentPane().add(rdbtnVariante);
		
		JRadioButton rdbtnVariante_1 = new JRadioButton("Variante 2");
		buttonGroup.add(rdbtnVariante_1);
		rdbtnVariante_1.setBounds(415, 127, 155, 29);
		frame.getContentPane().add(rdbtnVariante_1);
		
		JRadioButton rdbtnNormal = new JRadioButton("Normal");
		buttonGroup_1.add(rdbtnNormal);
		rdbtnNormal.setBounds(135, 221, 155, 29);
		frame.getContentPane().add(rdbtnNormal);
		
		JRadioButton rdbtnDifficile = new JRadioButton("Difficile");
		buttonGroup_1.add(rdbtnDifficile);
		rdbtnDifficile.setBounds(368, 221, 155, 29);
		frame.getContentPane().add(rdbtnDifficile);
		
		JRadioButton radioButton_1 = new JRadioButton("1");
		buttonGroup_2.add(radioButton_1);
		radioButton_1.setBounds(32, 317, 155, 29);
		frame.getContentPane().add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("2");
		buttonGroup_2.add(radioButton_2);
		radioButton_2.setBounds(216, 317, 155, 29);
		frame.getContentPane().add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("3");
		buttonGroup_2.add(radioButton_3);
		radioButton_3.setBounds(415, 317, 155, 29);
		frame.getContentPane().add(radioButton_3);
		
		JLabel lblTheOtherHat = new JLabel("The Other Hat Trick");
		lblTheOtherHat.setBounds(216, 16, 153, 20);
		frame.getContentPane().add(lblTheOtherHat);
		
		JLabel lblVariante = new JLabel("Variante :");
		lblVariante.setBounds(15, 95, 69, 20);
		frame.getContentPane().add(lblVariante);
		
		JLabel lblDifficult = new JLabel("Difficult\u00E9 :");
		lblDifficult.setBounds(11, 194, 92, 20);
		frame.getContentPane().add(lblDifficult);
		
		JLabel lblJoueur = new JLabel("Joueur :");
		lblJoueur.setBounds(11, 282, 69, 20);
		frame.getContentPane().add(lblJoueur);
		
		JLabel lblCdricFreire = new JLabel("C\u00E9dric Freire & Arwan Credoz");
		lblCdricFreire.setBounds(386, 358, 236, 20);
		frame.getContentPane().add(lblCdricFreire);
	}
}
