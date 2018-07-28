package pl.sdacademy;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrinterQueueTest {

	@DisplayName("Should print text")
	@Test
	void test00(){
		//given
		int documentThreshold = 1;
		Printer printer = new Printer(documentThreshold);
		Document document = new Document(false);

		//when
		printer.print(document);
		//then
		assertThat(document.isPrinted()).isTrue();
	}

	@DisplayName("Should not print documents if minimum number of documents is not reached")
	@Test
	void test01(){
		//given
		int documentThreshold = 4;
		Printer printer = new Printer(documentThreshold);
		Document doc1 = notPrintedDocument();
		Document doc2 = notPrintedDocument();
		Document doc3 = notPrintedDocument();

		//when
		printer.print(doc1);
		printer.print(doc2);
		printer.print(doc3);
		//then
		assertThat(doc1.isPrinted()).isFalse();
		assertThat(doc2.isPrinted()).isFalse();
		assertThat(doc3.isPrinted()).isFalse();
	}

	@DisplayName("Should print all documents under minimum number and not print documents over minimum number")
	@Test
	void test02(){
		//given
		int documentThreshold = 2;
		Printer printer = new Printer(documentThreshold);
		Document doc1 = notPrintedDocument();
		Document doc2 = notPrintedDocument();
		Document doc3 = notPrintedDocument();

		//when
		printer.print(doc1);
		printer.print(doc2);
		printer.print(doc3);
		//then
		assertThat(doc1.isPrinted()).isTrue();
		assertThat(doc2.isPrinted()).isTrue();
		assertThat(doc3.isPrinted()).isFalse();
	}

	private Document notPrintedDocument() {
		return new Document(false);
	}
}
