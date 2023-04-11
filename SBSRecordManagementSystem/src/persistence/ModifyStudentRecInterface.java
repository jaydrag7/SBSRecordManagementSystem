package src.persistence;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

public interface ModifyStudentRecInterface {
    
    public String addNewMedicalInfo(String studentID, String infoType, String data) throws EncryptedDocumentException, IOException;
    public String changeStdGrd(String studentID, String subject, String newMark) throws EncryptedDocumentException, IOException;
}
