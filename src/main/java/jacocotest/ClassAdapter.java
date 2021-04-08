package jacocotest;

import jdk.internal.org.objectweb.asm.*;
import java.lang.instrument.*;

public class ClassAdapter extends ClassVisitor implements Opcodes {
    ClassAdapter(final ClassVisitor cv){
        super(ASM5, cv);
    }

    @Override
    public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions){
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        return mv == null ? null: new MethodAdapter(mv);
    }
}
