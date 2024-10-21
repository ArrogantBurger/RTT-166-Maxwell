package labs.l_303_13_2;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class NioExampleTwo {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        //Input files
        String[] inputFiles = {"C:/Users/m2arc/Documents/Programming/PerScholas/RTT-116-Classwork/module-303/src/labs/l_303_13_2/file1.txt",
                "C:/Users/m2arc/Documents/Programming/PerScholas/RTT-116-Classwork/module-303/src/labs/l_303_13_2/file2.txt"};

        // Specify out file with path location
        //Files contents will be written in these files
        String outputFile = "C:/Users/m2arc/Documents/Programming/PerScholas/RTT-116-Classwork/module-303/src/labs/l_303_13_2/nioOutputTwo.txt";

        //Get channel for output file

        FileOutputStream fos = new FileOutputStream(outputFile);
        WritableByteChannel targetChannel = fos.getChannel();
        for (int i = 0; i < inputFiles.length; i++) {
            //Get channel for input files
            FileInputStream fis = new FileInputStream(inputFiles[i]);
            FileChannel inputChannel = fis.getChannel();

            //Transfer data from input channel to output channel
            inputChannel.transferTo(0, inputChannel.size(), targetChannel);

            //close the input channel
            inputChannel.close();
            fis.close();
        }

        //finally close the target channel
        targetChannel.close();
        fos.close();
    }
}

