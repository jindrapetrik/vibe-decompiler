package structure_detector.statement;

/**
 * Represents a simple expression statement (like a node label followed by semicolon).
 * 
 * @author JPEXS
 */
public class ExpressionStatement extends Statement {
    
    private final String expression;
    
    /**
     * Creates a new expression statement.
     * 
     * @param expression the expression text
     */
    public ExpressionStatement(String expression) {
        this.expression = expression;
    }
    
    /**
     * Gets the expression text.
     * 
     * @return the expression text
     */
    public String getExpression() {
        return expression;
    }
    
    @Override
    public String toString() {
        return toString("");
    }
    
    @Override
    public String toString(String indent) {
        return indent + expression + ";\n";
    }
}
