package judo;



public class JudoEditor {

	/**
	 * Main Entry to Judo Markdown Editor
	 */
	public static void main(String[] args) {
		// TODO Load JudoView, Judo DomainEditor and JudoEditorController
		
		//FileSystem fileSystem = new FileSystem();
		JudoEditorController controller = new JudoEditorController();
		MainEditorView gui = new MainEditorView(/*controller, new EditableDocument()*/);
		//gui.setVisible(true);
		gui.show();
		

	}

}
