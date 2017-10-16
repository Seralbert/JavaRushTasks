package com.javarush.task.task36.task3607;


import java.util.concurrent.DelayQueue;

/*
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {

        return DelayQueue.class;
    }
}

/*
public static Class getExpectedClass() {
        final Set<String> classNames = new HashSet<>();
        final URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        final URL[] jarsPath = classLoader.getURLs();
        //find classes within rt.jar package
        for (final URL jarPath : jarsPath) {
            if (jarPath.toString().endsWith("rt.jar")) {
                try {
                    final JarFile jarFile = new JarFile(jarPath.getPath().toString());
                    final Enumeration<JarEntry> en = jarFile.entries();
                    while (en.hasMoreElements()) {
                        final String fileName = en.nextElement().getName();
                        if (fileName.startsWith(packageName + "/concurrent") && fileName.endsWith(".class") && !fileName.contains("$")){
                        //if (fileName.startsWith("java/util") && fileName.endsWith(".class")) {
                            classNames.add(fileName);
                        }
                    }
                } catch (final IOException ignored) {
                }
            }
        }
        //find class with Queue interface implementation
        for (final String className : classNames) {
            try {
                final String fileName = className.substring(0, className.length() - 6).replace('/', '.');
                final Class cls = Class.forName(fileName);
                if (Queue.class.isAssignableFrom(cls) && cls.getEnclosingClass() == null) {
                    final Field[] fields = cls.getDeclaredFields();
                    final Method[] methods = cls.getDeclaredMethods();
                    if (Arrays.stream(methods)
                            .filter(m -> m.getName().contains("peekExpired"))
                            .flatMap(m -> Arrays.stream(fields))
                            .anyMatch(f -> f.getType().equals(Thread.class))) {
                        return cls;
                    }
                }
            } catch (final ClassNotFoundException ignored) {
            }
        }
        return null;
    }
 */
