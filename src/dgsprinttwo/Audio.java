package dungeonrun;


import java.io.File;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexa
 */
public class Audio {
    public static void playMusic(String filePath){
        File musicPath = new File(filePath);
        InputStream music;
        try{
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            //music=new FileInputStream(new File(filePath));
            //AudioStream audios = new AudioStream(music);
            //AudioPlayer.player.start(audios);
        }catch(Exception e){
            System.out.println("Error");
        }
        
    }
}
