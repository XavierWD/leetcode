package reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceTest {

    String name = "";


    public ReferenceTest(String name) {
        this.name = name;
    }

    public static void main(String... args) throws Exception{
        SoftReference<ReferenceTest> referenceTestSoftReference = new SoftReference<>(new ReferenceTest("1"));
        WeakReference<ReferenceTest> weakReference = new WeakReference<>(new ReferenceTest("2"));
        System.gc();
        System.out.println("over");
        System.in.read();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finish" + name);
        super.finalize();
    }
}
