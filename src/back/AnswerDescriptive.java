package back;

import java.io.File;
import java.io.Serializable;

public class AnswerDescriptive extends Answer implements Serializable {
    private File file;

    public AnswerDescriptive(Question question, File file) {
        super(question);
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
