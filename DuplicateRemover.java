import java.io.File;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.HashSet;


public class DuplicateRemover
{
    private HashSet<String> uniqueWords;

    public void remove(String dataFile) throws IOException
    {
        FileInputStream fileByteStream = new FileInputStream(dataFile);
        uniqueWords = new HashSet<String>();
        Scanner scnr;
        scnr = new Scanner (fileByteStream);
        String currWord;

        while(scnr.hasNext())
        {
            currWord = scnr.next();
            uniqueWords.add(currWord);
        }

        fileByteStream.close();
    }

    public void write(String outputFile) throws IOException
    {
        String currWord;
        FileWriter file;
        File output = new File(outputFile);

        if(output.exists())
        {
            file = new FileWriter(output);
            Iterator<String> itr = uniqueWords.iterator();

            while(itr.hasNext())
            {
                currWord = itr.next();
                file.write(currWord + " ");
            }

            file.close();
        }

        else
        {
            output.createNewFile();
            file = new FileWriter(output);
            Iterator<String> itr = uniqueWords.iterator();

            while(itr.hasNext())
            {
                currWord = itr.next();
                file.write(currWord + "\n");
            }

            file.close();
        }

    }
}


