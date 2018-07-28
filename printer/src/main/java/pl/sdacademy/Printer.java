package pl.sdacademy;

import java.util.Stack;

public class Printer {
	private final int documentThreshold;
	private Stack<Document> printQueue;

	Printer (int documentThreshold){
		this.printQueue = new Stack<>();
		this.documentThreshold = documentThreshold;
	}

	void print(Document document){
		printQueue.push(document);
		if (printQueue.size() >= documentThreshold)
		{
			while (!printQueue.isEmpty()) printQueue.pop().setPrinted(true);
		}

	}
}
