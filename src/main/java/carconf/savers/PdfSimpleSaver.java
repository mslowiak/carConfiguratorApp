package carconf.savers;

import com.itextpdf.text.Document;

public class PdfSimpleSaver implements SaverInterface {
    @Override
    public void saveCarConfiguration() {
        Document document = new Document();
    }
}
