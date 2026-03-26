package backend.services;

import backend.repositories.ExerciseRepo;
import backend.repositories.WorkoutRepo;
import models.Exercise;
import models.Workout;
import ui.windows.NewWorkoutWindow;

import java.util.List;

public class WorkoutService {
    private final WorkoutRepo repo;
    private final ExerciseRepo exerciseRepo;
    public WorkoutService(WorkoutRepo workoutRepo, ExerciseRepo exerciseRepo) {
        repo = workoutRepo;
        this.exerciseRepo = exerciseRepo;
    }

    public List<Workout> getAllWorkouts() {
        return repo.getWorkouts();
    }
    public Workout getWorkoutInfo(int id) {return repo.getWorkout(id);}

    public void removeWorkout(long id){repo.deleteWorkout(id);}

    public List<Exercise> getAllExercises() { return exerciseRepo.getExercises(); }
    public Exercise getExerciseInfo(long id) {
        return exerciseRepo.getExercise(id);
    }
    public List<String> getAllExerciseNames() {
        return exerciseRepo.getExerciseNames();
    }
    public long addExercise(Exercise exercise) {
        return exerciseRepo.addExercise(exercise);
    }
    public void removeExercise(long id){exerciseRepo.deleteExercise(id);}
    public void changeExercise(Exercise e){exerciseRepo.updateExercise(e);}


}
