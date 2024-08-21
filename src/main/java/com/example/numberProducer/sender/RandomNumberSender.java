package com.example.numberProducer.sender;

import org.springframework.web.client.RestTemplate;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RandomNumberSender {

    private static final int MAX_NUMBERS_PER_SECOND = 5;

    private static final int TOTAL_NUMBER_QUANTITY = 100;

    private static List<Integer> generatedNumbers = new ArrayList<>();

    public  synchronized  void sendFiveNumbers() throws URISyntaxException {

        try {
            wait(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("http://localhost:8091/receiveNumbers");

        List<Integer> numberList = new ArrayList<>();
        Random rand = new Random();

        for(int i = 0; i<MAX_NUMBERS_PER_SECOND; i++) {
            int num =  Math.abs(rand.nextInt());
            numberList.add(num);
        }
        generatedNumbers.addAll(numberList);

        restTemplate.postForEntity(uri, numberList, List.class);
    }

    public  void execute() throws URISyntaxException, IOException {
        while(generatedNumbers.size() < TOTAL_NUMBER_QUANTITY) {
            sendFiveNumbers();
        }

        generateCSVFileFromList(generatedNumbers);
    }

    public  void generateCSVFileFromList(List<Integer> data) throws IOException {
        PrintWriter outFile = new PrintWriter(new FileWriter("sentNumbers.csv"));

        data.forEach(i->outFile.print(i + ", "));

        outFile.close();
    }

}
