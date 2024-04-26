package org.example;

import org.example.services.FileService;
import org.example.services.MessageManager;
import org.example.tests.TestRunner;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");

        var test = new TestRunner();
        test.solve();

    }
}