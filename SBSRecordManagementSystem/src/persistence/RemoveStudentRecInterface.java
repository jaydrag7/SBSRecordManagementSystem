package src.persistence;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

public interface RemoveStudentRecInterface {

    public String removeRecords() throws EncryptedDocumentException, IOException;
    public String sendAlert() throws EncryptedDocumentException, IOException;

    
}
