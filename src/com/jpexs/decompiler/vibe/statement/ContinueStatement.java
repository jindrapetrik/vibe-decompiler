package com.jpexs.decompiler.vibe.statement;

/**
 * Represents a continue statement with an optional label.
 * 
 * @author JPEXS
 */
public class ContinueStatement extends Statement {
    
    private final String label;
    
    /**
     * Creates a new unlabeled continue statement.
     */
    public ContinueStatement() {
        this.label = null;
    }
    
    /**
     * Creates a new labeled continue statement.
     * 
     * @param label the label to continue to (can be null for unlabeled continue)
     */
    public ContinueStatement(String label) {
        this.label = label;
    }
    
    /**
     * Gets the label.
     * 
     * @return the label, or null if unlabeled
     */
    public String getLabel() {
        return label;
    }
    
    /**
     * Gets the global ID of the target loop extracted from the label.
     * The label format is expected to be "loop_X" where X is the global ID.
     * 
     * @return the global ID, or -1 if the label is null or doesn't contain a valid ID
     */
    public int getLabelId() {
        if (label == null || label.isEmpty()) {
            return -1;
        }
        int underscoreIndex = label.lastIndexOf('_');
        if (underscoreIndex == -1 || underscoreIndex == label.length() - 1) {
            return -1;
        }
        try {
            return Integer.parseInt(label.substring(underscoreIndex + 1));
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    /**
     * Checks if this is a labeled continue.
     * 
     * @return true if this continue has a label
     */
    public boolean hasLabel() {
        return label != null && !label.isEmpty();
    }
    
    @Override
    public String toString() {
        return toString("");
    }
    
    @Override
    public String toString(String indent) {
        if (hasLabel()) {
            return indent + "continue " + label + ";\n";
        } else {
            return indent + "continue;\n";
        }
    }
}
