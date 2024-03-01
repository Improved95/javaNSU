package org.lab2.Factory;

import org.lab2.commands.Commands;
import org.lab2.readers.ConfigReader;

import java.io.InputStream;
import java.util.Map;

public class CommandsFactory {
    public CommandsFactory() {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("org/lab2/Factory/config.txt");

//        File fileInput = new File("org/lab2/Factory/config.txt"); //работает везде, но нужно прописывать полный пусть, начиная с диска или с корневого каталога, если в linux
//        InputStream inputStream = new FileInputStream(fileInput);

        ConfigReader configReader = new ConfigReader();
        commandsMap = configReader.getConfigMap(inputStream);
    }

    public Commands create(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class c = Class.forName("org.lab2.commands.mathematical." + className);
        Commands commandObject = (Commands)c.newInstance();
        return commandObject;
    }

    private Map<String, String> commandsMap;
}

/*public class Reflection {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {

        Constructor<Hello> constructor = Hello.class.getConstructor(String.class);
        Hello world = constructor.newInstance("World");

        Constructor<Hello2> constructor2 = Hello2.class.getConstructor(String.class);
        Hello2 world2 = constructor2.newInstance("World");

        Method greet = Hello.class.getMethod("greet");
        Method greet2 = Hello2.class.getMethod("greet");

        greet.invoke(world);
        greet2.invoke(world2);

    }

    static class Hello {
        String name;

        public Hello(String name) {
            this.name = name;
        }

        public void greet() {
            System.out.println("Hello, " + name + "!");
        }
    }

    static class Hello2 {
        final String name;

        public Hello2(String name) {
            this.name = name;
        }

        public void greet() {
            System.out.println("Hello2, " + name + "!");
        }
    }

}*/
