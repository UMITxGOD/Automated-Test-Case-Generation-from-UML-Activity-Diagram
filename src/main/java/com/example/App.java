package com.example;

public class App {
    public static void main(String[] args) {
        AutomateTestcase LoginActivityDiagram = new AutomateTestcase("./Diagram/LoginActivityDiagram.dot");
        LoginActivityDiagram.generate("start");
    }
}
