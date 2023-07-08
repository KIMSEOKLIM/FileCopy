package kr.co.mz.fileclean;

import java.io.*;

public class FileCleaner {

    private final static String PATH = "/Users/mz01-megalim/downloads";

    public static void main(String[] args) throws IOException {

        File copyDirectory = new File(PATH + "/" + "CopyDirectory");

        if (!copyDirectory.exists()) {
            copyDirectory.mkdir();
        }

        File beforeText = new File(PATH + "/" + "beforeText.txt");
        if (!beforeText.exists()) {
            beforeText.createNewFile();
        }

        File afterText = new File(copyDirectory, "afterText.txt");


        if (!afterText.exists()) {
            try (InputStream inputStream = new FileInputStream(beforeText);
                 OutputStream outputStream = new FileOutputStream(afterText);
            ) {
//            byte[] buffer = new byte[4096];
//            int readCount = -1;
//            while ((readCount = inputStream.read(buffer)) != -1) {
//                outputStream.write(buffer, 0, readCount);
//            }
                inputStream.transferTo(outputStream);
            }
        }
    }
}

