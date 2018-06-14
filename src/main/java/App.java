import food.foodModel.FoodGenre;
import layout.gamescreen.GameScreen;
import match.Match;

import pimpek.pimpekModel.PimpekGenre;

import supplier.BasicSupplier;
import supplier.Supplier;
import javafx.application.Application;
import javafx.stage.Stage;
import configuration.Configuration;
import configuration.WorldConfiguration;
import world.Board;

public class App extends Application {

    void run(String... args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Supplier supplier = buildSupplier();
        Match match = supplier.getNewMatch();
        Board board = match.getBoard();

        primaryStage.setTitle("The Pimpki game");

        GameScreen gameScreen = new GameScreen(board.getGridPane(), match);
        primaryStage.setFullScreen(true);
        primaryStage.setScene(gameScreen.buildScene());
        primaryStage.show();

        Thread duel = new Thread(match);
        duel.start();
    }

    private Configuration buildConfig() {

        Configuration configuration = WorldConfiguration.getInstance(10, 10,
                1, 10,
                140, 100, 100);
        configuration.addPimpeksQuantityByGenre(PimpekGenre.PACIFIST, 3);
        configuration.addFoodQuantityByGenre(FoodGenre.APPLE, 5);
        return configuration;
    }

    private Supplier buildSupplier() {
        return BasicSupplier.getInstance(buildConfig());
    }
}
