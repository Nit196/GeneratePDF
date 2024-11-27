package com.H2H;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PdfService {

	private Logger logger=LoggerFactory.getLogger(PdfService.class);
	public ByteArrayInputStream createPdf()
	{
		logger.info(".........Creating Pdf started..........");
		
		String title="This is the Title";
		String content="This is the content";
		
		//write Data in ByteArrayOutputStream 
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		Document document=new Document();
		
		PdfWriter.getInstance(document, out);
		document.open();
		
		// For Title
		Font titleFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD,25);
		Paragraph titlePara =new Paragraph(title,titleFont);
		titlePara.setAlignment(Element.ALIGN_CENTER);
		document.add(titlePara);
		
		// For Paragrah
		Font paraFont=FontFactory.getFont(FontFactory.HELVETICA,20);
		Paragraph paragraph =new Paragraph(content);
		paragraph.add(new Chunk("...Added After Creating the Paragraph.."));
		document.add(paragraph);
		
		document.close();
		
		return new ByteArrayInputStream(out.toByteArray());
		
		
		
		
		
	}
	}
