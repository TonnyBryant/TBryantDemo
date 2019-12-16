package com.tbryant.customjdkproxy.customproxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 模拟JDK动态代理工具类
 */
public class CustomProxy {
    /**
     * 根据目标对象进行分析，得到代理对象代码，拼接成string
     * 保存到磁盘得到.java文件
     * 编译.java文件得到.class文件
     * 把.class文件load到内存
     * 反射得到proxy对象
     */
    public static Object newProxyInstance(ClassLoader loader, Class[] interfaces, CustomInvocationHandler h) {
        Object proxy = null;
        // 第一步：根据目标对象进行分析，得到代理对象代码，拼接成string
        String line = "\n";// 换行
        String tab = "\t";// 缩进
        Class<?> targetInterface = interfaces[0];// TODO 先实现代理一个接口，后续实现代理多个接口
        String targetInterfaceFullName = targetInterface.getName();// 接口全限定名
        String targetInterfaceName = targetInterface.getSimpleName();// 接口名

        String content = "";
        String packageContent = "package com.tbryant;" + line;
        String importContent = "import " + targetInterfaceFullName + ";" + line
                + "import com.tbryant.customjdkproxy.customproxy.CustomInvocationHandler;" + line
                + "import java.lang.reflect.Method;" + line;

        String clazzContent = "public class $CustomProxy implements " + targetInterfaceName + " {" + line;
        String filedContent = tab + "private CustomInvocationHandler h;" + line;
        String constructorContent = tab + "public $CustomProxy(CustomInvocationHandler h){" + line
                + tab + tab + "this.h=h;" + line
                + tab + "}" + line;
        String methodContent = "";
        Method[] methods = targetInterface.getDeclaredMethods();
        for (Method method : methods) {
            Class[] args = method.getParameterTypes();// 方法参数
            // 循环取方法参数类型，拼接方法参数字符串
            String argsTypesContent = "";// 参数类型 String,String
            String argsTypesAndArgsContent = "";// 参数签名 String arg0,String arg1
            String argsContent = "";// 参数 arg0,arg1
            int i = 0;
            for (Class arg : args) {
                String argTypeFullName = arg.getName();
                importContent += "import " + argTypeFullName + ";" + line;
                String argTypeName = arg.getSimpleName();
                argsTypesContent += argTypeName + ".class,";
                argsTypesAndArgsContent += argTypeName + " arg" + i + ",";
                argsContent += "arg" + i + ",";
                i++;
            }
            if (argsTypesContent.length() > 0) {// 有参数的话，去掉末尾逗号
                argsTypesContent = argsTypesContent.substring(0, argsTypesContent.lastIndexOf(","));
                argsTypesAndArgsContent = argsTypesAndArgsContent.substring(0, argsTypesAndArgsContent.lastIndexOf(","));
                argsContent = argsContent.substring(0, argsContent.lastIndexOf(","));
            }
            String methodName = method.getName();// 方法名
            String returnTypeName = method.getReturnType().getSimpleName();// 方法返回值类型名字
            if ("".equals(argsTypesContent)) {
                argsTypesContent += "(Class<?>[]) null";
            }
            if ("void".equals(returnTypeName)) {// 判断是否有返回值
                methodContent += tab + "public " + returnTypeName + " " + methodName + "(" + argsTypesAndArgsContent + ") throws Throwable {" + line
                        + tab + tab + "Method method=Class.forName(\"" + targetInterfaceFullName + "\").getDeclaredMethod(\"" + methodName + "\"," + argsTypesContent + ");" + line
                        + tab + tab + "h.invoke(null,method,new Object[]{" + argsContent + "});" + line
                        + tab + "}" + line;
            } else {
                methodContent += tab + "public " + returnTypeName + " " + methodName + "(" + argsTypesAndArgsContent + ") throws Throwable {" + line
                        + tab + tab + "Method method=Class.forName(\"" + targetInterfaceFullName + "\").getDeclaredMethod(\"" + methodName + "\"," + argsTypesContent + ");" + line
                        + tab + tab + "return (" + returnTypeName + ")h.invoke(null,method,new Object[]{" + argsContent + "});" + line
                        + tab + "}" + line;
            }
        }
        content = packageContent + importContent + clazzContent + filedContent + constructorContent + methodContent + "}";

        // 第二步：保存到磁盘得到.java文件
        File file = new File("d:\\com\\tbryant\\$CustomProxy.java");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            fw.write(content);
            fw.flush();
            fw.close();

            // 第三步：编译.java文件得到.class文件
            JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager standardJavaFileManager = javaCompiler.getStandardFileManager(null, null, null);
            Iterable javaFileObjects = standardJavaFileManager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask compilationTask = javaCompiler.getTask(null, standardJavaFileManager, null, null, null, javaFileObjects);
            compilationTask.call();
            standardJavaFileManager.close();

            // 第四步：把.class文件load到内存
            URL urls[] = new URL[]{new URL("file:D:\\\\")};
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            Class clazz = urlClassLoader.loadClass("com.tbryant.$CustomProxy");

            // 第五步：反射得到proxy对象
            Constructor constructor = clazz.getConstructor(CustomInvocationHandler.class);
            proxy = constructor.newInstance(h);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return proxy;
    }
}
