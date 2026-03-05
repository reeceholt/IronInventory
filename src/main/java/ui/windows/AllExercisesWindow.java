package ui.windows;

import backend.services.WorkoutService;
import com.googlecode.lanterna.gui2.*;
import models.Exercise;
import models.Workout;
import ui.UIController;

import java.util.List;
import java.util.Optional;

public class AllExercisesWindow extends BasicWindow {


    private final UIController ui;
    private final WorkoutService service;


    public AllExercisesWindow(UIController ui, WorkoutService service) {
        super("All Exercises");
        this.ui = ui;
        this.service = service;
        setHints(List.of(Window.Hint.CENTERED));
        setComponent(build());
    }

    private Component build() {
        Panel panel = new Panel();
        make(panel);
        return panel;
    }

    private void make(Panel panel){
        panel.setLayoutManager(
                new GridLayout(2)
        );

        ActionListBox alb = new ActionListBox();
        panel.addComponent(alb);

        ActionListBox deleteBox = new ActionListBox();
        panel.addComponent(deleteBox);

        List<Exercise> exercises = service.getAllExercises();

        for (int i = 0; i < exercises.size(); i++) {
            Exercise e = new Exercise(exercises.get(i));
            deleteBox.addItem("X",() -> {
                service.removeExercise(e.id());
                panel.removeAllComponents();
                make(panel);
            });
            alb.addItem(e.name(), () -> ui.showExercise(e.id()));

        }
        alb.addItem("Add New Exercise", () -> ui.showNewExercisePage());
        alb.addItem("Back", () -> ui.closeWindow(this));
    }
}
