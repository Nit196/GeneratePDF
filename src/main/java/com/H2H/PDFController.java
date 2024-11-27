package com.H2H;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pdf")
public class PDFController {

	@Autowired
	private PdfService pdfService;
	
	@GetMapping("/createPdf")
	public ResponseEntity<InputStreamResource> createPdf()
	{
		ByteArrayInputStream pdf=pdfService.createPdf();
		
		HttpHeaders httpHeader=new HttpHeaders();
		httpHeader.add("Content-Disposition", "inline;file=SpringBoot.pdf");
		
		return ResponseEntity.ok()
				.headers(httpHeader)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(pdf));
		
	}
}
