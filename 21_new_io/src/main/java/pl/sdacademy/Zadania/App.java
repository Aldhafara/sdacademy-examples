package pl.sdacademy.Zadania;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class App {
    public static void main(String[] args) {
        String inputPath = "files" + File.separator + "sourceFile.txt";
        String outputPath = "21_new_io" + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "pl" + File.separator + "sdacademy" + File.separator +
                "Zadania" + File.separator + "destFile1.txt";

        RandomAccessFile inputFile = null;
        RandomAccessFile outputFile = null;
        int lenght = 0;
        try {
            inputFile = new RandomAccessFile(inputPath, "r");
            outputFile = new RandomAccessFile(outputPath, "rw");
            outputFile.seek(outputFile.length()); //works like append mode in classic io - set pointer to the end of file
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileChannel inChannel = inputFile.getChannel();
        FileChannel outChannel = outputFile.getChannel();

        ByteBuffer inBufor = ByteBuffer.allocate(48);
        ByteBuffer outBufor = ByteBuffer.allocate(48);

        int bytesRead;
        StringBuilder builder = new StringBuilder();

        try {
            bytesRead = inChannel.read(inBufor);

            while (bytesRead != -1) {

                System.out.println("\n ##Przeczytałem " + bytesRead + " bajtów ## \n");
                inBufor.flip();


                while (inBufor.hasRemaining()) {
                    byte znak = inBufor.get();
                    builder.append((char) znak);
                    //System.out.print((char) znak);
                    if (builder.toString().endsWith("\n")){

                        System.out.print("Nowa linia: " + builder.toString());
                        builder = new StringBuilder();
                    }
                    outBufor.put(znak);
                }

                inBufor.clear();
                bytesRead = inChannel.read(inBufor);

                outBufor.flip();
                outChannel.write(outBufor);
                outBufor.clear();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputFile.close();
                outputFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
