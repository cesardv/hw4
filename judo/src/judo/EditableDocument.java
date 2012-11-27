package judo;

import java.util.Observable;

import javax.swing.JTextArea;
import javax.swing.text.PlainDocument;

public class EditableDocument  extends Observable {

	JTextArea textarea;
	private boolean isunsaved;
	private String filepath;
	private String filename;
	private PlainDocument document; //we likely not gonna use this
	
	public EditableDocument()
	{
		this.filename = "";
		this.filepath = "";
	}
	
	public EditableDocument(JTextArea jta, String filename, String filepath)
	{
		this.textarea = jta;
		this.filename = filename;
		this.filepath = filepath;
	}

	
	/* Plain Document 
	 *  is what the textpane as actually gets and modifies
	 * */
	public PlainDocument getDocument() {
		return document;
	}

	public void setDocument(PlainDocument document) {
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

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
}
