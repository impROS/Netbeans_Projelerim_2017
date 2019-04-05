/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendemail;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Properties;
import javafx.scene.media.Media;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;

public class SendEmail {

    public static void main(String[] args) {
        playSound("E:\\Flash_Yedek\\cs16v2017_oyunyoneticisi\\cstrike\\sound\\gungame\\gg_brass_bell.wav");
    }

    public static void playSound(String soundFile) {
        String command = "\"C:/Program Files (x86)/Windows Media Player/wmplayer.exe\"" + soundFile;
        try {
            Process p = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


