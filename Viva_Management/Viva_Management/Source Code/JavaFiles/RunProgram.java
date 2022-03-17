package JavaFiles;
import java.util.ArrayList;
import java.util.Scanner;

public class RunProgram {
    //creating instances for all requirements
    public static MakeListOfContents makeListOfContents = new MakeListOfContents();
    public static ArrayList<String> listOfQuestions = new ArrayList<>();
    public static ArrayList<String> listOfStudents = new ArrayList<>();
    public static PickRandomFromList pickRandomFromList = new PickRandomFromList();
    private static String question="";
    private static String student="";
    private static int timeToAnswerTheQuestion=1000;
    private static int loadingTime=100;
    private static ArrayList<String> settingDetails = new ArrayList<>();
    private static String questionFilePath;
    private static String studentFilePath;
    private static String remainingStudentFilePath;
    private static String resultFilePath;
    //main method
    public static void main(String[] args) throws Exception {
        //creating message object
        print("Welcome To Viva!\n");
        //read from setting detail path
        makeListOfContents.makeListOfContents("D://1st sem/programming fundamentals/Viva_Management/src/Teacher/DetaileOfSettings",settingDetails);
        //arrangements
        questionFilePath = settingDetails.get(0);
        studentFilePath = settingDetails.get(1);
        resultFilePath = settingDetails.get(2);
        remainingStudentFilePath = settingDetails.get(3);
        //program run
        runProgram();

    }
    // to run our program
    public static void runProgram() throws Exception {
        //creating an array List to store contents in list
        makeListOfContents.makeListOfContents(questionFilePath, listOfQuestions);
        //creating array list to store students name
        makeListOfContents.makeListOfContents(studentFilePath, listOfStudents);
        //asking for repitition.
        print("Repeated question or not?(y[is default] or n): ");
        Scanner checkRept = new Scanner(System.in);
        char option = checkRept.next().charAt(0);
        //run program until quit
        while (true) {
            print("Enter any key except(But q for quit):");
            Scanner sc = new Scanner(System.in);
            char checkQuit = sc.next().charAt(0);
            //check for quit
            if (checkQuit == 'q' || listOfStudents.size()==0)
            {
                print("Viva Finished! Thank you!");
                break;
            }
            //if question finished
            else if(listOfQuestions.size()==0)
            {
                print("Question Collection Finished.");
                print("\nRemaining students be Prepared for tomorrow.");
                break;
            }
            else
            {
                askRepititionAndRun(option);
            }
        }
        writeRemaining();
    }
    //handle repitition
    public static void askRepititionAndRun(char options) throws Exception {
        student = pickRandomFromList.withoutRepitition(listOfStudents);
        WriteInFile writeInFile = new WriteInFile(resultFilePath);
        //checking option.
        switch (options){
            case 'n':
                question = pickRandomFromList.withoutRepitition(listOfQuestions);
                break;
            default:
                question = pickRandomFromList.withRepetition(listOfQuestions);
        }
        //starting animation to print question
        startAnimation("Loading",loadingTime,".");
        print("\n"+student + " : " + question);
        //Time to answer the question
        startAnimation("\nTime Chart:|",timeToAnswerTheQuestion,"-");
        print("|\nMarks Obtained:");
        //asking for marks
        Scanner askMarks = new Scanner(System.in);

        String marksObtained = askMarks.nextLine();

        //writing content in file.
        writeInFile.writeInFile((student + " : " + marksObtained));
    }
    //create animation of loading
    public static void startAnimation(String message,int time,String toShow) throws Exception{
        print(message);
        for(int i=0;i<10;i++){
            print(toShow);
            Thread.sleep(time);
        }
    }
    //writing remaining students in file
    public static void writeRemaining() throws Exception{
        WriteInFile forRemainingStudents = new WriteInFile(remainingStudentFilePath);
        //if viva is finished then ignore
        if(listOfStudents.size()!=0){
            for(int i=0;i< listOfStudents.size();i++){
                forRemainingStudents.writeInFile(listOfStudents.get(i));
            }
        }
    }

    // to print message.
    public static void print(String message){
        System.out.print(message);
    }
}
