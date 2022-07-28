/*
Constructor class for creating new exercises. Currently, the getter methods are redundant, but I'm leaving them in
case I decide to use them in some way in the future. No default constructor is needed
 */
//TODO: Change muscleLocation from a String to an enumerator class
public class Exercise {
    private String exercise;
    private location location;
    private weighted weighted;
    private muscleLocation muscleLocation;

    public Exercise(String newExercise, location newLocation, weighted newWeighted, muscleLocation newMuscleLocation){
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
    public void setLocation(location newLocation){ this.location = newLocation; }
    public void setWeighted(weighted newWeighted){ this.weighted = newWeighted; }
    public void setMuscleLocation(muscleLocation newMuscleLocation){ this.muscleLocation = newMuscleLocation; }
    public String getExercise(){
        return this.exercise;
    }
    public location getLocation(){
        return this.location;
    }
    public weighted getWeighted(){
        return this.weighted;
    }
    public muscleLocation getMuscleLocation(){
        return this.muscleLocation;
    }

    public String toString(){
        return String.format("\n\t%s, %s, %s, %s", exercise, location, weighted, muscleLocation);
    }


}
