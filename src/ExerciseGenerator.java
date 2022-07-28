import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExerciseGenerator{
    //Create class wide scanner
    static Scanner inUser = new Scanner(System.in);

    /*
    Method to read in data from the exercises file. It then creates an exercise object based on the data from each of the lines
    and then adds that object to the arrayList previously declared
     */
    public static ArrayList<Exercise> readData(File inputFile) throws FileNotFoundException {
        //Create new arrayList
        ArrayList<Exercise> list = new ArrayList<>();
        //Scanner object with all the inputFile's data
        Scanner inFile = new Scanner(inputFile);
        //While loop that checks to see if the Scanner has another line, and if it does, iterate overs that line
        while(inFile.hasNextLine()){
            //create new tokens array and split each line where there is a comma, and then store it in the tokens array
            String[] tokens = inFile.nextLine().split(",");
            //Creating new exercise object and then adding it to the arrayList
            Exercise newExercise = new Exercise(tokens[0], location.valueOf(tokens[1]), weighted.valueOf(tokens[2]), muscleLocation.valueOf(tokens[3]));
            list.add(newExercise);
        }
        //Close the scanner object which read in the inputFile data
        inFile.close();
        //Returning the arrayList
        return list;
    }

    /*
    Method to allow user to create new exercise objects and add it to the exercises arrayList. Errors will be thrown depending on how the user inputs
    data into the program.
     */
    public static ArrayList<Exercise> UserAddedExercise(ArrayList<Exercise> exercises) throws ArrayIndexOutOfBoundsException, IllegalArgumentException{
        try{
            //Asking for user input to determine parameters of the new exercise object
            System.out.print("Enter the exercise name, location, if it is weighted or not, and the muscle exercised, each separated by a comma and no space: ");
            String s = inUser.next();
            //Create new tokens array, and split the above String wherever there is a comma, and then store it in the tokens array
            String[] tokens = s.split(",");
            Exercise e = new Exercise(tokens[0],location.valueOf(tokens[1]),weighted.valueOf(tokens[2]),muscleLocation.valueOf(tokens[3]));
            exercises.add(e);
            //Creating the new exercise object, adding it to the arrayList read into the method, and then returning that arrayList
        } catch(ArrayIndexOutOfBoundsException e){
            //Catch the error if there are spaces after the comma and prints out a statement as to why the program then exits
            System.out.println("There were spaces after your commas in your input. There cannot be spaces after the comma for the program to run properly");
            System.exit(0);
        } catch (IllegalArgumentException e){
            //Catch the error if one of the user's inputs does not match one of the enumerator types
            System.out.println("This program does not recognize either the location, whether the exercise is weighted or not, or muscle location the user entered");
            System.exit(0);
        }
        return exercises;
    }
    
    //Method to determine what parameters the randomly generated exercises will have
    //TODO: User input as parameters for an if statement check (inside for loop)
    public static ArrayList<Exercise> RandomExercise(ArrayList<Exercise> exercises){
        ArrayList<Exercise> randomExercises= new ArrayList<>();
        //TODO: Use previous method of tokenizing user input, and shrinking print statement
        System.out.print("Enter the number of exercises you want: ");
        int n = inUser.nextInt();
        System.out.print("Enter the location, or type n for no preference: ");
        String randomLocation = inUser.nextLine();
        System.out.print("Enter if the exercise is weighted or not, or type n for no preference: ");
        String randomWeighted = inUser.nextLine();
        System.out.print("Enter the muscle you want to target, or press n for no preference: ");
        String randomMuscleLocation = inUser.nextLine();
        //TODO: Use for loop to add exercises to random exercises arrayList with exercises based on user input
        for(int i = 0; i <= n; i++){
            for(Exercise e : exercises){
                location location = e.getLocation();
                weighted weighted = e.getWeighted();
                muscleLocation muscleLocation = e.getMuscleLocation();
                //TODO: if statements to check user's input and then add them to the arrayList exercises that will be returned
                if(randomLocation.equals(location.valueOf()));
            }
        }
        return randomExercises;
    }
    
    //TODO: Add in display method for random exercises arrayList

    public static void main(String[] args)  {
        //Reading in the exercises text document and checking if it exists or not
        File inputFile = new File("src/exercises.txt");
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
            ArrayList<Exercise> exercises = readData(inputFile);
            System.out.print("Select 1 if you would like to add new exercises, or 2 if you would like to generate a random exercise set: ");
            int x = inUser.nextInt();
            if(x == 1){
                String s;
                //do-while loop which will call on the UserAddedExercise method, then checks if user wants to add another exercise
                //TODO: First two print statements occur when the UserAddedExercise() method is called. Need to fix this
                do{
                    UserAddedExercise(exercises);
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
    }
}
