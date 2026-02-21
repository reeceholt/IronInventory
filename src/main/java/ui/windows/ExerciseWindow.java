package ui.windows;

import backend.services.WorkoutService;
import com.googlecode.lanterna.gui2.*;
import models.Exercise;
import ui.UIController;

import java.util.List;
import java.util.Optional;

public class ExerciseWindow extends BasicWindow {

    private final UIController ui;
    private final WorkoutService service;
    private final int exerciseId;

    public ExerciseWindow(UIController ui, WorkoutService service, int exerciseId) {
        super("Exercises");
        this.ui = ui;
        this.service = service;
        this.exerciseId = exerciseId;
        setHints(List.of(Window.Hint.CENTERED));
        setComponent(build());
    }


    private record MenuItem(String name, Optional<String> mucles, Runnable func) {
    }

    private Component build() {
        Panel panel = new Panel();
        panel.setLayoutManager(
                new LinearLayout(Direction.VERTICAL) //new GridLayout(num Columns)
        );

        Exercise e = service.getExerciseInfo(exerciseId);
        Button b = new Button("Back", () -> ui.closeWindow(this));

        panel.addComponent(new Label(e.name()));
        panel.addComponent(new Label(e.muscles()));
        panel.addComponent(b);

        return panel;
    }

}
