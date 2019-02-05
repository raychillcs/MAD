//
//  ScienceTriviaBank.swift
//  quizzical
//
//  Created by Rachel Slagle on 10/16/18.
//  Copyright © 2018 Rachel Slagle. All rights reserved.
//

import Foundation

class ScienceTriviaBank{
    var list = [ScienceTrivia]()
    
    init() {
        list.append(ScienceTrivia(questionText: "What element’s chemical symbol is the letter I?", choiceA: "Iron", choiceB: "Iridium", choiceC: "Iodide", choiceD: "Iodine", answer: 4, clue: "Hint: Found in the human thyroid."))
        
        list.append(ScienceTrivia(questionText: "How many arms does a typical snowflake have?", choiceA: "5", choiceB: "6", choiceC: "7", choiceD: "8", answer: 2, clue: "Hint: Same amount as a hexagon."))
        
        list.append(ScienceTrivia(questionText: "What colour are mosquitos most attracted to?", choiceA: "Blue", choiceB: "Red", choiceC: "Yellow", choiceD: "Black", answer: 1, clue: "Hint: Has a calming effect."))
        
        list.append(ScienceTrivia(questionText: "What is the only phase of the Moon that can produce a solar eclipse?", choiceA: "First quarter", choiceB: "Last quarter", choiceC: "Full moon", choiceD: "New moon", answer: 4, clue: "Hint: The first lunar phase."))
        
        list.append(ScienceTrivia(questionText: "Starfish belong to which animal phylum?", choiceA: "Arthropoda", choiceB: "Cnidaria", choiceC: "Echinoderms", choiceD: "Crustacea", answer: 3, clue: "Hint: Largest marine animal phylum."))
    }
}
