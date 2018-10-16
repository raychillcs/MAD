//
//  SportsTriviaBank.swift
//  quizzical
//
//  Created by Rachel Slagle on 10/16/18.
//  Copyright © 2018 Rachel Slagle. All rights reserved.
//

import Foundation

class SportsTriviaBank{
    var list = [SportsTrivia]()
    
    init() {
        list.append(SportsTrivia(questionText: "Who holds the record for the most home runs in one baseball season?", choiceA: "Babe Ruth", choiceB: "Hank Aaron", choiceC: "Barry Bonds", choiceD: "Willie Mays", answer: 3, clue: "Hint: Player from 1986 to 2007."))
        
        list.append(SportsTrivia(questionText: "How many teams are in the American National Football league?", choiceA: "22", choiceB: "28", choiceC: "32", choiceD: "36", answer: 3, clue: "Hint: Somewhere in the middle."))
        
        list.append(SportsTrivia(questionText: "What is the national sport of Japan?", choiceA: "Baseball", choiceB: "Martial arts", choiceC: "Ice skating", choiceD: "Sumo", answer: 4, clue: "Hint: A form of wrestling."))
        
        list.append(SportsTrivia(questionText: "Which baseball team won the first World Series championship in 1903?", choiceA: "Americans", choiceB: "Athletics", choiceC: "Tigers", choiceD: "Browns", answer: 1, clue: "Hint: Now called the Red Sox."))
        
        list.append(SportsTrivia(questionText: "How many super bowls have the Denver Broncos won?", choiceA: "1", choiceB: "2", choiceC: "3", choiceD: "4", answer: 3, clue: "Hint: More than 2."))
    }
}
