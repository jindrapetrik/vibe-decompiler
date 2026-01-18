package structure_detector.statement;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a try-catch statement.
 * 
 * @author JPEXS
 */
public class TryStatement extends Statement {
    
    private final List<Statement> tryBody;
    private final List<Statement> catchBody;
    
    /**
     * Creates a new try-catch statement.
     * 
     * @param tryBody the statements in the try block
     * @param catchBody the statements in the catch block
     */
    public TryStatement(List<Statement> tryBody, List<Statement> catchBody) {
        this.tryBody = tryBody != null ? new ArrayList<>(tryBody) : new ArrayList<>();
        this.catchBody = catchBody != null ? new ArrayList<>(catchBody) : new ArrayList<>();
    }
    
    /**
     * Gets the try body statements.
     * 
     * @return the try body statements
     */
    public List<Statement> getTryBody() {
        return new ArrayList<>(tryBody);
    }
    
    /**
     * Gets the catch body statements.
     * 
     * @return the catch body statements
     */
    public List<Statement> getCatchBody() {
        return new ArrayList<>(catchBody);
    }
    
    @Override
    public String toString() {
        return toString("");
    }
    
    @Override
    public String toString(String indent) {
        StringBuilder sb = new StringBuilder();
        
        // Generate try block
        sb.append(indent).append("try {\n");
        
        String innerIndent = indent + "    ";
        for (Statement stmt : tryBody) {
            sb.append(stmt.toString(innerIndent));
        }
        
        // Generate catch block
        sb.append(indent).append("} catch {\n");
        
        for (Statement stmt : catchBody) {
            sb.append(stmt.toString(innerIndent));
        }
        
        sb.append(indent).append("}\n");
        
        return sb.toString();
    }
}
