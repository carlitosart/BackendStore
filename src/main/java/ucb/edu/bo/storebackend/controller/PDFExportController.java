package ucb.edu.bo.storebackend.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ucb.edu.bo.storebackend.servicepd.PDFGeneratorService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PDFExportController {

    private final PDFGeneratorService pdfGeneratorService;


    public PDFExportController(PDFGeneratorService pdfGeneratorService) {
        this.pdfGeneratorService = pdfGeneratorService;
    }

    @GetMapping("/pdf/gen")
    public void generatePDF(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";

        String headerValue = "attachment; filename=pdf_"+currentDateTime+".pdf";

        response.setHeader(headerKey,headerValue);

        this.pdfGeneratorService.export(response);
    }
}