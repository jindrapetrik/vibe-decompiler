package com.jpexs.decompiler.vibe;

public class TestNewExample {
    public static void main(String[] args) {
        String dot = 
            "digraph pcode {\n" +
            "  start -> loc0000;\n" +
            "  loc00d9 -> loc00f9;\n" +
            "  loc00d9 -> loc00ec;\n" +
            "  loc0015 -> loc0036;\n" +
            "  loc0015 -> loc0029;\n" +
            "  loc009c -> loc010a;\n" +
            "  loc005c -> loc007f;\n" +
            "  loc005c -> loc006f;\n" +
            "  loc00ac -> loc00cf;\n" +
            "  loc00ac -> loc00bf;\n" +
            "  loc006f -> loc010a;\n" +
            "  loc00f9 -> loc0103;\n" +
            "  loc0036 -> loc00d9;\n" +
            "  loc0036 -> loc0049;\n" +
            "  loc00bf -> loc010a;\n" +
            "  loc0103 -> loc0015;\n" +
            "  loc0103 -> loc010a;\n" +
            "  loc007f -> loc0089;\n" +
            "  loc0000 -> loc0103;\n" +
            "  loc0089 -> loc00ac;\n" +
            "  loc0089 -> loc009c;\n" +
            "  loc00cf -> loc00d9;\n" +
            "  loc0049 -> loc0089;\n" +
            "  loc0049 -> loc005c;\n" +
            "}";
        
        System.out.println("===== Testing New Example (Example 25) =====");
        StructureDetector detector = StructureDetector.fromGraphviz(dot);
        detector.analyze();
        System.out.println("\n--- Pseudocode ---");
        System.out.println(detector.toPseudocode());
        System.out.println("--- Graphviz/DOT ---");
        System.out.println(detector.toGraphviz());
    }
}
