package back;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Objects;

public class Manager extends User implements Serializable {
    private ArrayList<ExamManager> examManagers = new ArrayList<>();

    public ArrayList<ExamManager> getExamManagers() {
        return examManagers;
    }

    public Manager(String firstname, String lastname, String username, String password) {
        super(firstname, lastname, username, password);
    }

    public void addExam(String name, String pathexcel, Calendar start, Calendar end) {
        ExamManager examManager = new ExamManager(name, this, start, end);
        getExamManagers().add(examManager);
        try {
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new File(pathexcel)));
            XSSFSheet sheet = wb.getSheetAt(0);
            for (Row row : sheet) {
                String[] NewStudent = readexcel(row, pathexcel);
                Student student;
                if (User.getUser(NewStudent[0]) == null)
                    student = new Student(NewStudent[1], NewStudent[2], NewStudent[0], NewStudent[0], NewStudent[0]);
                else
                    student = (Student) User.getUser(NewStudent[0]);
                ExamStudent examStudent = new ExamStudent(examManager, student);
                examManager.getStudents().add(student);
                examManager.getExamStudents().add(examStudent);
                student.getExamStudents().add(examStudent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addExam(String name, String id, String firstname, String lastname, Calendar start, Calendar end) {
        ExamManager examManager = new ExamManager(name, this, start, end);
        getExamManagers().add(examManager);
        Student student;
        if (User.getUser(id) == null)
            student = new Student(firstname, lastname, id, id, id);
        else
            student = (Student) User.getUser(id);
        ExamStudent examStudent = new ExamStudent(examManager, student);
        examManager.getStudents().add(student);
        examManager.getExamStudents().add(examStudent);
        student.getExamStudents().add(examStudent);
    }

    public String[] readexcel(Row vrow, String path) {
        String[] Return = new String[3];
        try {
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new File(path)));
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Cell> cellIterator = vrow.cellIterator();
            for (int i = 0; cellIterator.hasNext(); i++) {
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        Return[i] = cell.getStringCellValue();
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        Return[i] = String.valueOf((long) cell.getNumericCellValue());
                        break;
                    default:
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Return;
    }

    public void averageexcel() {
        int n = 0;
        for (ExamManager examManager : examManagers) {
            if (examManager.getAverage() != -1) {
                writeexcel(examManager.getName(), examManager.getAverage(), n);
                n++;
            }
        }
    }

    public void examexcel(ExamManager examManager) {
        int n = 0;
        for (ExamStudent examStudent : examManager.getExamStudents()) {
            if (examStudent.getGrade() != -1) {
                writeexcel(examManager.getName(), examStudent.getGrade(), n);
                n++;
            }
        }
    }

    public void writeexcel(Object first, Object second, int vrow) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("excel");
        Row row = sheet.createRow(vrow);
        Cell cell = row.createCell(0);
        if (first instanceof String)
            cell.setCellValue((String) first);
        else if (first instanceof Double)
            cell.setCellValue((Double) first);
        else if (first instanceof Integer)
            cell.setCellValue((Integer) first);

        cell = row.createCell(1);
        if (second instanceof String)
            cell.setCellValue((String) second);
        else if (second instanceof Double)
            cell.setCellValue((Double) second);
        else if (second instanceof Integer)
            cell.setCellValue((Integer) second);

        try (FileOutputStream FOS = new FileOutputStream("excel.xlsx")) {
            workbook.write(FOS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;
        Manager manager = (Manager) o;
        return manager.getUsername().equals(getUsername());
    }
}
