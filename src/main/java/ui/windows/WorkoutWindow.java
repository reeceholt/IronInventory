package ui.windows;

import backend.services.WorkoutService;
import com.googlecode.lanterna.gui2.*;
import models.Workout;
import ui.UIController;

import java.util.List;
import java.util.Optional;

public class WorkoutWindow extends BasicWindow {

    private final UIController ui;
    private final WorkoutService service;
    private final int workoutId;

    public WorkoutWindow(UIController ui, WorkoutService service, int workoutId) {
        super("Exercises");
        this.ui = ui;
        this.service = service;
        this.workoutId = workoutId;
        setHints(List.of(Window.Hint.CENTERED));
        setComponent(build());
    }




    private Component build() {
        Panel panel = new Panel();
        panel.setLayoutManager(
                new LinearLayout(Direction.VERTICAL) //new GridLayout(num Columns)
        );

        Workout w = service.getWorkoutInfo(workoutId);
        Button b = new Button("Back", () -> ui.closeWindow(this));


        panel.addComponent(new Label(w.name()));
        panel.addComponent(new Label(w.notes()));
        panel.addComponent(b);

        return panel;
    }

}
