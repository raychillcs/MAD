//
//  ViewController.swift
//  banddiscovery
//
//  Created by Rachel Slagle on 9/11/18.
//  Copyright © 2018 Rachel Slagle. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var songrec: UILabel!
    @IBOutlet weak var bandImage: UIImageView!
    @IBAction func buttonGA(_ sender: UIButton) {
        songrec.text = "Gooey by Glass Animals"
        bandImage.image = UIImage(named: "glassanimals")
    }
    @IBAction func buttonLN(_ sender: UIButton) {
        songrec.text = "Wide Eyes by Local Natives"
        bandImage.image = UIImage(named: "localnatives")
    }
    @IBAction func buttonAltj(_ sender: UIButton) {
        songrec.text = "Breezeblocks by alt-J"
        bandImage.image = UIImage(named: "alt-j")
    }
    @IBAction func buttonFoals(_ sender: UIButton) {
        songrec.text = "My Number by Foals"
        bandImage.image = UIImage(named: "foals")
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

