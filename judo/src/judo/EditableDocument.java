package judo;

import java.util.Observable;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class EditableDocument  extends Observable {

	private JTextArea textarea;
	private JScrollPane scrollpane;
	private boolean isunsaved;
	private String filepath;
	private Document document; 
	
	public EditableDocument()
	{
		this.filepath = "";
	}
	
	public EditableDocument(JScrollPane scp, JTextArea jta, Document doc, String filepath)
	{
		this.setTextarea(jta);
		this.scrollpane = scp;
		this.filepath = filepath;
		this.document = doc;
		this.textarea.setDocument(doc);
		this.scrollpane.setViewportView(this.textarea);
	}

	
	/* Plain Document 
	 *  is what the textpane as actually gets and modifies
	 * */
	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	/*  Data: the text that will actually be saved into a .MD file*/
//	public String getData() {
//		return data;
//	}
//
//	public void setData(String data) {
//		this.data = data;
//	}

	
	/*
	 * the
	 * */
	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

//	public String getFilename() {
//		return filename;
//	}
//
//	public void setFilename(String filename) {
//		this.filename = filename;
//	}

	public JTextArea getTextarea() {
		return textarea;
	}

	public void setTextarea(JTextArea textarea) {
		this.textarea = textarea;
	}

	public boolean isIsunsaved() {
		return isunsaved;
	}

	public void setIsunsaved(boolean isunsaved) {
		this.isunsaved = isunsaved;
	}

	public JScrollPane getScrollpane() {
		return scrollpane;
	}

	public void setScrollpane(JScrollPane scrollpane) {
		this.scrollpane = scrollpane;
	}
	
	
}
