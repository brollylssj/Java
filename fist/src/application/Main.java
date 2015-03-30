package application;
	


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.TriangleMesh;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			
			Scene scene = new Scene(root,600,600);
			
			Group root2 = new Group();
			Scene scene2 = new Scene(root2,600,600);
			
			
			
			prepareShapes(root);
			
			
			
			
			
			
			Label label = new Label("KNI");
			root2.getChildren().add(label);
			
		
			label.setOnMouseClicked(new EventHandler<Event>() {

				@Override
				public void handle(Event arg0) {
					primaryStage.setScene(scene);
					
				}
			});
			
			
			Button button = new Button("KNI");
			button.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					primaryStage.setScene(scene2);
						
				}
			});
			root.getChildren().add(button);
			//Stage   scena
			primaryStage.setScene(scene);
			primaryStage.show();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void prepareShapes(Group root) {
		// TODO Auto-generated method stub
		
		Circle circle = new Circle(100,100,13);
		root.getChildren().add(circle);
		Rectangle rectangle = new Rectangle(25,25,10,30);
		root.getChildren().add(rectangle);
		
		
		circle.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
			circle.setScaleX(circle.getOpacity() +10);
				
			}
		});
		
		rectangle.heightProperty().bind(rectangle.widthProperty().multiply(2));
		
		
		rectangle.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {
				rectangle.setWidth(rectangle.getWidth()+10);
				//rectangle.setHeight(rectangle.getHeight()+10);
				
			}
		});
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
