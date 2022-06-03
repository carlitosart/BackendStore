package ucb.edu.bo.storebackend.servicepd;


import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ucb.edu.bo.storebackend.mapping.CompraEntity;
import ucb.edu.bo.storebackend.mapping.UsuarioEntity;
import ucb.edu.bo.storebackend.repo.CompraEntityRepository;
import ucb.edu.bo.storebackend.repo.UsuarioEntityRepository;

import javax.servlet.http.HttpServletResponse;
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
        Document factura = new Document(PageSize.LETTER);



        PdfWriter.getInstance(factura, response.getOutputStream());

        factura.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE);
        fontTitle.setSize(20);

        Paragraph titulofac = new Paragraph("TIENDA DE ROPA ONLINE PATITO", fontTitle);
        titulofac.setAlignment(Paragraph.ALIGN_RIGHT);

        Paragraph nitpatito = new Paragraph("NIT:1020141023", fontTitle);
        nitpatito.setAlignment(Paragraph.ALIGN_RIGHT);



        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        var resul = compraEntityRepository.findById(id);
        if (resul.isPresent()){

            CompraEntity  compratest = resul.get();


            var userres = usuarioEntityRepository.findById((long) compratest.getIdUsuario());



            System.out.println(compratest);
            Paragraph fechafac = new Paragraph(compratest.getFecha().toString(),fontTitle);
            fechafac.setAlignment(Paragraph.ALIGN_RIGHT);

            Paragraph numfac = new Paragraph("Numero de Factura"+String.valueOf(compratest.getIdCompra()), fontParagraph);
            numfac.setAlignment(Paragraph.ALIGN_RIGHT);

            factura.add(titulofac);
            factura.add(nitpatito);
            factura.add(fechafac);
            factura.add(numfac);
            if (userres.isPresent()){
                UsuarioEntity user = userres.get();
                Paragraph facti2 = new Paragraph("CLIENTE O RAZON SOCIAL: "+user.getNombre()+user.getApellido(),fontTitle);
                numfac.setAlignment(Paragraph.ALIGN_LEFT);
                factura.add(facti2);
            }

            factura.close();
        }else {
            throw new Exception("Falla al Cargar el PFF");
        }

    }
}
