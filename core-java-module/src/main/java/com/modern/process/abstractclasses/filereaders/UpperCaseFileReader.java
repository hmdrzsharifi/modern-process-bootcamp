package com.modern.process.abstractclasses.filereaders;

import java.nio.file.Path;

public class UpperCaseFileReader extends BaseFileReader{

    public UpperCaseFileReader(Path filePath) {
        super(filePath);
    }

    @Override
    protected String mapFileLine(String line) {
        return line.toUpperCase();
    }
}
