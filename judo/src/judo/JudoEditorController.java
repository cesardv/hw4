package judo;

import java.util.Observable;

public class JudoEditorController {
	
	private EditableDocuments docModels;
	private MainEditorView guiView; 
	
	public JudoEditorController(EditableDocuments docs, MainEditorView view)
	{
		this.docModels = docs;
		this.guiView = view; //perhaps this shoudl be an interface IMainEditorView to decouple view/GUI from controller further
		
	}

}
