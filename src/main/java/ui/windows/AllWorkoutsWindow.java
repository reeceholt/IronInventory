package ui.windows;

import backend.services.WorkoutService;
import com.googlecode.lanterna.gui2.*;
import models.Exercise;
import models.Workout;
import ui.UIController;


import java.util.List;


public class AllWorkoutsWindow extends BasicWindow {

    private final UIController ui;
    private final WorkoutService service;


    public AllWorkoutsWindow(UIController ui, WorkoutService service) {
        super("All Workouts");
        this.ui = ui;
        this.service = service;

        setHints(List.of(Hint.CENTERED));
        setComponent(build());
    }


    private record MenuItem(String name, Runnable func) {
    }

    //mehthod for workoutPage
    private Component build() {
        Panel panel = new Panel();
        panel.setLayoutManager(
                new LinearLayout(Direction.VERTICAL) //new GridLayout(num Columns)
        );

        ActionListBox alb = new ActionListBox();
        panel.addComponent(alb);

        List<Workout> workouts = service.getAllWorkouts();

        for (Workout w : workouts) {
            alb.addItem(w.name(), () -> ui.showWorkoutPage(w.id()));
        }
        alb.addItem("Back", () -> ui.closeWindow(this));

        return panel;
    }
}
