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
 *
 * Make Ticket Class
 * Class which create ticket in PDF Format with QR code
 *
 */
public class CreateTicket {
    private static final String filename = "Bilet.pdf";

    public static void makeTicket(String title, String date, Customer customer) throws FileNotFoundException {

        PdfWriter pdfWriter = new PdfWriter(filename);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        Paragraph paragraph2 = new Paragraph("Bilet na film:" + " " + title);
        paragraph2.setTextAlignment(TextAlignment.CENTER);
        Paragraph paragraph3 = new Paragraph("Data seansu:" + " " + date);
        paragraph3.setTextAlignment(TextAlignment.CENTER);
        Paragraph paragraph4 = new Paragraph("Osoba rezerwujaca bilet:" + " " + customer.getFirstName() + " " + customer.getLastName());
        paragraph4.setTextAlignment(TextAlignment.CENTER);
        Document document = new Document(pdfDocument);
        BarcodeQRCode qrCode = new BarcodeQRCode(title + " " + date + " " + customer.getFirstName());
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
