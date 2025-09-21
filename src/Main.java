import view.ApplicationView;

public class Main {
	public static void main(String args[]){
		try {
            ApplicationView window = new ApplicationView();
            window.frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    };
}
	
