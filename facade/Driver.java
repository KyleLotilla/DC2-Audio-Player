package facade;
import java.io.File;

public class Driver {
	public static void main (String args[]) {
		File fileAudio = new File("song.mp3");
		FilePlayer fPlayer = new FilePlayer();
		fPlayer.playFile(fileAudio);
	}
}
