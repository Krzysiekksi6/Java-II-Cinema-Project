package pl.cinema.app;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.barcodes.BarcodeQRCode;
import com.itextpdf.layout.property.TextAlignment;
import pl.cinema.model.Customer;

import java.io.FileNotFoundException;

/**
 * Klasa obsługująca tworzenie biletu w formacie PDF wraz z kodem QR
 */
public class CreateTicket {
    private static final String filename = "Bilet.pdf";

    /**
     * Metoda przyjmująca poszczególne parametry i tworząca bilet klienta wraz z kodem QR
     * @param title title
     * @param time time
     * @param customer customer
     * @throws FileNotFoundException
     */
    public static void makeTicket(String title, String time, Customer customer) throws FileNotFoundException {

        PdfWriter pdfWriter = new PdfWriter(filename);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Paragraph paragraph2 = new Paragraph("Bilet na film:" + " " + title);
        paragraph2.setTextAlignment(TextAlignment.CENTER);
        Paragraph paragraph3 = new Paragraph("Godzina seansu:" + " " + time);
        paragraph3.setTextAlignment(TextAlignment.CENTER);
        Paragraph paragraph4 = new Paragraph("Osoba rezerwujaca bilet:" + " " + customer.getFirstName() + " " + customer.getLastName());
        paragraph4.setTextAlignment(TextAlignment.CENTER);
        Document document = new Document(pdfDocument);
        BarcodeQRCode qrCode = new BarcodeQRCode(title + " " + time + " " + customer.getFirstName());
        PdfFormXObject barcodeObject = qrCode.createFormXObject(Color.BLACK, pdfDocument);
        Image barcodeImage = new Image(barcodeObject).setWidth(100f).setHeight(100f);
        Paragraph paragraph1 = new Paragraph().add(barcodeImage);
        paragraph1.setTextAlignment(TextAlignment.CENTER);

        document.add(paragraph1);
        document.add(paragraph2);
        document.add(paragraph3);
        document.add(paragraph4);
        document.close();

    }
}
