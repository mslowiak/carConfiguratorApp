package carconf.savers;

import carconf.car_assembling.CarInformationFacade;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.TextField;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PdfSimpleSaver implements SaverInterface {
    private CarInformationFacade carInformationFacade;

    public PdfSimpleSaver(CarInformationFacade carInformationFacade) {
        this.carInformationFacade = carInformationFacade;
    }

    @Override
    public void saveCarConfiguration() throws DocumentException, FileNotFoundException {
        String modelName = carInformationFacade.getCarModel().toString().replace(" ", "");
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("src/main/resources/pdfs/" + modelName + "_simple.pdf"));
        document.open();

        PdfPTable table = new PdfPTable(1);

        table.addCell(getDescriptionCell());
        table.addCell(getPriceCell());
        document.add(table);

        document.close();
    }

    private PdfPCell getDescriptionCell () {
        PdfPCell cell = new PdfPCell();
        Paragraph description = new Paragraph(
                carInformationFacade.getShortCarDescription().toString(),
                new Font(Font.FontFamily.TIMES_ROMAN, 11));
        description.setAlignment(Element.ALIGN_TOP);
        cell.addElement(description);
        return cell;
    }

    private PdfPCell getPriceCell () {
        PdfPCell cell = new PdfPCell();
        Paragraph textPricePara = new Paragraph(
                "Cena koncowa:  " + carInformationFacade.getTotalPriceByText(),
                new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD));
        textPricePara.setAlignment(Element.ALIGN_CENTER);
        cell.addElement(textPricePara);
        return cell;
    }
}
