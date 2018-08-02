package at.michael.stopper.handler;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;

public class ScrollPaneHandler implements INode{

	@Override
	public void add(Node node) {
		if(isHandler(node)) System.out.println("Ich bin ein ScrollPane");
			
		
	}

	@Override
	public boolean isHandler(Node node) {
		if(node instanceof ScrollPane) return true;
		return false;
	}

}
