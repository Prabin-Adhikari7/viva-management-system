/*
    There are two components according to user's choice
    If repitition  not allowed then it generates random number in range (0, size)
    Then it picks the element placed in that random Index
    And then removes that element from arraylist to avoid repitition
 */

package JavaFiles;
//Importing requirements
import java.util.ArrayList;
import java.util.Random;
//Class Starts
public class PickRandomFromList {
    Random random = new Random();
    //return random element from that index
    public String withoutRepitition(ArrayList<String> nameOfList){
        //delete that from array list after printing.
        int randomIndex = random.nextInt(nameOfList.size());
        String randomContent = nameOfList.get(randomIndex);
        nameOfList.remove(randomIndex);
        return randomContent;
    }
    public String withRepetition(ArrayList<String> nameOfList){
        int randomIndex = random.nextInt(nameOfList.size());
        String randomContent = nameOfList.get(randomIndex);
        return randomContent;
    }

}
