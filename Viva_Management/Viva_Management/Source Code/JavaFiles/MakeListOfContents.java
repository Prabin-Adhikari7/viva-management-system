/*
    It reads file from provided location
    And appends each line to provided array list
 */


package JavaFiles;
//importing requirements
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
//
public class MakeListOfContents {
    //Make a list of file contents
    public  void makeListOfContents(String fileLocation, ArrayList<String> nameOfList) throws Exception {
        FileReader fr = new FileReader(fileLocation);
        //buffered reader
        BufferedReader br = new BufferedReader(fr);
        //creating an array list to insert contents of file into array.
        String content;
        while ((content = br.readLine()) != null) {
            //add into array list
            nameOfList.add(content);
        }
    }
}
