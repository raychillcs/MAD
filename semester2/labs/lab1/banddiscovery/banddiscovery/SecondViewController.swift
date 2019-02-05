//
//  SecondViewController.swift
//  banddiscovery
//
//  Created by Rachel Slagle on 2/4/19.
//  Copyright © 2019 Rachel Slagle. All rights reserved.
//

import UIKit

class SecondViewController: UIViewController {

    @IBAction func golisten(_ sender: UIButton) {
        if(UIApplication.shared.canOpenURL(URL(string: "youtube://")!)){
            UIApplication.shared.open(URL(string: "youtube://")!, options: [:], completionHandler: nil)
        }else {
            if(UIApplication.shared.canOpenURL(URL(string: "videos://")!)){
                UIApplication.shared.open(URL(string: "videos://")!, options: [:], completionHandler: nil)
            } else {
                UIApplication.shared.open(URL(string: "http://www.apple.com/itunes/")!, options: [:], completionHandler: nil)
            }
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }

}

