package com.gabriel.crevelario.crevelario.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.util.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;



import java.io.StringReader;
import java.nio.file.Files;

@Service
public class UserService {
    public void loadFile() {
        try {
            File file = new ClassPathResource("/assets/teste.html").getFile();
            String html = new String(Files.readAllBytes(file.toPath()));
            Document document = new Document();
            HTMLWorker worker = new HTMLWorker(document);
            worker.parse(new StringReader(html));

            } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void update(MultipartFile multipartFile) {
        try {
            String teste = new String(IOUtils.toByteArray(multipartFile.getInputStream()),"UTF-8");
            System.out.print(teste);

        }catch (Exception ex) {
            ex.printStackTrace();
        }



    }
}
