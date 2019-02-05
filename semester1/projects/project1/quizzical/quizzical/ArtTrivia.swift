//
//  ArtTrivia.swift
//  quizzical
//
//  Created by Rachel Slagle on 10/15/18.
//  Copyright © 2018 Rachel Slagle. All rights reserved.
//

import Foundation

class ArtTrivia : Codable{
    let question: String
    let optionA: String
    let optionB: String
    let optionC: String
    let optionD: String
    let correctAnswer: Int
    let hint: String
    
    init(questionText: String, choiceA: String, choiceB: String, choiceC: String, choiceD: String, answer: Int, clue: String){
        question = questionText
        optionA = choiceA
        optionB = choiceB
        optionC = choiceC
        optionD = choiceD
        correctAnswer = answer
        hint = clue
    }
}
