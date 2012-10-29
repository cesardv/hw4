package judo;

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.text.PlainDocument;

public class EditableDocuments  extends Observable {

	private ArrayList<PlainDocument> documents = new ArrayList<PlainDocument>(); //perhaps I need to extend this PlainDocument class and add attributes to it like filename, etc etc

	public EditableDocuments()
	{
		this.documents.add(new PlainDocument());
		
	}

	public ArrayList<PlainDocument> getDocuments() {
		return documents;
	}

	public void setDocuments(ArrayList<PlainDocument> documents) {
		this.documents = documents;
	}
	
	public PlainDocument getDocumentByIndex(int i)
	{
		return this.documents.get(i);
	}
	
	
}
