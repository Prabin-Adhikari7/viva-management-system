/* This file simply makes an array list of credentials.txt.
* 1.It asks username & password from scanner
* 2. It checks if username:password is contained in array list made of credentials.txt
* 3. If true it returns result. */

package Teacher;

import JavaFiles.MakeListOfContents;
import JavaFiles.WriteInFile;

import java.util.ArrayList;
import java.util.Scanner;

public class TeacherLogin {
    static MakeListOfContents makeListOfContents = new MakeListOfContents();
    static WriteInFile writeInFile = new WriteInFile("D://1st sem/programming fundamentals/Viva_Management/src/Teacher/DetaileOfSettings");
    private static  String username,password;
    private static ArrayList<String> forResult = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        print("Welcome Admin!");
        teacherSecret();
        //asking for username.
        print("Enter username: ");
        Scanner usernameAsk = new Scanner(System.in);
        username = usernameAsk.nextLine();
        //Asking for password
        print("Enter password: ");
        Scanner askPassword = new Scanner(System.in);
        password = askPassword.nextLine();
        //Viewing result from DetailOf Setting
        makeListOfContents.makeListOfContents("D://1st sem/programming fundamentals/Viva_Management/src/Teacher/DetaileOfSettings",forResult);
        //asking for file path to read.
        if(checkLogin()){
            showResult(forResult.get(2));
        }
        else{
            print("Wrong Credentials.");
        }
    }
    public static boolean checkLogin() throws Exception {
        ArrayList<String> checkList = new ArrayList<>();
        makeListOfContents.makeListOfContents("D://1st sem/programming fundamentals/Viva_Management/src/Teacher/credentials",checkList);
        String checkTo = username + ":" + password;
        //checking
        if(checkList.contains(checkTo))
        {
            return true;

        }
        else
        {
            return false;
        }
    }
    //view Result
    public static void showResult(String filePath) throws Exception {
        ArrayList<String> contentList = new ArrayList<>();
        makeListOfContents.makeListOfContents(filePath,contentList);
        //showing result
        for(int i=0;i<contentList.size();i++){
            print(contentList.get(i)+"\n");
        }
    }
    //print

    public static void print(String message){
        System.out.print(message);
    }
    //secret Message
    public static void teacherSecret(){
        print("To change file location visit DetaileOfSettings:\n");
        print("1. Is for question List\n");
        print("2. Is for student List\n");
        print("3. Is for Result List\n");
        print("4. Is for Remaining Student list.\n");
    }
}