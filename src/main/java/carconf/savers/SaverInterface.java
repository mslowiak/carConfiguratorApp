package carconf.savers;

import carconf.car_assembling.CarInformationFacade;
import com.itextpdf.text.DocumentException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface SaverInterface {
    void saveCarConfiguration() throws IOException, DocumentException;
}
