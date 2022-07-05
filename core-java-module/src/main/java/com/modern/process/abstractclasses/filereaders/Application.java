package com.modern.process.abstractclasses.filereaders;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {

    public static void main(String[] args) throws URISyntaxException, IOException {

        Application application = new Application();
        Path path = application.getPathFromResourceFile("files/test.txt");
        BaseFileReader lowercaseFileReader = new LowercaseFileReader(path);
        lowercaseFileReader.readFile().forEach(line -> System.out.println(line));

        BaseFileReader uppercaseFileReader = new UpperCaseFileReader(path);
        uppercaseFileReader.readFile().forEach(line -> System.out.println(line));
    }

    private Path getPathFromResourceFile(String filePath) throws URISyntaxException {
        return Paths.get(getClass().getClassLoader().getResource(filePath).toURI());
    }
}
