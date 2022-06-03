package ucb.edu.bo.storebackend.servicepd;


import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class PDFGeneratorService {

    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.LETTER);

        PdfWriter.getInstance(document, response.getOutputStream());


        /*TITULO FACTURA*/
        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE);
        fontTitle.setSize(20);
        Paragraph paragraph = new Paragraph("TIENDA DE ROPA ONLINE PATITO", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_RIGHT);

        Paragraph nitpatito = new Paragraph("NIT:1020141023", fontTitle);
        nitpatito.setAlignment(Paragraph.ALIGN_RIGHT);

        Paragraph numfac = new Paragraph("No FACTURA: 11950", fontTitle);
        numfac.setAlignment(Paragraph.ALIGN_RIGHT);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        /*PARRAFO FACTURA*/

        Paragraph paragraph2 = new Paragraph("This is a Parrafor", fontParagraph);

        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(paragraph);
        document.add(nitpatito);
        document.add(numfac);
        document.add(paragraph2);

        document.close();
    }
}
