import java.util.ArrayList;
/*
Constructor for ArrayList ExerciseSet. No default constructor is needed. Currently, not in use
 */
public class Exercises {
    private String exerciseSetName;
    private ArrayList<Exercise> exercises;

    //Constructor with user input
    public Exercises(String newExerciseSetName){
        this.exerciseSetName = newExerciseSetName;
        this.exercises = new ArrayList<Exercise>();
    }

    //Setter method
    public void setExerciseSetName(String newExerciseSetName){ this.exerciseSetName = newExerciseSetName; }

    //Getter methods
    //Currently this method is redundant, but I'm leaving it for now in case I decide to use it in the future
    public String getExerciseSetName() { return exerciseSetName; }
    public ArrayList<Exercise> getExercises(){ return exercises; }

    //Add exercise to the exercises ArrayList
    public void addExercise(Exercise e){ exercises.add(e); }

    //Returns the number of exercises in the exercises ArrayList
    public int getNumExercises() {return exercises.size(); }

    public String toString(){
        String s = exerciseSetName;
        for(int i = 0; i < exercises.size(); i++){
            s += (exercises.get(i).toString());
        }
        return s;
    }
}
