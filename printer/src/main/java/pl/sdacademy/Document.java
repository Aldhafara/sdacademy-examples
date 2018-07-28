package pl.sdacademy;

public class Document {
	private boolean printed;

	 Document(boolean b){
		this.printed = b;
	}
	 boolean isPrinted() {
		return printed;
	}

	public void setPrinted(boolean b) {
		printed = b;
	}
}
