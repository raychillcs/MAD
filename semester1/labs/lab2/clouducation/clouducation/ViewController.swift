//
//  ViewController.swift
//  clouducation
//
//  Created by Rachel Slagle on 9/19/18.
//  Copyright © 2018 Rachel Slagle. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var cloudImage: UIImageView!
    @IBOutlet weak var imageControl: UISegmentedControl!
    @IBOutlet weak var capitalSwitch: UISwitch!
    @IBOutlet weak var fontSizeLabel: UILabel!
    @IBOutlet weak var capsLabel: UILabel!
    
    func updateImage() {
        if imageControl.selectedSegmentIndex == 0 {
            titleLabel.text="Cumulus Clouds"
            cloudImage.image=UIImage(named: "cumulus")
        }
        else if imageControl.selectedSegmentIndex == 1 {
            titleLabel.text="Stratus Clouds"
            cloudImage.image=UIImage(named: "stratus")
        }
        else if imageControl.selectedSegmentIndex == 2 {
            titleLabel.text="Cirrus Clouds"
            cloudImage.image=UIImage(named: "cirrus")
        }
        else if imageControl.selectedSegmentIndex == 3 {
            titleLabel.text="Nimbus Clouds"
            cloudImage.image=UIImage(named: "nimbus")
        }
    }
    
    func updateCaps() {
        if capitalSwitch.isOn {
            titleLabel.text=titleLabel.text?.uppercased()
            capsLabel.textColor=UIColor(red: 255, green: 0, blue: 0, alpha: 255)
        } else {
            titleLabel.text=titleLabel.text?.lowercased()
            capsLabel.textColor=UIColor(red: 0, green: 0, blue: 0, alpha: 255)
        }
    }
    
    @IBAction func changeInfo(_ sender: UISegmentedControl) {
        updateImage()
    }
    
    @IBAction func updateFont(_ sender: UISwitch) {
        updateCaps()
    }
    
    @IBAction func changeFontSize(_ sender: UISlider) {
        let fontSize=sender.value
        fontSizeLabel.text=String(format: "%.0f", fontSize)
        let fontSizeCGFloat=CGFloat(fontSize)
        titleLabel.font=UIFont.systemFont(ofSize: fontSizeCGFloat)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

