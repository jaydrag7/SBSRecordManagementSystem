package src.persistence;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;

public interface GenerateReportInterface {
    
    public ArrayList<String> getStdGrd(String studentID) throws EncryptedDocumentException, IOException;
    public Integer stdAverage(ArrayList<String> Grades);
}
