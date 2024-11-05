package Controller;

import javax.sound.sampled.*;
import java.io.*;

public class MusicController {
    private static Clip clip;
    private static Clip newClip;
    private static boolean paused;
    private static long pausedPosition;

    public static void startMusic(String musicName){
    	
        try {
            InputStream inputStream = MusicController.class.getClassLoader().getResourceAsStream(musicName);
            if (inputStream == null) {
                System.out.println("File not found");
            } else {
	            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
	            // Create an AudioInputStream from the buffered input stream
	            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedInputStream);
	            clip = AudioSystem.getClip();
	            clip.open(audioStream);
	            clip.start();
	            setPaused(false);
	            
	            // don't stop the music
	            clip.addLineListener(event -> {
	        	    if (event.getType() == LineEvent.Type.STOP) {
	        	    	 if(!isPaused()) {
	        	    	startMusic(musicName);
	        	    }
	        	    }
	        	});
            
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    	
    }
    
   
    public void stopMusic() {
        if (clip != null) {
            clip.stop();
            setPaused(true);
            clip.close();
        }
    }

    public static void pauseMusic() {
        if (clip != null){
            pausedPosition = clip.getMicrosecondPosition();
            clip.stop();
            setPaused(true);
        }
        if (newClip != null) {
            newClip.stop();
            newClip.close();
        }
    }

    public static void resumeMusic() {
    	 try {
                 clip.setMicrosecondPosition(pausedPosition); // Set the position to where it was stopped
                 clip.start();
                 setPaused(false);  
         } catch (Exception ex) {
             ex.printStackTrace();
         }
    }
    
    public static void addMusic(String musicName) {
    	if(!isPaused()){
   	 try {
   		InputStream inputStream = MusicController.class.getClassLoader().getResourceAsStream(musicName);
            if (inputStream == null) {
                System.out.println("File not found");
            } else {
                // Wrap the input stream in a BufferedInputStream
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                
                // Create an AudioInputStream from the buffered input stream
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedInputStream);
                if(newClip == null) {
                newClip = AudioSystem.getClip();
                newClip.open(audioStream);
                newClip.start();
                }
                else {
                	newClip= null;
                	 newClip = AudioSystem.getClip();
                     newClip.open(audioStream);
                     newClip.start();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
   }
    }


	public static boolean isPaused() {
		return paused;
	}


	public static void setPaused(boolean paused) {
		MusicController.paused = paused;
	}
}
