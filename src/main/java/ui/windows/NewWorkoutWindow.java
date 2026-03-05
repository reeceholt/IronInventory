package ui.windows;

import backend.services.WorkoutService;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import models.Exercise;
import models.Set;
import models.Workout;
import models.WorkoutExercise;
import ui.UIController;

import java.util.List;

import static java.lang.Character.getName;
import static java.lang.Integer.parseInt;

public class NewWorkoutWindow extends BasicWindow{

    private final UIController ui;
    private final WorkoutService service;


    public NewWorkoutWindow(UIController ui, WorkoutService service) {
        super("Workout");
        this.ui = ui;
        this.service = service;
        setHints(List.of(Window.Hint.CENTERED));
        setComponent(build());
    }

    private Component build() {
        //Panel 1
        TextBox workoutName = new TextBox();
        TextBox notesInput = new TextBox("Workout Notes:");
        //Panel 2
        ComboBox<Exercise> exerciseComboBox = new ComboBox(service.getAllExerciseNames());
        TextBox repsInput = new TextBox("(int)").setPreferredSize(new TerminalSize(10, 1));
        TextBox weightInput = new TextBox("(int)").setPreferredSize(new TerminalSize(10, 1));

        Panel workoutPanel = new Panel()
                .setLayoutManager(new GridLayout(3))
                //Titles

                .addComponent(new Label("Exercise: "))
                .addComponent(new Label("Weight: "))
                .addComponent(new Label("Reps: "))
                //Inputs

                .addComponent(exerciseComboBox)
                .addComponent(weightInput)
                .addComponent(repsInput);


        Panel main = new Panel()
                .setLayoutManager(new LinearLayout(Direction.VERTICAL)) //new GridLayout(num Columns)
                .addComponent(new Label("Workout Name: "))
                .addComponent(workoutName)
                .addComponent(notesInput)
                .addComponent(workoutPanel);


        Button save = new Button("Save", () -> {
            Workout w = new Workout(0, workoutName.getText(), notesInput.getText());
            WorkoutExercise workoutExercise = new WorkoutExercise(0, w.id(), exerciseComboBox.getSelectedItem().id());
            Set s = new Set(0,workoutExercise, parseInt(weightInput.getText()), parseInt(repsInput.getText()));
        });
        Button b = new Button("Back", () -> ui.closeWindow(this));



//
         return main;

    }
}
