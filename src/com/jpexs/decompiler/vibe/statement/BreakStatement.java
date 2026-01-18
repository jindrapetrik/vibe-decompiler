package com.jpexs.decompiler.vibe.statement;

/**
 * Represents a break statement with an optional label.
 * 
 * @author JPEXS
 */
public class BreakStatement extends Statement {
    
    private final String label;
    
    /**
     * Creates a new unlabeled break statement.
     */
    public BreakStatement() {
        this.label = null;
    }
    
    /**
     * Creates a new labeled break statement.
     * 
     * @param label the label to break to (can be null for unlabeled break)
     */
    public BreakStatement(String label) {
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
     * Gets the global ID of the target block/loop extracted from the label.
     * The label format is expected to be "loop_X" or "block_X" where X is the global ID.
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
     * Checks if this is a labeled break.
     * 
     * @return true if this break has a label
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
            return indent + "break " + label + ";\n";
        } else {
            return indent + "break;\n";
        }
    }
}
