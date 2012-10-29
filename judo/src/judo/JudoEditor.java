package judo;



public class JudoEditor {

	/**
	 * Main Entry to Judo Markdown Editor
	 */
	public static void main(String[] args) {
		// TODO Load JudoView, Judo DomainEditor and JudoEditorController
		
		EditableDocuments docs = new EditableDocuments();
		MainEditorView gui = new MainEditorView(docs);
		JudoEditorController controller = new JudoEditorController(docs, gui);
		
		gui.setVisible(true);
		//gui.show();
		

	}

}
