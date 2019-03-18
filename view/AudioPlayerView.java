package view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AudioPlayerView extends JPanel {
	private SecondsPositionLabel lblSecondPos;
	private SeekBackwardBtn btnSeekBack;
	private SeekForwardBtn btnSeekForward;
	private PlaybackBtn btnPlayback;
	private JFrame frame;
	
	public AudioPlayerView() {
		super(new FlowLayout());
		
		lblSecondPos = new SecondsPositionLabel();
		add(lblSecondPos);
		lblSecondPos.setBounds(100, 150, 50, 50);
		
		btnSeekBack = new SeekBackwardBtn();
		add(btnSeekBack);
		btnSeekBack.setBounds(150, 100, 50, 50);
		
		btnPlayback = new PlaybackBtn();
		add(btnPlayback);
		btnPlayback.setBounds(100, 100, 50, 50);
		
		btnSeekForward = new SeekForwardBtn();
		add(btnSeekForward);
		lblSecondPos.setBounds(50, 100, 50, 50);
		
		frame = new JFrame();
		frame.setSize(1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(this);
	}
	
	public SecondsPositionLabel getLblSecondPos() {
		return lblSecondPos;
	}
	
	public SeekBackwardBtn getBtnSeekBack() {
		return btnSeekBack;
	}
	
	public SeekForwardBtn getBtnSeekForward() {
		return btnSeekForward;
	}
	
	public PlaybackBtn getBtnPlayback() {
		return btnPlayback;
	}
}
