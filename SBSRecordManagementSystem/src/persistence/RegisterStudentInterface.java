package src.persistence;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import src.business_logic_layer.student.Student;

public interface RegisterStudentInterface {
    
    public String createExcel() throws IOException;
    public String regStudent(Student student) throws IOException;
    public String enterStdGrds(Student student) throws EncryptedDocumentException, IOException;
    public String enterMedicalInfo(Student student) throws EncryptedDocumentException, IOException;
    
}
