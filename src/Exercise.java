/*
Constructor class for creating new exercises. Currently, the getter methods are redundant, but I'm leaving them in
case I decide to use them in some way in the future. No default constructor is needed
 */
public class Exercise {
    private String exercise;
    private String location;
    private String weighted;
    String muscleLocation;

    public Exercise(String newExercise, String newLocation, String newWeighted, String newMuscleLocation){
        this.exercise = newExercise;
        //Three options: Home, Gym, Both
        this.location = newLocation;
        //Three Options: Yes, No, Optional
        this.weighted = newWeighted;
        //Multiple Option: Biceps, Triceps, Calves, etc.
        this.muscleLocation = newMuscleLocation;
    }
    //Setter methods for the 4 current parameters for
    public void setExercise(String newExercise){ this.exercise = newExercise; }
    public void setLocation(String newLocation){ this.location = newLocation; }
    public void setWeighted(String newWeighted){ this.weighted = newWeighted; }
    public void setMuscleLocation(String newMuscleLocation){ this.muscleLocation = newMuscleLocation; }
    public String getExercise(){
        return this.exercise;
    }
    public String getLocation(){
        return this.location;
    }
    public String getWeighted(){
        return this.weighted;
    }
    public String getMuscleLocation(){
        return this.muscleLocation;
    }

    public String toString(){
        return String.format("\n\t%s, %s, %s, %s", exercise, location, weighted, muscleLocation);
    }


}
