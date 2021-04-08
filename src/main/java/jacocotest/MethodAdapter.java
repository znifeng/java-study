package jacocotest;

import jdk.internal.org.objectweb.asm.*;

public class MethodAdapter extends MethodVisitor implements Opcodes {
    MethodAdapter(final MethodVisitor mv){
        super(ASM5, mv);
    }

    @Override
    public void visitLineNumber(final int line, final Label start){
        // 插入打印行号的探针
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "err", "Ljava/io/PrintStream;");
        mv.visitLdcInsn("\u001B[32m" + "Line: " + line + " is covered" + "\u001B[32m");
        mv.visitMethodInsn(Opcodes.H_INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        mv.visitLineNumber(line, start);
    }
}
