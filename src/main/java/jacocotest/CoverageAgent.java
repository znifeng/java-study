package jacocotest;

import java.lang.instrument.*;

public class CoverageAgent {
    public static void premain(String agentArgs, Instrumentation inst){
        inst.addTransformer(new CoCoTransformer());
    }

}
