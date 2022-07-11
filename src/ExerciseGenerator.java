import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
//TODO: Create a major data set of exercises that can appear
public class ExerciseGenerator{
    static Scanner inUser = new Scanner(System.in);

    public static ArrayList<String> readData(File inputFile) throws FileNotFoundException {
        Scanner inFile = new Scanner(inputFile);
        ArrayList<String> list = new ArrayList<>();
        while(inFile.hasNext()){
            list.add(inFile.nextLine());
        }
        return list;
    }

    public static ArrayList<Exercise> buildObjects(ArrayList<String> lines){
        ArrayList<Exercise> exercises = new ArrayList<Exercise>();
        String exerciseName, location, weighted, muscleLocation;
        for(String s : lines){
            String[] tokens = s.split(",");
            exerciseName = tokens[0];
            location = tokens[1];
            weighted = tokens[2];
            muscleLocation = tokens[3];
            Exercise exerciseObject = new Exercise(exerciseName, location, weighted, muscleLocation);
            exercises.add(exerciseObject);
        }
        return exercises;
    }

    //Method to allow user to create new exercise objects


    //TODO: User input as parameters for an if statement check (inside for loop)
    public static void RandomExercise(ArrayList<Exercise> exercises){
        System.out.print("Enter the number of exercises you want: ");
        int n = inUser.nextInt();
        System.out.print("Enter the location, or type n for no preference: ");
        String location = inUser.nextLine();
        System.out.print("Enter if the exercise is weighted or not, or type n for no preference: ");
        String weighted = inUser.nextLine();
        System.out.print("Enter the muscle you want to target, or press n for no preference: ");
        String muscleLocation = inUser.nextLine();
        for(int i = 0; i <= n; i++){

        }
    }

    public static void UserAddedExercise(){
        //Asking for user input to determine parameters of the new exercise object
        System.out.print("Enter the exercise name: ");
        String exe = inUser.nextLine();
        System.out.print("Enter the location for the exercise: ");
        String loc = inUser.nextLine();
        System.out.print("Enter if the exercise is weighted or not: ");
        String w = inUser.nextLine();
        System.out.print("Enter the the muscle location exercised: ");
        String ml = inUser.nextLine();
        //Creating the new exercise object
        Exercise e = new Exercise(exe,loc,w,ml);
        //Adding the exercise object to the ArrayList exercises
        //TODO: Implement way for the exercises to the major data set (which will eventually be created)
    }

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
            System.out.print("Select 1 if you would like to add a new exercise, or 2 if you would like to generate a random exercise set: ");
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
