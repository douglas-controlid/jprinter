package br.com.controlid;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import java.awt.print.PrinterJob;
import java.nio.file.Path;
import java.nio.file.Paths;

//exemplo escrito em Java 8
//ambiente: Windows 10 Pro
//IDE: JetBrains IntelliJ 2019.1
public class App {

	private static final String FILEPATH = "C:\\Users\\Douglas Miguel\\Documents\\NFe33190782373077000171657550000017621911332521 (1).pdf";

	public static void main(String[] args) throws Exception {
		Path path = Paths.get(FILEPATH);

		//carrega o pdf
		PDDocument pdf = PDDocument.load(path.toFile());

		//pega o servico de impressao padrao
		PrintService printService = PrintServiceLookup.lookupDefaultPrintService();

		System.out.println("Imprimindo na impressora \"" + printService.getName() + "\"");

		//cria um trabalho de impressao
		PrinterJob printerJob = PrinterJob.getPrinterJob();

		//coloca o arquivo no trabalho
		printerJob.setPageable(new PDFPageable(pdf));

		//coloca o servico
		printerJob.setPrintService(printService);

		//manda imprimir
		printerJob.print();
	}

}
