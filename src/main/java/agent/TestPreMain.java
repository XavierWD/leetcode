package agent;

import java.lang.instrument.Instrumentation;

/**
 * Created by weixiaolong on 2019/2/11.
 */
public class TestPreMain {

    public static void premain(String agentOps, Instrumentation inst) {
        System.out.println("=========premain running========");
        System.out.println(agentOps);
        inst.addTransformer(new FirstAgent());
    }
}
