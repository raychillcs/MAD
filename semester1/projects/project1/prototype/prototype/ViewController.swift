//
//  ViewController.swift
//  prototype
//
//  Created by Rachel Slagle on 10/3/18.
//  Copyright © 2018 Rachel Slagle. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var category: UISegmentedControl!
    @IBOutlet weak var questionNum: UILabel!
    @IBOutlet weak var question: UITextView!
    @IBOutlet weak var answer1: UIButton!
    @IBOutlet weak var answer2: UIButton!
    @IBOutlet weak var answer3: UIButton!
    @IBOutlet weak var answer4: UIButton!
    @IBOutlet weak var correct: UILabel!
    @IBOutlet weak var incorrect: UILabel!
    @IBOutlet weak var feedback: UILabel!
    
    @IBAction func changeCategory(_ sender: UISegmentedControl) {
        updateQuestion()
    }
    
    func updateQuestion() {
        if category.selectedSegmentIndex == 1 {
            questionNum.text = "Question 1"
            question.text = "What planet has the shortest day, at 10 hours?"
            answer1.setTitle("Mars", for: .normal)
            answer2.setTitle("Venus", for: .normal)
            answer3.setTitle("Jupiter", for: .normal)
            answer4.setTitle("Neptune", for: .normal)
        }
    }

    @IBAction func chooseAnswer(_ sender: UIButton) {
        var numCorrect : Int = 0
        var numIncorrect : Int = 0
        if sender.tag == 3 {
            feedback.text = "Correct!"
            numCorrect = numCorrect + 1
            correct.text = String(numCorrect)
        }
        else if sender.tag == 1 {
            feedback.text = "Incorrect! Please try again."
            numIncorrect = numIncorrect + 1
            incorrect.text = String(numIncorrect)
        }
        else if sender.tag == 2 {
            feedback.text = "Incorrect! Please try again."
            numIncorrect = numIncorrect + 1
            incorrect.text = String(numIncorrect)
        }
        else if sender.tag == 4 {
            feedback.text = "Incorrect! Please try again."
            numIncorrect = numIncorrect + 1
            incorrect.text = String(numIncorrect)
        }
        }

    @IBAction func giveHint(_ sender: UIButton) {
        feedback.text = "Hint: It's the largest planet in the Solar System."
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

