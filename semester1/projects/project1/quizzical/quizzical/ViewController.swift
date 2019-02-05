//
//  ViewController.swift
//  quizzical
//
//  Created by Rachel Slagle on 10/15/18.
//  Copyright © 2018 Rachel Slagle. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    @IBOutlet weak var artTrophy: UIImageView!
    @IBOutlet weak var scienceTrophy: UIImageView!
    @IBOutlet weak var historyTrophy: UIImageView!
    @IBOutlet weak var sportsTrophy: UIImageView!
    @IBOutlet weak var correctCounter: UILabel!
    @IBOutlet weak var incorrectCounter: UILabel!
    @IBOutlet weak var category: UISegmentedControl!
    @IBOutlet weak var questionCounter: UILabel!
    @IBOutlet weak var questionLabel: UITextView!
    @IBOutlet weak var optionA: UIButton!
    @IBOutlet weak var optionB: UIButton!
    @IBOutlet weak var optionC: UIButton!
    @IBOutlet weak var optionD: UIButton!
    @IBOutlet weak var feedback: UILabel!
    @IBOutlet weak var nextButton: UIButton!
    @IBOutlet weak var questionBackground: UIImageView!
    @IBOutlet weak var iconBackground: UIImageView!
    
    let allArtQuestions = ArtTriviaBank()
    let allScienceQuestions = ScienceTriviaBank()
    let allHistoryQuestions = HistoryTriviaBank()
    let allSportsQuestions = SportsTriviaBank()
    var artCorrect: Int = 0
    var scienceCorrect: Int = 0
    var historyCorrect: Int = 0
    var sportsCorrect: Int = 0
    
    var questionNumber: Int = 0
    var correct: Int = 0
    var incorrect: Int = 0
    var selectedAnswer: Int = 0

    @IBAction func changeCategory(_ sender: UISegmentedControl) {
        questionNumber = 0
        feedback.text = ""
        if category.selectedSegmentIndex == 0 {
            updateArtQuestion()
            questionBackground.image = UIImage(named: "artbackground")
            iconBackground.image = UIImage(named: "articon")
        }
        if category.selectedSegmentIndex == 1 {
            updateScienceQuestion()
            questionBackground.image = UIImage(named: "sciencebackground")
            iconBackground.image = UIImage(named: "scienceicon")
        }
        if category.selectedSegmentIndex == 2 {
            updateHistoryQuestion()
            questionBackground.image = UIImage(named: "historybackground")
            iconBackground.image = UIImage(named: "historyicon")
        }
        if category.selectedSegmentIndex == 3 {
            updateSportsQuestion()
            questionBackground.image = UIImage(named: "sportsbackground")
            iconBackground.image = UIImage(named: "sportsicon")
        }
    }
    
    @IBAction func answerPressed(_ sender: UIButton) {
        if sender.tag == selectedAnswer{
            feedback.text = "Correct!"
            correct += 1
            nextButton.isEnabled = true
            optionA.isEnabled = false
            optionB.isEnabled = false
            optionC.isEnabled = false
            optionD.isEnabled = false
            if category.selectedSegmentIndex == 0 {
                artCorrect += 1
            }
            if category.selectedSegmentIndex == 1 {
                scienceCorrect += 1
            }
            if category.selectedSegmentIndex == 2 {
                historyCorrect += 1
            }
            if category.selectedSegmentIndex == 3 {
                sportsCorrect += 1
            }
        }
        else{
            feedback.text = "Incorrect. Please try again!"
            incorrect += 1
        }
        correctCounter.text = String(correct)
        incorrectCounter.text = String(incorrect)
    }
    
    @IBAction func nextPressed(_ sender: UIButton) {
        questionNumber += 1
        feedback.text = ""
        if category.selectedSegmentIndex == 0 {
            updateArtQuestion()
        }
        if category.selectedSegmentIndex == 1 {
            updateScienceQuestion()
        }
        if category.selectedSegmentIndex == 2 {
            updateHistoryQuestion()
        }
        if category.selectedSegmentIndex == 3 {
            updateSportsQuestion()
        }
    }
    
    @IBAction func hintPressed(_ sender: UIButton) {
        if category.selectedSegmentIndex == 0 {
            feedback.text = allArtQuestions.list[questionNumber].hint
        }
        if category.selectedSegmentIndex == 1 {
            feedback.text = allScienceQuestions.list[questionNumber].hint
        }
        if category.selectedSegmentIndex == 2 {
            feedback.text = allHistoryQuestions.list[questionNumber].hint
        }
        if category.selectedSegmentIndex == 3 {
            feedback.text = allSportsQuestions.list[questionNumber].hint
        }
    }
    
    @IBAction func skipPressed(_ sender: UIButton) {
        questionNumber += 1
        feedback.text = "Skipped to next question."
        if category.selectedSegmentIndex == 0 {
            updateArtQuestion()
        }
        if category.selectedSegmentIndex == 1 {
            updateScienceQuestion()
        }
        if category.selectedSegmentIndex == 2 {
            updateHistoryQuestion()
        }
        if category.selectedSegmentIndex == 3 {
            updateSportsQuestion()
        }
    }
    
    func updateArtQuestion(){
        nextButton.isEnabled = false
        optionA.isEnabled = true
        optionB.isEnabled = true
        optionC.isEnabled = true
        optionD.isEnabled = true
        if questionNumber <= allArtQuestions.list.count - 1{
            questionCounter.text = "Question \(questionNumber + 1)/\(allArtQuestions.list.count)"
            questionLabel.text = allArtQuestions.list[questionNumber].question
            optionA.setTitle(allArtQuestions.list[questionNumber].optionA, for: UIControlState.normal)
            optionB.setTitle(allArtQuestions.list[questionNumber].optionB, for: UIControlState.normal)
            optionC.setTitle(allArtQuestions.list[questionNumber].optionC, for: UIControlState.normal)
            optionD.setTitle(allArtQuestions.list[questionNumber].optionD, for: UIControlState.normal)
            selectedAnswer = allArtQuestions.list[questionNumber].correctAnswer
        }
        else {
            let alert = UIAlertController(title: "Congratulations!", message: "You've completed the Art trivia category.", preferredStyle: .alert)
            let refreshAction = UIAlertAction(title: "OK", style: .default, handler: {action in
                self.questionNumber=0
                self.updateArtQuestion()
            })
            alert.addAction(refreshAction)
            present(alert, animated: true, completion: nil)
            
            if artCorrect == 5{
                artTrophy.image = UIImage(named: "arttrophy")
            }
        }
    }
    
    func updateScienceQuestion(){
        nextButton.isEnabled = false
        optionA.isEnabled = true
        optionB.isEnabled = true
        optionC.isEnabled = true
        optionD.isEnabled = true
        if questionNumber <= allScienceQuestions.list.count - 1{
            questionCounter.text = "Question \(questionNumber + 1)/\(allScienceQuestions.list.count)"
            questionLabel.text = allScienceQuestions.list[questionNumber].question
            optionA.setTitle(allScienceQuestions.list[questionNumber].optionA, for: UIControlState.normal)
            optionB.setTitle(allScienceQuestions.list[questionNumber].optionB, for: UIControlState.normal)
            optionC.setTitle(allScienceQuestions.list[questionNumber].optionC, for: UIControlState.normal)
            optionD.setTitle(allScienceQuestions.list[questionNumber].optionD, for: UIControlState.normal)
            selectedAnswer = allScienceQuestions.list[questionNumber].correctAnswer
        }
        else {
            let alert = UIAlertController(title: "Congratulations!", message: "You've completed the Science trivia category. Please try another category.", preferredStyle: .alert)
            let refreshAction = UIAlertAction(title: "OK", style: .default, handler: {action in
                self.questionNumber=0
                self.updateScienceQuestion()
            })
            alert.addAction(refreshAction)
            present(alert, animated: true, completion: nil)
            
            if scienceCorrect == 5{
                scienceTrophy.image = UIImage(named: "sciencetrophy")
            }
        }
    }
    
    func updateHistoryQuestion(){
        nextButton.isEnabled = false
        optionA.isEnabled = true
        optionB.isEnabled = true
        optionC.isEnabled = true
        optionD.isEnabled = true
        if questionNumber <= allHistoryQuestions.list.count - 1{
            questionCounter.text = "Question \(questionNumber + 1)/\(allHistoryQuestions.list.count)"
            questionLabel.text = allHistoryQuestions.list[questionNumber].question
            optionA.setTitle(allHistoryQuestions.list[questionNumber].optionA, for: UIControlState.normal)
            optionB.setTitle(allHistoryQuestions.list[questionNumber].optionB, for: UIControlState.normal)
            optionC.setTitle(allHistoryQuestions.list[questionNumber].optionC, for: UIControlState.normal)
            optionD.setTitle(allHistoryQuestions.list[questionNumber].optionD, for: UIControlState.normal)
            selectedAnswer = allHistoryQuestions.list[questionNumber].correctAnswer
        }
        else {
            let alert = UIAlertController(title: "Congratulations!", message: "You've completed the History trivia category.", preferredStyle: .alert)
            let refreshAction = UIAlertAction(title: "OK", style: .default, handler: {action in
                self.questionNumber=0
                self.updateHistoryQuestion()
            })
            alert.addAction(refreshAction)
            present(alert, animated: true, completion: nil)
            
            if historyCorrect == 5{
                historyTrophy.image = UIImage(named: "historytrophy")
            }
        }
    }
    
    func updateSportsQuestion(){
        nextButton.isEnabled = false
        optionA.isEnabled = true
        optionB.isEnabled = true
        optionC.isEnabled = true
        optionD.isEnabled = true
        if questionNumber <= allSportsQuestions.list.count - 1{
            questionCounter.text = "Question \(questionNumber + 1)/\(allSportsQuestions.list.count)"
            questionLabel.text = allSportsQuestions.list[questionNumber].question
            optionA.setTitle(allSportsQuestions.list[questionNumber].optionA, for: UIControlState.normal)
            optionB.setTitle(allSportsQuestions.list[questionNumber].optionB, for: UIControlState.normal)
            optionC.setTitle(allSportsQuestions.list[questionNumber].optionC, for: UIControlState.normal)
            optionD.setTitle(allSportsQuestions.list[questionNumber].optionD, for: UIControlState.normal)
            selectedAnswer = allSportsQuestions.list[questionNumber].correctAnswer
        }
        else {
            let alert = UIAlertController(title: "Congratulations!", message: "You've completed the Sports trivia category.", preferredStyle: .alert)
            let refreshAction = UIAlertAction(title: "OK", style: .default, handler: {action in
                self.questionNumber=0
                self.updateSportsQuestion()
            })
            alert.addAction(refreshAction)
            present(alert, animated: true, completion: nil)
            
            if sportsCorrect == 5{
                sportsTrophy.image = UIImage(named: "sportstrophy")
            }
        }
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

