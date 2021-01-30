package com.geektime;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 外排序
 */
public class ExternalSort {

    private static final String fileName = "./bigFile.txt";
    private static final Integer numberCnt = 100_000_000;

    public static void main(String[] args) throws Exception {
//        initData();
        sort1();
    }

    public static void initData() throws IOException {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        FileWriter writer = new FileWriter(file, true);
        for (int i = 0; i < numberCnt; i++) {
            String number = (int) (Math.random() * Integer.MAX_VALUE) + "\r\n";
            writer.write(number);
        }
        writer.close();
    }

    /**
     * Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
     * 	at java.util.Arrays.copyOfRange(Arrays.java:3664)
     * 	at java.lang.String.<init>(String.java:207)
     * 	at java.io.BufferedReader.readLine(BufferedReader.java:356)
     * 	at java.io.BufferedReader.readLine(BufferedReader.java:389)
     * 	at com.geektime.ExternalSort.sort1(ExternalSort.java:37)
     * 	at com.geektime.ExternalSort.main(ExternalSort.java:17)
     *
     * @throws IOException
     */
    public static void sort1() throws IOException {
        List<String> dataList = new ArrayList<>(numberCnt);
        BufferedReader bf = new BufferedReader(new FileReader(fileName));
        String str;
        while ( (str = bf.readLine()) != null) {
            dataList.add(str);
        }
        System.out.println("read file end");
        Collections.sort(dataList);
    }

    /**
     * K-way merge sort
     */
    public static void sort2() {
        File tmp1 = new File("./tmp1");
        File tmp2 = new File("./tmp2");
        File tmp3 = new File("./tmp3");
        File tmp4 = new File("./tmp4");
        File tmp5 = new File("./tmp5");

    }

}
