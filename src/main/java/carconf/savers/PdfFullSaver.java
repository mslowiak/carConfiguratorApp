package carconf.savers;

import carconf.car_assembling.CarInformationFacade;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

//import javafx.scene.image.Image;

public class PdfFullSaver implements SaverInterface {
    private CarInformationFacade carInformationFacade;

    public PdfFullSaver(CarInformationFacade carInformationFacade) {
        this.carInformationFacade = carInformationFacade;
    }

    @Override
    public void saveCarConfiguration() throws IOException, DocumentException {
        String modelName = carInformationFacade.getCarModel().toString().replace(" ", "");
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("src/main/resources/pdfs/" + modelName + "_full.pdf"));
        document.open();

        PdfPTable table = buildEmptyTable(2, 15);
        table.addCell(getDescriptionCell());
        table.addCell(getPhotoCell());
        table.addCell(getPriceTextCell());
        table.addCell(getPriceValueCell());
        document.add(table);

        document.close();
    }

    private PdfPTable buildEmptyTable(int numberOfColumns, int totalWidthCentimeters) {
        PdfPTable table = new PdfPTable(numberOfColumns);
        table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        table.setTotalWidth(Utilities.millimetersToPoints(totalWidthCentimeters * 10));
        table.setLockedWidth(true);
        return table;
    }

    private PdfPCell getDescriptionCell () {
        PdfPCell cell = new PdfPCell();
        Paragraph description = new Paragraph(
                carInformationFacade.getFullCarDescription().toString(),
                new Font(Font.FontFamily.TIMES_ROMAN, 11));
        description.setAlignment(Element.ALIGN_TOP);
        cell.addElement(description);
        return cell;
    }

    private PdfPCell getPriceTextCell() {
        PdfPCell cell = new PdfPCell();
        Paragraph textPriceParagraph = new Paragraph(
                "Cena koncowa: ",
                new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD));
        textPriceParagraph.setAlignment(Element.ALIGN_CENTER);
        cell.addElement(textPriceParagraph);
        return cell;
    }

    private PdfPCell getPriceValueCell() {
        PdfPCell cell = new PdfPCell();
        Paragraph textPriceParagraph = new Paragraph(
                carInformationFacade.getTotalPriceByText(),
                new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD));
        textPriceParagraph.setAlignment(Element.ALIGN_CENTER);
        cell.addElement(textPriceParagraph);
        return cell;
    }
    private PdfPCell getPhotoCell() throws IOException, BadElementException {
        Image carPhoto = Image.getInstance("src/main/resources" + carInformationFacade.getCarColorPhotoStringPath());
        Image wheelPhoto = Image.getInstance("src/main/resources" + carInformationFacade.getCarWheelPhotoStringPath());
        carPhoto.scalePercent(33);
        wheelPhoto.scalePercent(28);
        Paragraph paragraph = new Paragraph("Wizualizacja samochodu: \n");
        paragraph.add(new Chunk(carPhoto, 0, 0, true));
        paragraph.add("\n\n\n\n\n\nWybrane kola: \n");
        paragraph.add(new Chunk(wheelPhoto, 0, 0, true));

        PdfPCell cell = new PdfPCell();
        cell.addElement(paragraph);
        return cell;
    }

}
