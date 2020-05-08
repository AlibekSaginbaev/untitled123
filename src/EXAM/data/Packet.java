package EXAM.data;

import java.io.Serializable;
import java.util.ArrayList;

public class Packet implements Serializable {
    private Serializable info;
    private String code;


    public Packet() {}
    public Packet(String code) {
        this.code = code;
    }
    public Packet(String code, Serializable info) {
        this.info = info;
        this.code = code;
    }

    public Serializable getInfo() {
        return info;
    }
    public void setInfo(Serializable info) {
        this.info = info;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
}


