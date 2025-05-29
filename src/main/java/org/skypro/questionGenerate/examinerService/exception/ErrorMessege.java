package org.skypro.questionGenerate.examinerService.exception;

public class ErrorMessege {
    private final String cod;
    private final String messang;

    public String getCod() {
        return cod;
    }

    public String getMessang() {
        return messang;
    }

    public ErrorMessege(String cod, String messang) {
        this.cod = cod;
        this.messang = messang;
    }
}
