package de.codecentric.centerdevice.javafxsvg.mytry;

import java.io.InputStream;

import org.junit.BeforeClass;

import de.codecentric.centerdevice.javafxsvg.SvgImageLoaderFactory;
import de.codecentric.centerdevice.javafxsvg.*;
import de.codecentric.centerdevice.javafxsvg.dimension.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MyTry extends Application {
	
	@BeforeClass
	public static void installSvgLoader() {
		SvgImageLoaderFactory.install();
	}


	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("MyTry");
		InputStream imageData = this.getClass().getClassLoader()
				.getResourceAsStream("bacon.svg");
		
//		System.out.println("about to print imageData");
//		System.out.println(imageData.toString());
		
		Image image = new Image(imageData);
		ImageView imageView = new ImageView(image);
		imageView.setId("TestImage");
		
		StackPane root = new StackPane();
		root.getChildren().add(new Button("button"));
		root.getChildren().add(imageView);
		
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
