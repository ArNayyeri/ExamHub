package back;

import java.io.File;

public class AnswerDescriptive extends Answer {
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
