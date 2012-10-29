package judo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.*;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.util.Collections;


public class MainEditorView extends JFrame implements Observer {

	/**
	 * Need this as JFrame is serializable...?
	 */
	private static final long serialVersionUID = 1L;
	private static ImageIcon fileIcon = new ImageIcon("resources/icons/markdownBtns/new.png");
	
	private ArrayList<EditableDocument> docs;
	
	/**
	 * Main Editor View Constructor
	 * */
	public MainEditorView()
	{
		this.setSize(900, 800);
		this.setTitle("Judo Editor");
		
		final Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout(5, 3));
		
		JPanel topPanel = new JPanel(new FlowLayout());
		JPanel fileActionsPanel = createFileOpsPanel();
		JPanel markdownBtnsPanel = createMrkdwnBtns(); //will go inside menuPanel
		JPanel tabsPanel = new JPanel(); //will go inside menuPanel below markdownPanel
		
		 
		JMenuBar menuBar = new JMenuBar();
		/* MENUBAR  */
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu viewMenu = new JMenu("View");
        JMenu helpMenu = new JMenu("Help");
                
        
        
        /*    FILEMENU ITEMS  */
        JMenuItem newItem = new JMenuItem("New", 'N');
        fileMenu.add(newItem);
        
        JMenuItem openItem = new JMenuItem("Open...", 'O');
        fileMenu.add(openItem);
        
        fileMenu.addSeparator(); /*---------------------*/
        
        JMenuItem saveItem = new JMenuItem("Save", 'S');
        fileMenu.add(saveItem);
        
        JMenuItem saveAsItem = new JMenuItem("Save As...");
        fileMenu.add(saveAsItem);
        
        fileMenu.addSeparator(); /*---------------------*/
        
        JMenuItem previewItem = new JMenuItem("Preview", 'V');
        fileMenu.add(previewItem);
    
        JMenuItem printItem = new JMenuItem("Print", 'P');
        fileMenu.add(printItem);
        
        fileMenu.addSeparator(); /*---------------------*/
        JMenuItem quitItem = new JMenuItem("Quit", 'Q');
        fileMenu.add(quitItem);
        
        
        
        /* Adding Menus to bar*/
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);
        
        /*Buttons*/
        
        /* default new file tab*/
        JTextArea ta1 = new JTextArea();
        JScrollPane panelta1 = new JScrollPane(ta1);
        panelta1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panelta1.setPreferredSize(new Dimension(800	, 600));
        
        
        /* CENTER tabbed pane*/
        JTabbedPane tabbedPane = new JTabbedPane();
        
        tabbedPane.addTab("new", fileIcon, panelta1, "new");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        
        tabsPanel.add(tabbedPane);
        //tabsPanel.set
        contentPane.add("Center", tabsPanel);
        
        /* setting menu/tool bar to top of pane */
        setJMenuBar(menuBar);
        /*setting other Jpanels*/
        contentPane.add("West", fileActionsPanel);
        topPanel.add(markdownBtnsPanel);
        contentPane.add("North", topPanel);
        
        
	}

	private JPanel createFileOpsPanel() {
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

		
		JButton newBtn = new JButton(new ImageIcon("resources/icons/fileops/new.png"));
		newBtn.setToolTipText("New File");
		
		JButton openBtn = new JButton(new ImageIcon("resources/icons/fileops/folder.png"));
		openBtn.setToolTipText("Open File");
		
		JButton saveBtn = new JButton(new ImageIcon("resources/icons/fileops/save.png"));
		saveBtn.setToolTipText("Save Current Doc");
		
		JButton savecopyBtn = new JButton(new ImageIcon("resources/icons/fileops/savecopy.png"));
		saveBtn.setToolTipText("Save Current Doc");
		
		JButton closeBtn = new JButton(new ImageIcon("resources/icons/fileops/close.png"));
		closeBtn.setToolTipText("Close Current File");
		
		
		buttonPanel.add(newBtn);
		buttonPanel.add(openBtn);
		buttonPanel.add(saveBtn);
		buttonPanel.add(savecopyBtn);
		buttonPanel.add(closeBtn);
		//buttonPanel.add();
		return buttonPanel;
	}

	private JPanel createMrkdwnBtns() {

		JPanel panel = new JPanel(new FlowLayout());

		JButton boldBtn = new JButton(new ImageIcon("resources/icons/markdownBtns/bold.png"));
		boldBtn.setToolTipText("Bold");
		JButton italicBtn = new JButton(new ImageIcon("resources/icons/markdownBtns/italic.png"));
		italicBtn.setToolTipText("Italics");
		JButton h1Btn = new JButton(new ImageIcon("resources/icons/markdownBtns/h1.png"));
		h1Btn.setToolTipText("<H1>");
		JButton h2Btn = new JButton(new ImageIcon("resources/icons/markdownBtns/h2.png"));
		h2Btn.setToolTipText("<H2>");
		JButton h3Btn = new JButton(new ImageIcon("resources/icons/markdownBtns/h3.png"));
		h3Btn.setToolTipText("<H3>");
		JButton h4Btn = new JButton(new ImageIcon("resources/icons/markdownBtns/h4.png"));
		h4Btn.setToolTipText("<H4>");
		JButton h5Btn = new JButton(new ImageIcon("resources/icons/markdownBtns/h5.png"));
		h5Btn.setToolTipText("<H5>");
		JButton h6Btn = new JButton(new ImageIcon("resources/icons/markdownBtns/h6.png"));
		h6Btn.setToolTipText("<H6>");
		JButton bulletBtn = new JButton(new ImageIcon("resources/icons/markdownBtns/bullet.png"));
		bulletBtn.setToolTipText("<ul> - bullet list");
		JButton listBtn = new JButton(new ImageIcon("resources/icons/markdownBtns/list.png"));
		listBtn.setToolTipText("<ol> - Numbered List");
		JButton linkBtn = new JButton(new ImageIcon("resources/icons/markdownBtns/link.png"));
		linkBtn.setToolTipText("Insert hyperlink");
		JButton imageBtn = new JButton(new ImageIcon("resources/icons/markdownBtns/image.png"));
		imageBtn.setToolTipText("Insert image");
		
		JButton quoteBtn = new JButton(new ImageIcon("resources/icons/markdownBtns/quoteblock.png"));
		quoteBtn.setToolTipText("Insert Quote Block");
		
		panel.add(boldBtn);
		panel.add(italicBtn);
		panel.add(h1Btn);
		panel.add(h2Btn);
		panel.add(h3Btn);
		panel.add(h4Btn);
		panel.add(h5Btn);
		panel.add(h6Btn);
		panel.add(bulletBtn);
		panel.add(listBtn);
		panel.add(linkBtn);
		panel.add(imageBtn);
		panel.add(quoteBtn);
		
		return panel;
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO set this to controller
		
	}
	
		// this should go on a controller
//	private static void loadFileToTextArea(File file, JTextArea textArea, Container errorContainer) {
//        Scanner fileScanner = null;
//        boolean noError = true;
//        try {
//            fileScanner = new Scanner(file);
//        } catch (FileNotFoundException e) {
//            noError = false;
//            JOptionPane.showMessageDialog(errorContainer, "File not found!");
//        }
//        while (noError && fileScanner.hasNextLine()) {
//            textArea.append(fileScanner.nextLine()+"\n");
//        }
//    }
	
}
