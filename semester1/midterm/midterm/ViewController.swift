//
//  ViewController.swift
//  midterm
//
//  Created by Rachel Slagle on 10/18/18.
//  Copyright © 2018 Rachel Slagle. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    @IBOutlet weak var workoutTime: UITextField!
    @IBOutlet weak var weeklySwitch: UISwitch!
    @IBOutlet weak var workoutType: UISegmentedControl!
    @IBOutlet weak var workoutsPerWeekLabel: UILabel!
    @IBOutlet weak var miles: UILabel!
    @IBOutlet weak var calories: UILabel!
    @IBOutlet weak var workoutImage: UIImageView!
    
    @IBAction func calcButton(_ sender: UIButton) {
        updateWorkout()
    }
    
    var workoutsPerWeek: Double = 5.00
    
    @IBAction func changeWorkoutsPerWeek(_ sender: UISlider) {
        workoutsPerWeek = Double(sender.value)
        workoutsPerWeekLabel.text = String(format: "%.2f", workoutsPerWeek)
    }
    
    func updateWorkout(){
        var time: Double
        var calcMiles: Double = 0.00
        var calcCalories: Double = 0.00
        
        if workoutTime.text!.isEmpty{
            time = 0.0
        }
        else{
            time = Double(workoutTime.text!)!
        }
        
        if time < 30{
            let alert=UIAlertController(title: "Warning", message: "You need to workout more!", preferredStyle: UIAlertControllerStyle.alert)
            let cancelAction=UIAlertAction(title: "Cancel", style:UIAlertActionStyle.cancel, handler: nil)
            alert.addAction(cancelAction)
            let okAction=UIAlertAction(title: "OK", style: UIAlertActionStyle.default, handler: {action in
                self.workoutTime.text="30"
                self.updateWorkout()
            })
            alert.addAction(okAction)
            present(alert, animated: true, completion: nil)
        }
        
        if workoutType.selectedSegmentIndex == 0{
            calcMiles = time/10
            calcCalories = time*10
            workoutImage.image=UIImage(named: "run")
        }
        else if workoutType.selectedSegmentIndex == 1{
            calcMiles = time/30
            calcCalories = time*7
            workoutImage.image=UIImage(named: "swim")
        }
        else if workoutType.selectedSegmentIndex == 2{
            calcMiles = time/4
            calcCalories = time*8.5
            workoutImage.image=UIImage(named: "bike")
        }
        
        if weeklySwitch.isOn{
            calcMiles = calcMiles*Double(workoutsPerWeek)
            calcCalories = calcCalories*Double(workoutsPerWeek)
        }
        
        miles.text = "\(calcMiles) miles"
        calories.text = "\(calcCalories) calories burned"
    }
    
    override func viewDidLoad() {
        workoutTime.delegate = self
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

