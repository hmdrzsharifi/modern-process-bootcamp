package com.modern.process.domain;

public class Engine {
    private String type;
    private int volume;

    public Engine() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString(){
        return String.format("%s %d", type, volume);
    }
}
