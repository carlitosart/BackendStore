package ucb.edu.bo.storebackend.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ucb.edu.bo.storebackend.servicepd.PDFTest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PDFControllerTwo {
    private final PDFTest pdfTest;

    public PDFControllerTwo(PDFTest pdfTest) {
        this.pdfTest = pdfTest;
    }

    @GetMapping("/pdf/gen/{id}")
    public void generateFactura(HttpServletResponse response, @PathVariable("id") Integer id) throws Exception {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";

        String headerValue = "attachment; filename=pdf_"+currentDateTime+".pdf";

        response.setHeader(headerKey,headerValue);

        this.pdfTest.genfac(response,id);


    }
}
