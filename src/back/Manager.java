package back;

import gui.MainClass;
import gui.MyExamsManager;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Manager extends User implements Serializable {
    private ArrayList<ExamManager> examManagers = new ArrayList<>();

    public ArrayList<ExamManager> getExamManagers() {
        return examManagers;
    }

    public Manager(String firstname, String lastname, String username, String password) {
        super(firstname, lastname, username, password);
    }

    public ExamManager addExam(String name, String pathexcel, Date start, Date end
            , boolean consecutive, boolean random) {
        ExamManager examManager = new ExamManager(name, this, start, end);
        examManager.setConsecutive(consecutive);
        examManager.setRandom(random);
        getExamManagers().add(examManager);
        try {
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new File(pathexcel)));
            XSSFSheet sheet = wb.getSheetAt(0);
            for (Row row : sheet) {
                String[] NewStudent = readexcel(row, pathexcel);
                Student student;
                if (User.getUser(NewStudent[0]) == null) {
                    student = new Student(NewStudent[1], NewStudent[2], NewStudent[0], NewStudent[0], NewStudent[0]);
                    MainClass.getMainClass().students.add(student);
                } else
                    student = (Student) User.getUser(NewStudent[0]);
                ExamStudent examStudent = new ExamStudent(examManager, student);
                examManager.getStudents().add(student);
                examManager.getExamStudents().add(examStudent);
                student.getExamStudents().add(examStudent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return examManager;
    }

    public ExamManager addExam(String name, Date start, Date end, boolean consecutive, boolean random) {
        ExamManager examManager = new ExamManager(name, this, start, end);
        examManager.setConsecutive(consecutive);
        examManager.setRandom(random);
        getExamManagers().add(examManager);
        return examManager;
    }

    public void addStudentExam(ExamManager examManager, String id, String firstname, String lastname) {
        Student student;
        if (User.getUser(id) == null) {
            student = new Student(firstname, lastname, id, id, id);
            MainClass.getMainClass().students.add(student);
        } else
            student = (Student) User.getUser(id);
        ExamStudent examStudent = new ExamStudent(examManager, student);
        examManager.getStudents().add(student);
        examManager.getExamStudents().add(examStudent);
        student.getExamStudents().add(examStudent);
        Object o[] = new Object[2];
        o[0] = examManager;
        o[1] = student;
        MainClass.getMainClass().data.save("Add Student Exam", o);
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

    public void averageexcel(String name) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        int n = 0;
        for (ExamManager examManager : examManagers) {
            if (examManager.getAverage() != -1) {
                Row row = sheet.createRow(n);
                Cell cell = row.createCell(0);
                cell.setCellValue(examManager.getName());
                cell = row.createCell(1);
                cell.setCellValue(examManager.getAverage());
                n++;
            }
        }
        try {
            FileOutputStream FOS = new FileOutputStream(name + ".xlsx");
            workbook.write(FOS);
            FOS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void examexcel(ExamManager examManager, String name) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        int n = 0;
        for (ExamStudent examStudent : examManager.getExamStudents()) {
            if (examStudent.getGrade() != -1) {
                Row row = sheet.createRow(n);
                Cell cell = row.createCell(0);
                cell.setCellValue(examManager.getName());
                cell = row.createCell(1);
                cell.setCellValue(examStudent.getGrade());
                n++;
            }
        }
        try {
            FileOutputStream FOS = new FileOutputStream(name + ".xlsx");
            workbook.write(FOS);
            FOS.close();
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
