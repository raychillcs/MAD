//
//  ThirdViewController.swift
//  banddiscovery
//
//  Created by Rachel Slagle on 2/4/19.
//  Copyright © 2019 Rachel Slagle. All rights reserved.
//

import UIKit
import AVFoundation

class ThirdViewController: UIViewController, AVAudioPlayerDelegate, AVAudioRecorderDelegate {

    @IBOutlet weak var rButton: UIButton!
    @IBOutlet weak var sButton: UIButton!
    @IBOutlet weak var pButton: UIButton!
    
    var audioPlayer: AVAudioPlayer?
    var audioRecorder: AVAudioRecorder?
    let fileName = "audio.m4a"
    
    @IBAction func recordSound(_ sender: UIButton) {
        if audioRecorder?.isRecording == false{
            pButton.isEnabled = false
            sButton.isEnabled = true
            audioRecorder?.delegate = self
            print("start recording")
            audioRecorder?.record()
        }
    }
    
    @IBAction func stopRecording(_ sender: UIButton) {
        sButton.isEnabled = false
        pButton.isEnabled = true
        rButton.isEnabled = true
        if audioRecorder?.isRecording == true {
            print("stop recording")
            audioRecorder?.stop()
        } else {
            print("stop playing")
            audioPlayer?.stop()
        }
    }
    
    @IBAction func playSound(_ sender: UIButton) {
        if audioRecorder?.isRecording == false{
            sButton.isEnabled = true
            rButton.isEnabled = false
            
            do {
                try audioPlayer = AVAudioPlayer(contentsOf:
                    (audioRecorder?.url)!)
                audioPlayer!.delegate = self
                audioPlayer!.prepareToPlay()
                print("start playing")
                audioPlayer!.play()
            } catch let error {
                print("audioPlayer error: \(error.localizedDescription)")
            }
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        pButton.isEnabled = false;
        sButton.isEnabled = false;
        
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
        rButton.isEnabled = true
        sButton.isEnabled = false
    }

}
