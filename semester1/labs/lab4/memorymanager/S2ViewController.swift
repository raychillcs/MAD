//
//  S2ViewController.swift
//  memorymanager
//
//  Created by Rachel Slagle on 10/8/18.
//  Copyright © 2018 Rachel Slagle. All rights reserved.
//

import UIKit

class S2ViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var userID: UITextField!
    @IBOutlet weak var userPassword: UITextField!
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "doneMem"{
            let scene1ViewController = segue.destination as! ViewController
            if userID.text!.isEmpty == false{
                scene1ViewController.user.memID=userID.text
            }
            if userPassword.text!.isEmpty == false{
                scene1ViewController.user.memPassword=userPassword.text
            }
        }
    }
    
    override func viewDidLoad() {
        userID.delegate = self
        userPassword.delegate = self
        super.viewDidLoad()
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    @IBAction func onTapGestureRecognized(_ sender: Any) {
        userID.resignFirstResponder()
        userPassword.resignFirstResponder()
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
