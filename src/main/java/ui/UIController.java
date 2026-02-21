package ui;

import backend.services.WorkoutService;
import com.googlecode.lanterna.gui2.Window;
import ui.windows.*;

/*
Handles navigation
 */
public class UIController {

    private final Gui gui;
    private final WorkoutService workoutService;

    public UIController(Gui gui, WorkoutService workoutService) {
        this.gui = gui;
        this.workoutService = workoutService;
    }

    public void showMainMenu() {
        gui.show(new MainWindow(this));
    }

    public void showAllWorkoutsPage() {
        gui.show(new AllWorkoutsWindow(this, workoutService));
    }

    public void showWorkoutPage(int workoutId){
        gui.show(new WorkoutWindow(this, workoutService, workoutId));
    }

    public void showAllExercisesPage() {
        gui.show(new AllExercisesWindow(this, workoutService));
    }

    public void showExercise(int exerciseId){
        gui.show(new ExerciseWindow(this, workoutService, exerciseId));
    }




    public void closeWindow(Window window) {
        window.close();
    }

    public void closeApp() {
        gui.close();
    }

;
}
