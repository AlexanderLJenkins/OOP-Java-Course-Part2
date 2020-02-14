package reader.criteria;

/**
 * A class that implements criterion to identify lines that end with a question
 * or exclamation mark.
 * @author Alex Jenkins
 */
public class EndsWithQuestionOrExclamationMark implements Criterion {

    @Override
    public boolean complies(String line) {
        if (line.isEmpty()) {
            return false;
        }
        return (line.charAt(line.length()-1) == '?' ||
                line.charAt(line.length()-1) == '!');
    }
}
