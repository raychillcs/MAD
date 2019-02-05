//
//  HistoryTriviaBank.swift
//  quizzical
//
//  Created by Rachel Slagle on 10/16/18.
//  Copyright © 2018 Rachel Slagle. All rights reserved.
//

import Foundation

class HistoryTriviaBank{
    var list = [HistoryTrivia]()
    
    init() {
        list.append(HistoryTrivia(questionText: "What year did Albert Einstein die?", choiceA: "1935", choiceB: "1945", choiceC: "1955", choiceD: "1965", answer: 3, clue: "Hint: Same year as Vietnam War."))
        
        list.append(HistoryTrivia(questionText: "The first significant gold rush in the US occurred in what state?", choiceA: "California", choiceB: "Nevada", choiceC: "Colorado", choiceD: "North Carolina", answer: 4, clue: "Hint: State on the east coast."))
        
        list.append(HistoryTrivia(questionText: "What nation was led by Simeon the Great?", choiceA: "Bulgaria", choiceB: "Romania", choiceC: "Hungary", choiceD: "Austria", answer: 1, clue: "Hint: Shares a coastline with Greece."))
        
        list.append(HistoryTrivia(questionText: "Which US president appears on the far left at Mount Rushmore?", choiceA: "Roosevelt", choiceB: "Washington", choiceC: "Jefferson", choiceD: "Lincoln", answer: 2, clue: "Hint"))
        
        list.append(HistoryTrivia(questionText: "Which US amendment limits the president to two terms?", choiceA: "15th", choiceB: "18th", choiceC: "22nd", choiceD: "26th", answer: 3, clue: "Hint: Added in 1951."))
    }
}
