package pl.sdacademy.Zadania;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
       // String inputPath = "files" + File.separator + "sourceFile.txt";
        String outputPath = "21_new_io" + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "pl" + File.separator + "sdacademy" + File.separator +
                "Zadania" + File.separator + "destFile2.txt";

        RandomAccessFile inputFile = null;
        RandomAccessFile outputFile = null;
        int size = 48;

        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String text=new String();


        try {
           // inputFile = new RandomAccessFile(inputLine, "r");
            outputFile = new RandomAccessFile(outputPath, "rw");
            outputFile.seek(outputFile.length()); //works like append mode in classic io - set pointer to the end of file
        } catch (IOException e) {
            e.printStackTrace();
        }
       // FileChannel inChannel = inputLine.getChannel();
        FileChannel outChannel = outputFile.getChannel();

      //  ByteBuffer inBufor = ByteBuffer.allocate(size);
        ByteBuffer outBufor = ByteBuffer.allocate(size);

        int bytesRead;
        StringBuilder builder = new StringBuilder();

        try {
          //  bytesRead = inChannel.read(inBufor);

            while(!inputLine.equals("exit")){
                    text += inputLine;
                    inputLine = scanner.nextLine();
                }


                char[] charArr = text.toCharArray();
                int buffIdx = 0;
                for (int i = 0; i <charArr.length ; i++) {

                    if (buffIdx<size){
                        //System.out.println(buffIdx);
                        outBufor.put((byte)charArr[i]);
                        buffIdx++;
                    }else{
                        outBufor.flip();
                        outChannel.write(outBufor);
                        outBufor.clear();
                        buffIdx = 0;
                    }

                }if(outBufor.hasRemaining()) { //last buffer can be not fulfilled to the edge (it can contain
                // less data than its size, then we won't execute "else" from previous if-else
                // statement in the for loop), then we need to do one additional write to the file
                outBufor.flip();
                outChannel.write(outBufor);
                outBufor.clear();
            }




               // inBufor.clear();
              //  bytesRead = inChannel.read(inBufor);



            //}
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /*
            try {
               // inputFile.close();
               // outputFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            */
        }

    }
}
