package com.example.demo;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class pdfManager {

    private static final String PDF_DIRECTORY = "demo\\src\\main\\resources";  // Carpeta donde se guardarán los PDFs

    /**
     * Genera un PDF con la información de la nave.
     *
     * @param starship Objeto Starship con los datos de la nave.
     * @throws IOException
     * @throws DocumentException
     */
    public void generateStarshipPDF(Starship starship) throws IOException, DocumentException {
        // Crear la carpeta /naves si no existe
        File directory = new File(PDF_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Definir el nombre del archivo PDF (ejemplo: Millennium_Falcon.pdf)
        String fileName = PDF_DIRECTORY + "/" + starship.getName().replaceAll("\\s+", "_") + ".pdf";

        // Crear el documento PDF con márgenes personalizados
        Document doc = new Document(PageSize.A4, 50, 50, 100, 72);
        PdfWriter.getInstance(doc, new FileOutputStream(fileName));

        // Abrir el documento
        doc.open();

        // Título
        Paragraph title = new Paragraph("Información de la Nave: " + starship.getName());
        title.setAlignment(Element.ALIGN_CENTER);
        doc.add(title);

        doc.add(new Paragraph(" "));  // Espacio en blanco

        // Información detallada de la nave
        doc.add(new Paragraph("Modelo: " + starship.getModel()));
        doc.add(new Paragraph("Clase: " + starship.getStarshipClass()));
        doc.add(new Paragraph("Tripulación: " + starship.getCrew()));
        doc.add(new Paragraph("Capacidad de carga: " + starship.getCargoCapacity()));
        doc.add(new Paragraph("Hyperdrive Rating: " + starship.getHyperdriveRating()));
        doc.add(new Paragraph("Consumibles: " + starship.getConsumables()));
        doc.add(new Paragraph("Número de películas: " + starship.getFilms().size()));

        // Cerrar el documento
        doc.close();

        System.out.println("PDF generado correctamente: " + fileName);
    }
}
