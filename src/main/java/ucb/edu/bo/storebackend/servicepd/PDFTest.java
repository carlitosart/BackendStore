package ucb.edu.bo.storebackend.servicepd;


import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.css.RGBColor;
import ucb.edu.bo.storebackend.mapping.CompraEntity;
import ucb.edu.bo.storebackend.mapping.UsuarioEntity;
import ucb.edu.bo.storebackend.repo.CompraEntityRepository;
import ucb.edu.bo.storebackend.repo.UsuarioEntityRepository;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.Collections;

@Service
public class PDFTest {

    @Autowired
    private CompraEntityRepository compraEntityRepository;

    @Autowired
    private UsuarioEntityRepository usuarioEntityRepository;


    public PDFTest(CompraEntityRepository compraEntityRepository, UsuarioEntityRepository usuarioEntityRepository) {
        this.compraEntityRepository = compraEntityRepository;
        this.usuarioEntityRepository = usuarioEntityRepository;
    }



    public void genfac(HttpServletResponse response, Integer id) throws Exception {
        Document factura = new Document(PageSize.A5);



        PdfWriter.getInstance(factura, response.getOutputStream());

        factura.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE);
        fontTitle.setSize(20);

        Paragraph titulofac = new Paragraph("TIENDA DE ROPA ONLINE PATITO", fontTitle);
        titulofac.setAlignment(Paragraph.ALIGN_LEFT);

        Paragraph nitpatito = new Paragraph("NIT:1020141023", fontTitle);
        nitpatito.setAlignment(Paragraph.ALIGN_LEFT);




        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        var resul = compraEntityRepository.findById(id);
        
        if (resul.isPresent()){

            CompraEntity  compratest = resul.get();


            var userres = usuarioEntityRepository.findById((long) compratest.getIdUsuario());


            Paragraph space2 = new Paragraph("\n", fontParagraph);
            space2.setAlignment(Paragraph.ALIGN_RIGHT);

            System.out.println(compratest);
            Paragraph fechafac = new Paragraph(compratest.getFecha().toString(),fontTitle);
            fechafac.setAlignment(Paragraph.ALIGN_RIGHT);

            Paragraph numfac = new Paragraph("Numero de Factura"+String.valueOf(compratest.getIdCompra()), fontParagraph);
            numfac.setAlignment(Paragraph.ALIGN_RIGHT);

            PdfPTable table = new PdfPTable(3);

            table.setWidthPercentage(100f);
            table.setWidths(new int[] { 3, 3, 3 });
            table.setSpacingBefore(5);

            PdfPCell cell = new PdfPCell();

            cell.setBackgroundColor(Color.GREEN);
            cell.setPadding(5);
            cell.setPhrase(new Phrase("ID", fontParagraph));
            table.addCell(cell);
            cell.setPhrase(new Phrase("Nombre Producto", fontParagraph));
            table.addCell(cell);
            cell.setPhrase(new Phrase("Total", fontParagraph));
            table.addCell(cell);

            table.addCell(String.valueOf(compratest.getIdCompra()));
            table.addCell(compratest.getFecha().toString());
            table.addCell(compratest.getCostoTotal().toString());


            factura.add(titulofac);
            factura.add(space2);
            factura.add(nitpatito);
            factura.add(space2);
            factura.add(fechafac);
            factura.add(space2);
            factura.add(numfac);
            if (userres.isPresent()){
                UsuarioEntity user = userres.get();
                Paragraph facti2 = new Paragraph("CLIENTE O RAZON SOCIAL: "+user.getNombre()+user.getApellido(),fontTitle);
                numfac.setAlignment(Paragraph.ALIGN_LEFT);
                factura.add(facti2);
            }

            factura.add(table);

            Paragraph space = new Paragraph("\n\n\n\n", fontParagraph);
            space.setAlignment(Paragraph.ALIGN_RIGHT);

            Paragraph footfac = new Paragraph("Ley N° 453: Tienes derecho a un trato equitativo sin discriminación en la oferta de servicios.", fontParagraph);
            numfac.setAlignment(Paragraph.ALIGN_RIGHT);

            Paragraph footfac2 = new Paragraph("\"ESTA FACTURA CONTRIBUYE AL DESARROLLO DEL PAÍS, EL USO ILÍCITO ES SANCIONADO\n" +
                    "PENALMENTE LEY 453\"", fontParagraph);
            numfac.setAlignment(Paragraph.ALIGN_RIGHT);

            Paragraph footfac3 = new Paragraph("Este documento es una impresión de un Documento Digital emitido en una Modalidad de Facturación en\n" +
                    "Línea", fontParagraph);
            numfac.setAlignment(Paragraph.ALIGN_RIGHT);

            factura.add(space);
            factura.add(footfac);
            factura.add(footfac2);
            factura.add(footfac3);

            factura.close();
        }else {
            throw new Exception("Falla al Cargar el PFF");
        }

    }
}
