package agent;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.bytecode.CodeAttribute;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class FirstAgent implements ClassFileTransformer {
    public final String injectedClassName = "test.agent.wxl";

    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        className = className.replace("/", ".");
//        System.out.println(className);
        if (className.startsWith(injectedClassName)) {
            CtClass ctclass = null;
            try {
                ctclass = ClassPool.getDefault().get(className);// 使用全称,用于取得字节码类<使用javassist>
                CtMethod[] ctmethods = ctclass.getMethods();
                for (CtMethod ctMethod : ctmethods) {
                    CodeAttribute ca = ctMethod.getMethodInfo2().getCodeAttribute();
                    if (ca == null) {
                        continue;
                    }
                    if (!ctMethod.isEmpty()) {
//                        System.out.println(ctMethod.getName());
                        ctMethod.insertBefore("System.out.println(\"hello Im agent : " + ctMethod.getName() + "\");");
                    }
                }
                return ctclass.toBytecode();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return null;
    }
}
