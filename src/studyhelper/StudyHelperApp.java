/*
 * StudyHelperApp.java
 */

package studyhelper;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class StudyHelperApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        try {
            show(new StudyHelperView(this));
        } catch (InterruptedException ex) {
            Logger.getLogger(StudyHelperApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of StudyHelperApp
     */
    public static StudyHelperApp getApplication() {
        return Application.getInstance(StudyHelperApp.class);
    }

    /**
     * Main method launching the application.
     */
    
    public static void main(String[] args) {
        launch(StudyHelperApp.class, args);
        
    }
}
