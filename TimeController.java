package application;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class TimeController implements Initializable {
	
	
	
	
	@FXML
	private Label time;
	private volatile boolean stop = false;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		CurrentTime();
	}
	
	@FXML
	private void Close_clicked(MouseEvent event) {
		stop=true;
		javafx.application.Platform.exit();
	}
	
	private void CurrentTime() {
		Thread thread = new Thread(()->{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			while(!stop) {
				try {
					Thread.sleep(1000);
				}catch(Exception e){
					System.out.println(e);
					
				}
				final String timenow = sdf.format(new Date());
				Platform.runLater(()->{
					time.setText(timenow);
				});
				
				
			}
			
		});
		thread.start();

	}

}
