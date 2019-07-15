package com.tws.refactoring.extract_method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OwingPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void printOwing() {
        //given
        Order order = new Order(2.0);
        OwingPrinter owingPrinter = new OwingPrinter();
        List<Order> list = new ArrayList<>();

        //when
        list.add(order);
        owingPrinter.printOwing("Garson",list);

        //then
        String result = "*****************************\r\n" +
                "****** Customer totals ******\r\n" +
                "*****************************\r\n" +
                "name: Garson\r\n" + "amount: 2.0\r\n";
        assertEquals(result,outContent.toString());
    }
}