package com.modern.process.abstractclasses.filereaders;

import java.nio.file.Path;

public class LowercaseFileReader extends BaseFileReader{

    public LowercaseFileReader(Path filePath) {
        super(filePath);
    }

    @Override
    protected String mapFileLine(String line) {
        return line.toLowerCase();
    }
}
