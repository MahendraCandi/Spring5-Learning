package com.mahendracandi.springAutoWired.domain;

public class License {
    private String numbers;

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "License{" +
                "numbers='" + numbers + '\'' +
                '}';
    }
}
