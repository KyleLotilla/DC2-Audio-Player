package facade;
import java.io.File;

import fileAPI.AudioFileAPI;
import fileAPI.AudioFileAPIFactory;
import fileAPI.AudioFileExtenAPIFactory;
import playbackControl.PlaybackControl;
import playbackControl.PlaybackControlObservable;
import playbackControl.PlaybackController;
import playerProgress.PlaybackProgressObservable;
import playerProgress.ProgressObserverList;
import playerState.PlaybackStateObservable;
import playerState.StateObserverList;
import view.AudioPlayerView;

public class FilePlayer {
	private AudioFileAPIFactory apiFactory;
	private PlaybackControlObservable playbackCtrlObservable;
	private PlaybackProgressObservable progObservable;
	private ProgressObserverList progObservers;
	private PlaybackStateObservable stateObservable;
	private StateObserverList stateObservers;
	private AudioPlayerView playerView;
	
	public FilePlayer() {
		apiFactory = new AudioFileExtenAPIFactory();
		playbackCtrlObservable = new PlaybackController();
		progObservers = new ProgressObserverList();
		stateObservers = new StateObserverList();
		playerView = new AudioPlayerView();
		
		playbackCtrlObservable.addObserver(playerView.getBtnPlayback());
		playbackCtrlObservable.addObserver(playerView.getBtnSeekBack());
		playbackCtrlObservable.addObserver(playerView.getBtnSeekForward());
		
		progObservers.addObserver(playerView.getLblSecondPos());
		
		stateObservers.addObserver(playerView.getBtnPlayback());
		stateObservers.addObserver(playerView.getBtnSeekBack());
		stateObservers.addObserver(playerView.getBtnSeekForward());
		stateObservers.addObserver(playerView.getLblSecondPos());
	}
	
	public void playFile(File fileAudio) {
		AudioFileAPI audioAPI= apiFactory.creatAudioFileAPI(fileAudio);
		PlaybackControl playbackCtrl = audioAPI.createPlaybackControl();
		playbackCtrlObservable.setPlaybackControl(playbackCtrl);
		progObservable = audioAPI.createProgressObservable();
		progObservable.newObserver(progObservers);
		stateObservable = audioAPI.createStateObservable();
		stateObservable.newObserver(stateObservers);
		playbackCtrl.play();
	}
}
