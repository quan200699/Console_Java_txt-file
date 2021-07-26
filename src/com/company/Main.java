package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
//        File file = new File("/Users/quan/Java/Console/demo-file-txt-read-write/hello.txt");// đường dẫn tuyệt đối
//        File dir = new File(".idea");// đường dẫn tương đối
//        if(dir.isDirectory()){
//            String[] fileContent = dir.list();
//            for (String content: fileContent){
//                System.out.println(content);
//            }
//        }
        String fileName = "hello.txt";
//        writeToFile(fileName);
        try {
            readFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
        bufferedReader.close();
        fileReader.close();
    }

    private static void writeToFile(String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            //Lấy dữ liệu cũ trước => ghi dữ liệu cũ + dữ liệu mới
            bufferedWriter.write("Hello C0621H1");
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
