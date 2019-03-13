//
//  SecondViewController.swift
//  gojam
//
//  Created by Rachel Slagle on 3/11/19.
//  Copyright © 2019 Rachel Slagle. All rights reserved.
//
//  Drums View Controller

import UIKit
import AVFoundation

class SecondViewController: UIViewController, AVAudioPlayerDelegate, AVAudioRecorderDelegate {
    
    var audioPlayer: AVAudioPlayer?
    var audioRecorder: AVAudioRecorder?
    let fileName = "audio.m4a";
    
    @IBOutlet weak var stopButton: UIButton!
    @IBOutlet weak var recordButton: UIButton!
    @IBOutlet weak var playButton: UIButton!
    
    @IBAction func stopAudio(_ sender: UIButton) {
        stopButton.isEnabled = false
        playButton.isEnabled = true
        recordButton.isEnabled = true
        if audioRecorder?.isRecording == true {
            audioRecorder?.stop()
        } else {
            audioPlayer?.stop()
        }
    }
    
    @IBAction func recordAudio(_ sender: UIButton) {
        if audioRecorder?.isRecording == false{
            playButton.isEnabled = false
            stopButton.isEnabled = true
            audioRecorder?.delegate = self
            audioRecorder?.record()
        }
    }
    
    @IBAction func playAudio(_ sender: UIButton) {
        if audioRecorder?.isRecording == false{
            stopButton.isEnabled = true
            recordButton.isEnabled = false
            
            do {
                try audioPlayer = AVAudioPlayer(contentsOf:
                    (audioRecorder?.url)!)
                audioPlayer!.delegate = self
                audioPlayer!.prepareToPlay()
                audioPlayer!.play()
            } catch let error {
                print("audioPlayer error: \(error.localizedDescription)")
            }
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        playButton.isEnabled = false;
        stopButton.isEnabled = false;
        
        let dirPath = FileManager.default.urls(for: .documentDirectory, in: .userDomainMask)
        let docDir = dirPath[0]
        print(docDir)
        let audioFileURL = docDir.appendingPathComponent(fileName)
        print(audioFileURL)
        
        let audioSession = AVAudioSession.sharedInstance()
        do {
            try audioSession.setCategory(AVAudioSession.Category.playAndRecord, mode: .default, options: .init(rawValue: 1))
        } catch {
            print("audio session error: \(error.localizedDescription)")
        }
        
        let settings = [
            AVFormatIDKey: Int(kAudioFormatMPEG4AAC),
            AVSampleRateKey: 12000,
            AVNumberOfChannelsKey: 1,
            AVEncoderAudioQualityKey: AVAudioQuality.high.rawValue
        ]
        
        do {
            audioRecorder = try AVAudioRecorder(url: audioFileURL, settings: settings)
            audioRecorder?.prepareToRecord()
            print("audio recorder ready")
        } catch {
            print("audio recorder error: \(error.localizedDescription)")
        }
    }
    
    func audioPlayerDidFinishPlaying(_ player: AVAudioPlayer, successfully flag: Bool) {
        recordButton.isEnabled = true
        stopButton.isEnabled = false
    }

    @IBAction func playHat1(_ sender: Any) {
        let url = Bundle.main.url(forResource: "closed-hat1", withExtension: "wav")
        
        guard url != nil else {
            return
        }
        
        do {
            audioPlayer = try AVAudioPlayer(contentsOf: url!)
            audioPlayer?.play()
        }
        catch {
            print("error")
        }
    }
    
    @IBAction func playHat2(_ sender: Any) {
        let url = Bundle.main.url(forResource: "closed-hat2", withExtension: "wav")
        
        guard url != nil else {
            return
        }
        
        do {
            audioPlayer = try AVAudioPlayer(contentsOf: url!)
            audioPlayer?.play()
        }
        catch {
            print("error")
        }
    }
    
    @IBAction func playCymbal1(_ sender: Any) {
        let url = Bundle.main.url(forResource: "cymbal1", withExtension: "wav")
        
        guard url != nil else {
            return
        }
        
        do {
            audioPlayer = try AVAudioPlayer(contentsOf: url!)
            audioPlayer?.play()
        }
        catch {
            print("error")
        }
    }

    @IBAction func playCymbal2(_ sender: Any) {
        let url = Bundle.main.url(forResource: "cymbal2", withExtension: "wav")
        
        guard url != nil else {
            return
        }
        
        do {
            audioPlayer = try AVAudioPlayer(contentsOf: url!)
            audioPlayer?.play()
        }
        catch {
            print("error")
        }
    }
    
    @IBAction func playTom1(_ sender: Any) {
        let url = Bundle.main.url(forResource: "tom1", withExtension: "wav")
        
        guard url != nil else {
            return
        }
        
        do {
            audioPlayer = try AVAudioPlayer(contentsOf: url!)
            audioPlayer?.play()
        }
        catch {
            print("error")
        }
    }
    
    @IBAction func playTom2(_ sender: Any) {
        let url = Bundle.main.url(forResource: "tom2", withExtension: "wav")
        
        guard url != nil else {
            return
        }
        
        do {
            audioPlayer = try AVAudioPlayer(contentsOf: url!)
            audioPlayer?.play()
        }
        catch {
            print("error")
        }
    }
    
    @IBAction func playTom3(_ sender: Any) {
        let url = Bundle.main.url(forResource: "tom3", withExtension: "wav")
        
        guard url != nil else {
            return
        }
        
        do {
            audioPlayer = try AVAudioPlayer(contentsOf: url!)
            audioPlayer?.play()
        }
        catch {
            print("error")
        }
    }
    
    @IBAction func playTom4(_ sender: Any) {
        let url = Bundle.main.url(forResource: "tom4", withExtension: "wav")
        
        guard url != nil else {
            return
        }
        
        do {
            audioPlayer = try AVAudioPlayer(contentsOf: url!)
            audioPlayer?.play()
        }
        catch {
            print("error")
        }
    }
    
    @IBAction func playKick(_ sender: Any) {
        let url = Bundle.main.url(forResource: "kick", withExtension: "wav")
        
        guard url != nil else {
            return
        }
        
        do {
            audioPlayer = try AVAudioPlayer(contentsOf: url!)
            audioPlayer?.play()
        }
        catch {
            print("error")
        }
    }
    
}

