package de.codecentric.centerdevice.javafxsvg;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import javax.swing.event.TreeWillExpandListener;

import org.junit.BeforeClass;
import org.junit.Test;
import org.loadui.testfx.GuiTest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TestLoadImageUsingFxml extends GuiTest {

	@BeforeClass
	public static void installSvgLoader() {
		SvgImageLoaderFactory.install();
	}

	@Override
	protected Parent getRootNode() {
		try {
			return FXMLLoader.load(getClass().getClassLoader().getResource(
					"imagetest.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Test
	public void imageShouldBeVisible() {
		ImageView imageView = find("#TestImage");
		Image image = imageView.getImage();

		assertNotNull(image);
		assertFalse(image.errorProperty().get());
	}
}
