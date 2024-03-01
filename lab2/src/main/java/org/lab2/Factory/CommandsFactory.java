package org.lab2.Factory;

import org.lab2.commands.Commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import static java.lang.System.exit;

public class CommandsFactory {
    public CommandsFactory() throws IOException {
//        ClassLoader classLoader = getClass().getClassLoader();
//        InputStream inputStream = classLoader.getResourceAsStream("config");

        File fileInput = new File("config");
        InputStream inputStream = new FileInputStream(fileInput);

        ConfigReader configReader = new ConfigReader(inputStream);
        commandsMap = configReader.getConfigMap();

        System.out.println(commandsMap);
        exit(-2);
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
