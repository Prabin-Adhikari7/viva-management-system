/*
It takes path of file to write and writes content in that file
 */

package JavaFiles;
//Importing Requirements
import java.io.FileWriter;
//
public class WriteInFile {
    String fileNameToWrite;
    public void writeInFile(String content) throws Exception{
        //write content in file and close.
        FileWriter fileWriter = new FileWriter(fileNameToWrite,true);
        fileWriter.write(content);
        fileWriter.write("\n");
        fileWriter.close();
    }
    //constructor to pass file name to write.
    public WriteInFile(String fileNameToWrite){
        this.fileNameToWrite = fileNameToWrite;
    }
}
