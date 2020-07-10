package back;

import java.io.Serializable;
import java.util.Comparator;

public class ExamStudentSort implements Comparator<ExamStudent>, Serializable {
    @Override
    public int compare(ExamStudent o1, ExamStudent o2) {
        return Double.compare(o1.getGrade(), o2.getGrade());
    }
}
