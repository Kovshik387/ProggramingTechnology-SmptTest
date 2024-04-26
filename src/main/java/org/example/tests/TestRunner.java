package org.example.tests;


import org.example.services.FileService;
import org.example.services.MessageManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    //почта, файл
    private final List<String[]> positiveTests = List.of(
            new String[]{"fantokin@mail.ru","result.jpg"},
            new String[]{"happytown7781@mail.ru","result.jpg"}
    );

    private final List<String[]> negativeTests = List.of(
            new String[]{"fantokin","result.jpg"},         // почта не удов
            new String[]{"fantokin@mail.ru","result"},     // файл не найден
            new String[]{"",""}                            // пустые значения
    );

    private final List<String> negativeTestResult = new ArrayList<>();
    private final List<String> positiveTestResult = new ArrayList<>();
    public void solve(){

        for (var item : positiveTests) {
            if (taskCheck(item[0],item[1])){
                positiveTestResult.add(ANSI_GREEN + "test passed");
            }
            else{
                positiveTestResult.add(ANSI_RED + "test not passed");
            }
        }

        for (var item: negativeTests) {
            if (!taskCheck(item[0],item[1])){
                negativeTestResult.add(ANSI_GREEN + "test passed");
            }
            else{
                negativeTestResult.add(ANSI_RED + "test not passed");
            }
        }

        System.out.println(ANSI_GREEN + "Negative tests\n");
        for(var item: positiveTestResult){
            System.out.println(item);
        }

        System.out.println(ANSI_RED + "Negative tests");
        for (var item: negativeTestResult){
            System.out.println(item);
        }
    }
    private boolean taskCheck(String email, String fileName){
        FileService fileService = new FileService();
        MessageManager messageManager = new MessageManager();
        return messageManager.sendMessage(email,new File(fileName));
    }

}
