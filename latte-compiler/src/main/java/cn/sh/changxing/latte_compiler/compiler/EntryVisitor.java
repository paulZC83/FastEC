package cn.sh.changxing.latte_compiler.compiler;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Modifier;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor7;

/**
 * Created by ZengChao on 2018/2/6.
 */

final class EntryVisitor extends SimpleAnnotationValueVisitor7<Void, Void> {

    private final Filer FILER;
    private String mPackageName = null;

    EntryVisitor(Filer FILER) {
        this.FILER = FILER;
    }

    @Override
    public Void visitString(String s, Void p) {
        mPackageName = s;
        return p;
    }

    @Override
    public Void visitType(TypeMirror t, Void p) {
        generateJavaCode(t);
        return p;
    }

    private void generateJavaCode(TypeMirror typeMirror){
        final TypeSpec targetActivity =
                TypeSpec.classBuilder("WXEntryActivity")
                .addModifiers(Modifier.PUBLIC)
                .addModifiers(Modifier.FINAL)
                .superclass(TypeName.get(typeMirror))
                .build();
        final JavaFile javaFile = JavaFile.builder(mPackageName+".wxapi",targetActivity)
                .addFileComment("΢�Žӿ��ļ�")
                .build();
        try {
            javaFile.writeTo(FILER);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
