//
//  ViewController.swift
//  BMIcalculator
//
//  Created by Rachel Slagle on 10/1/18.
//  Copyright © 2018 Rachel Slagle. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    @IBOutlet weak var weight: UITextField!
    @IBOutlet weak var heightFt: UITextField!
    @IBOutlet weak var heightIn: UITextField!
    @IBOutlet weak var BMI: UILabel!
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    func updateBMI() {
        var finalHeightFt:Float
        var finalHeightIn:Float
        
        if heightFt.text!.isEmpty {
            finalHeightFt = 0.0
        }
        else {
            finalHeightFt = Float(heightFt.text!)!
        }
        
        if heightIn.text!.isEmpty {
            finalHeightIn = 0.0
        }
        else {
            finalHeightIn = Float(heightIn.text!)!
        }
        
        let finalWeight = Float(weight.text!)
        let ftToIn = finalHeightFt * 12
        let finalHeight = ftToIn + finalHeightIn
        let heightCalc = finalHeight * finalHeight
        var result : Float = 0.0
        if finalWeight != nil {
            if finalWeight! > 0 {
                result = (finalWeight!) / heightCalc * 703
            }
            else {
                let alert=UIAlertController(title: "Warning", message: "Your weight must be greater than 0.", preferredStyle: UIAlertControllerStyle.alert)
                let cancelAction=UIAlertAction(title: "Cancel", style:UIAlertActionStyle.cancel, handler: nil)
                alert.addAction(cancelAction)
                let okAction=UIAlertAction(title: "OK", style: UIAlertActionStyle.default, handler: {action in
                    self.weight.text="150"
                    self.updateBMI()
                })
                alert.addAction(okAction)
                present(alert, animated: true, completion: nil)
            }
        }
        let decimalFormatter = NumberFormatter()
        decimalFormatter.numberStyle = NumberFormatter.Style.decimal
        BMI.text = decimalFormatter.string(from: NSNumber(value: result))
    }
    
    func textFieldDidEndEditing(_ textField: UITextField) {
        updateBMI()
    }
    
    override func viewDidLoad() {
        weight.delegate = self
        heightFt.delegate = self
        heightIn.delegate = self
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    @IBAction func onTapGestureRecognized(_ sender: Any) {
        weight.resignFirstResponder()
        heightFt.resignFirstResponder()
        heightIn.resignFirstResponder()
    }
    
}

