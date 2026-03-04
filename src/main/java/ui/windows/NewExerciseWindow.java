package ui.windows;

import backend.services.WorkoutService;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import models.Exercise;
import ui.UIController;

import java.util.ArrayList;
import java.util.List;



public class NewExerciseWindow extends BasicWindow {

    private final UIController ui;
    private final WorkoutService service;

    public NewExerciseWindow(UIController ui, WorkoutService service) {
        super("All Exercises");
        this.ui = ui;
        this.service = service;
        setHints(List.of(Window.Hint.CENTERED));
        setComponent(build());
    }

    public Component build(){
        Panel main = new Panel()
                .setLayoutManager(new LinearLayout());
        TextBox exerciseInput = new TextBox().setPreferredSize(new TerminalSize(10, 1));
        TextBox musclesInput = new TextBox().setPreferredSize(new TerminalSize(10, 1));
        Panel exercisePanel = new Panel()
                .setLayoutManager(new GridLayout(2))
                .addComponent(new Label("Exercise: "))
                .addComponent(exerciseInput)
                .addComponent(new Label("Muscles Used: "))
                .addComponent(musclesInput);


        main.addComponent(exercisePanel);


        main.addComponent(new Panel().setLayoutManager(new GridLayout(2))
                        .addComponent(new Button("Back", () -> ui.closeWindow(this)))
                        .addComponent(new Button("Save", () ->
                        {
                            long exerciseID = service.addExercise(new Exercise(0, exerciseInput.getText(), musclesInput.getText()));
                        }

                        ))
        );

        return main;
    }


}
