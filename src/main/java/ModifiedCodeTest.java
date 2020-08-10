import java.util.HashMap;
import java.util.Map;

public class ModifiedCodeTest {
    // 识别方法
    public Map<String, Integer> getMethods(String diffInfo) {
        int startLine = 0; //方法起始行
        //int endLine = 0; //方法结束行
        int type = 1; // 只对修改的类有效，方法改动方式，3：修改类新增方法，1: 修改， 4: 修改类删除方法
        int lineNum = 0;//当前行序号
        boolean functionPt = false; //方法识别指针
        int parePt = 0; //"()"指针
        boolean onPt; // 通过"()"确定是否开始
        String startPt = "";
        StringBuffer methodLine = new StringBuffer();
        //解决换行问题
        Map<String, Integer> methods = new HashMap<>();
        String[] diffs = diffInfo.split("@@");
        //'(' 和'）'确定是否开始检测
        // 获得起止行, 通过"{}"获得方法体
        for (String diff : diffs) {
            // init
            lineNum = 0;
            parePt = 0;
            onPt = false;
            functionPt = false;

            String[] diffArray = diff.split("\\n");
            for (String diffLine : diffArray) {
                for (int x = 0; x < diffLine.length(); x++) {
                    char charPt = diffLine.charAt(x);
                    if (charPt == ' ') {
                        continue;
                    }
                    if (charPt == '(') {
                        parePt++;
                    } else if (charPt == ')') {
                        parePt--;
                        if (parePt == 0) {
                            onPt = true; //打开
                        }
                    }
                    // 如果onPt为true，再次遇到"("则关闭
                    if (onPt && parePt == 0 && charPt == '(') {
                        onPt = false;
                    }
                    //排除"();"形式的方法调用场景, 这样也会排查接口中新增的方法
                    if (onPt && charPt == ';') {
                        onPt = false;
                    }
                    if (onPt && charPt == '{') {
                        startLine = lineNum;
                        startPt = diffLine; //起始行打点
                        functionPt = true;
                    }
                    if (functionPt) {
                        //提取方法
                        if (startPt.contains(")") && startPt.contains("(")) {
                            methodLine.append(startPt); // 排除不换行的方法
                            if (methodLine.toString().startsWith("+")) {
                                type = 3;
                            } else if (methodLine.toString().startsWith("-")) {
                                type = 4;
                            } else {
                                type = 1;
                            }
                        } else {
                            int s = 0;
                            do {
                                methodLine.insert(0, diffArray[startLine - s]);
                            } while (!diffArray[startLine - s].contains("(") && startLine - (s++) >= 0);
                            if (diffArray[startLine - s + 1].startsWith("+")) {
                                type = 0;
                            } else if (diffArray[startLine - s + 1].startsWith("-")) {
                                type = 2;
                            } else {
                                type = 1;
                            }
                        }
                        if (isMethod(methodLine.toString())) {
                            methods.put(this.methodName.toString().replaceAll("-", "").replaceAll("\\+", "").replaceAll("\\t", "").replaceAll("\\r", ""), type);
                            this.methodName = new StringBuffer("");
                            methodLine = new StringBuffer("");
                        }
                        //关闭
                        parePt = 0;
                        onPt = false;
                        functionPt = false;
                    }
                }
                lineNum++;
            }
        }
        return methods;
    }

    //判断是否是方法，返回方法名+参数
    private boolean isMethod(String diff) {
        String[] strings = diff.split("\\(");
        String method = strings[0].substring(strings[0].lastIndexOf(" ") + 1);
        if (methodIdentifier(method)) {
            String param = strings[1].split("\\)")[0];
            this.methodName.append(method)
                .append("(")
                .append(param)
                .append(")");
            return true;
        }
        return false;
    }

    //命名规范检测
    String[] keywords = {"if", "while", "for", "do", "switch"};

    private boolean methodIdentifier(String methodName) {
        if (methodName.length() == 0 || !Character.isJavaIdentifierStart(methodName.charAt(0))) {
            return false;
        }
        String name = methodName.substring(1);
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isJavaIdentifierPart(name.charAt(i))) {
                return false;
            }
        }
        for (String keyword : keywords) {
            if (methodName.equals(keyword)) {
                return false;
            }
        }
        return true;
    }
}
