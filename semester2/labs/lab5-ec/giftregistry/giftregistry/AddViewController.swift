//
//  AddViewController.swift
//  giftregistry
//
//  Created by Rachel Slagle on 3/18/19.
//  Copyright © 2019 Rachel Slagle. All rights reserved.
//

import UIKit

class AddViewController: UIViewController {

    @IBOutlet weak var giftname: UITextField!
    @IBOutlet weak var gifturl: UITextField!
    
    var addedname = String()
    var addedurl = String()
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "savesegue" {
            if giftname.text?.isEmpty == false {
                addedname = giftname.text!
                addedurl = gifturl.text!
            }
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
