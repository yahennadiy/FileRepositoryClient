package repository.fileoperations.download;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class BrowseRunner extends Thread {
    private final boolean browseSupported;
    public BrowseRunner() {
        super();
        browseSupported = Desktop.getDesktop().isSupported(Desktop.Action.BROWSE);
        start();
    }

    public void run() {
        if (browseSupported) {
            try {
                String targetDirString = TargetFilesPathCreator.get();
                Desktop.getDesktop().browse(new URI("file:" + targetDirString));
            } catch (URISyntaxException | IOException exc) {
                exc.printStackTrace();
            }
        }
    }
}
