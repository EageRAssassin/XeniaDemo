import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainWindow {

	private JFrame frame;
	private MenuBar mb;
	private Menu menuAbout, menuFile;
	private MenuItem mi1, mi2, miAboutXenia;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setTitle("Hilton Xenia");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container pane = frame.getContentPane();
		
		// initialize menu bar
		mb = new MenuBar();
		menuFile = new Menu("File");
		menuAbout = new Menu("About");
		mi1 = new MenuItem("Import Customer Data");
		mi2 = new MenuItem("Export Prediction");
		miAboutXenia = new MenuItem("About Xenia");
		menuFile.add(mi1);
		menuFile.add(mi2);
		menuAbout.add(miAboutXenia);
		mb.add(menuFile);
		mb.add(menuAbout);
		frame.setMenuBar(mb);
		
		mi1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setDialogTitle("Import Customer Data");
				fc.setDialogType(JFileChooser.CUSTOM_DIALOG);
				if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
					fc.getSelectedFile();
				}
			}
		});
		
		miAboutXenia.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog about = new JDialog();
				about.setTitle("About Xenia");
			}
		});
		
		// start building panels
		
		Panel logoPanel = new Panel();
		logoPanel.setPreferredSize(new Dimension(900, 50));
		pane.add(logoPanel, BorderLayout.NORTH);
		

		Panel predictionPanel = new Panel();
		predictionPanel.setPreferredSize(new Dimension(900, 800));
		predictionPanel.setBackground(Color.LIGHT_GRAY);
		predictionPanel.setLayout(new FlowLayout(0));
		JLabel jl = new JLabel("Predicitons");
		jl.setSize(new Dimension(900, 30));
		predictionPanel.add(jl);
		

		Panel graph1 = new Panel();

		graph1.setBackground(Color.WHITE);
		graph1.setPreferredSize(new Dimension(230, 200));
		predictionPanel.add(graph1);

		Panel graph2 = new Panel();
		graph2.setBackground(Color.WHITE);
		graph2.setPreferredSize(new Dimension(230, 200));
		predictionPanel.add(graph2);

		Panel graph3 = new Panel();
		graph3.setBackground(Color.WHITE);
		graph3.setPreferredSize(new Dimension(230, 200));
		predictionPanel.add(graph3);
		pane.add(predictionPanel, BorderLayout.CENTER);

		Panel customerPanel = new Panel();
		customerPanel.setPreferredSize(new Dimension(900, 200));
		customerPanel.setBackground(Color.LIGHT_GRAY);
		customerPanel.setLayout(new FlowLayout(0));

		Panel situation = new Panel();
		situation.setPreferredSize(new Dimension(230, 200));
		situation.add(new JLabel("Weather"));
		situation.add(new JLabel("Road Traffic"));
		situation.add(new JLabel("Flight Delay"));

		customerPanel.add(situation);
		
		Panel Blue = new Panel();
		Blue.setBackground(Color.blue);
		Blue.setPreferredSize(new Dimension(155, 155));
		customerPanel.add(Blue);

		Panel Silver = new Panel();
		Silver.setBackground(Color.LIGHT_GRAY);
		Silver.setPreferredSize(new Dimension(155, 155));
		customerPanel.add(Silver);

		Panel Gold = new Panel();
		Gold.setBackground(Color.YELLOW);
		Gold.setPreferredSize(new Dimension(155, 155));
		customerPanel.add(Gold);

		Panel Diamond = new Panel();
		Diamond.setBackground(Color.GRAY);
		Diamond.setPreferredSize(new Dimension(155, 155));
		customerPanel.add(Diamond);

		pane.add(customerPanel, BorderLayout.SOUTH);
		
		frame.setVisible(true);
	}

}
