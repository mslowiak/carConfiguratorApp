package carconf.savers;

import carconf.car_assembling.CarInformationFacade;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.embed.swing.SwingFXUtils;

//import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class PdfFullSaver implements SaverInterface {
    private CarInformationFacade carInformationFacade;

    public PdfFullSaver(CarInformationFacade carInformationFacade) {
        this.carInformationFacade = carInformationFacade;
    }

    @Override
    public void saveCarConfiguration() throws IOException, DocumentException {
        String modelName = carInformationFacade.getCarModel().toString().replace(" ", "");
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("src/main/resources/pdfs/" + modelName + ".pdf"));
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
        Paragraph textPricePara = new Paragraph(
                "Cena koncowa: ",
                new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD));
        textPricePara.setAlignment(Element.ALIGN_CENTER);
        cell.addElement(textPricePara);
        return cell;
    }

    private PdfPCell getPriceValueCell() {
        PdfPCell cell = new PdfPCell();
        Paragraph textPricePara = new Paragraph(
                carInformationFacade.getTotalPriceByText(),
                new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD));
        textPricePara.setAlignment(Element.ALIGN_CENTER);
        cell.addElement(textPricePara);
        return cell;
    }
    private PdfPCell getPhotoCell() throws IOException, BadElementException {
        PdfPCell cell = new PdfPCell();
//        Image photo = Image.getInstance(carInformationFacade.getCarColorPhotoStringURL());
//        cell.setImage(photo);
        return cell;
    }


}
