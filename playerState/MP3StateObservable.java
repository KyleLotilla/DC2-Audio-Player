package playerState;
import java.util.Map;

import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerListener;

public class MP3StateObservable implements PlaybackStateObservable, BasicPlayerListener {
	
	private PlaybackStateObserver stateObserObserver;

	public void notifyObservers(String sState) {
		stateObserObserver.playbackStateUpdated(sState);
	}

	public void newObserver(PlaybackStateObserver stateObserObserver) {
		this.stateObserObserver = stateObserObserver;
	}

	public void stateUpdated(BasicPlayerEvent eventState) {
		String sInitalStateDesc = eventState.toString();
		String sState[] = sInitalStateDesc.split(":");
		notifyObservers(sState[0]);
	}
	
	public void opened(Object arg0, Map arg1) {}
	public void progress(int arg0, long arg1, byte[] arg2, Map arg3) {}
	public void setController(BasicController arg0) {}
	
}
