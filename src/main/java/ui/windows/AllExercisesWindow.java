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
        panel.setLayoutManager(
                new LinearLayout(Direction.VERTICAL) //new GridLayout(num Columns)
        );

        ActionListBox alb = new ActionListBox();
        panel.addComponent(alb);

        List<Exercise> exercises = service.getAllExercises();

        for (Exercise e : exercises) {
            alb.addItem(e.name(), () -> ui.showExercise(e.id()));

        }
        alb.addItem("Back", () -> ui.closeWindow(this));

        return panel;
    }
}
