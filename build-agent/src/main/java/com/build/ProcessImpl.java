package com.build;

public class ProcessImpl implements Porcess{

        @Override
        public void process(String name) {
            System.out.println("name="+name);
            System.out.println("ProcessImpl");
        }
    }