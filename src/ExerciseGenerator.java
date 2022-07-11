import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExerciseGenerator{
    //Create class wide scanner
    static Scanner inUser = new Scanner(System.in);

    //Method to read in data from the file read into the program, with each index in the arrayList containing a line from the read in file
    public static ArrayList<String> readData(File inputFile) throws FileNotFoundException {
        Scanner inFile = new Scanner(inputFile);
        //Create new arrayList
        ArrayList<String> list = new ArrayList<>();
        //While loop that adds each line in the text file into the arrayList
        while(inFile.hasNext()){
            list.add(inFile.nextLine());
        }
        //Returning the arrayList
        return list;
    }

    //Method to take data from read in text file and have those files converted into exercise objects
    public static ArrayList<Exercise> buildObjects(ArrayList<String> lines){
        //Creating new arrayList to be returned
        ArrayList<Exercise> exercises = new ArrayList<Exercise>();
        //Creating new constants
        String exerciseName, exerciseLocation, exerciseWeighted, exerciseMuscleLocation; 
        //For loop that takes each String in the lines arrayList and seperates them into their own string and adds them to the tokens array
        for(String s : lines){
            //Create new tokens array, and split the above String wherever there is a comma, and then store it in the tokens array
            String[] tokens = s.split(",");
            //Setting constants to a specific index in the tokens array
            exerciseName = tokens[0];
            location = tokens[1];
            weighted = tokens[2];
            muscleLocation = tokens[3];
            //Exercise object is created using the previously declared constants, and then added to the exercises array
            Exercise exerciseObject = new Exercise(exerciseName, exerciseLocation, exerciseWeighted, exerciseMuscleLocation);
            exercises.add(exerciseObject);
        }
        //Return the exercises arrayList
        return exercises;
    }

    //Method to allow user to create new exercise objects
    public static void UserAddedExercise(){
        //Asking for user input to determine parameters of the new exercise object
        System.out.print("Enter the exercise name, location, if it is weighted or not, and the muscle exercised, each seperated by a comma: ");
        String s = inUser.nextLine();
        //Create new tokens array, and split the above String wherever there is a comma, and then store it in the tokens array
        String[] tokens = s.split(",");
        //Setting constants to a specific index in the tokens array
        String exe = tokens[0];
        String loc = tokens[1];
        String w = tokens[2];
        String ml = tokens[3];
        //Creating the new exercise object
        Exercise e = new Exercise(exe,loc,w,ml);
        //TODO: Implement way for the exercises to the major data set
    }
    
    //Method to determine what parameters the randomly generated exercises will have
    //TODO: User input as parameters for an if statement check (inside for loop)
    public static ArrayList<Exercise> RandomExercise(ArrayList<Exercise> exercises){
        //TODO: Create arrayList exercises that will store the random exercises generated
        
        //TODO: Use previous method of tokenizing user input, and shrinkning print statment
        System.out.print("Enter the number of exercises you want: ");
        int n = inUser.nextInt();
        System.out.print("Enter the location, or type n for no preference: ");
        String location = inUser.nextLine();
        System.out.print("Enter if the exercise is weighted or not, or type n for no preference: ");
        String weighted = inUser.nextLine();
        System.out.print("Enter the muscle you want to target, or press n for no preference: ");
        String muscleLocation = inUser.nextLine();
        //TODO: Use for loop to add exercises to random exercises arrayList (not created yet), with exercises based on user input
        for(int i = 0; i <= n; i++){

        }
        //TODO: Add return statement
    }
    
    //Add in display method for random exercises arrayList

    //TODO: Read in a file properly so the system can manipulate it
    public static void main(String[] args)  {
        //Reading in the exercises text document and checking if it exists or not
        File inputFile = new File(args[0]);
        if(inputFile.exists()){
            System.out.println("Exercise data exists");

        } else{
            System.out.println("Exercise data does not exist");
            return;
        }
        /*
        Program attempts to read the text document in to have it start understanding the exercise data set
        If there is no file to be read in, program does not execute and throws an error
         */
        try{
            ArrayList<String> lines = readData(inputFile);
            ArrayList<Exercise> exercises = buildObjects(lines);
            System.out.print("Select 1 if you would like to add new exercises, or 2 if you would like to generate a random exercise set: ");
            int x = inUser.nextInt();
            if(x == 1){
                String s;
                //do-while loop which will call on the UserAddedExercise method, then checks if user wants to add another exercise
                //TODO: First two print statements occur when the UserAddedExercise() method is called. Need to fix this
                do{
                    UserAddedExercise();
                    System.out.print("Do you want to add another exercise? (Y/N) ");
                    s = inUser.nextLine();
                }while(s.equalsIgnoreCase("y"));
            }else if(x == 2){
                RandomExercise(exercises);
            }
            //else check to display user did not enter 1 or 2
            else{ System.out.println("1 or 2 were not selected"); }
        }catch (FileNotFoundException e){
            System.out.println(e);
        }

        //Check to see if user wants to add a new exercise to the ArrayList

    }

}
