//
//  ArtTriviaBank.swift
//  quizzical
//
//  Created by Rachel Slagle on 10/15/18.
//  Copyright © 2018 Rachel Slagle. All rights reserved.
//

import Foundation

class ArtTriviaBank{
    var list = [ArtTrivia]()
    
    init() {
        list.append(ArtTrivia(questionText: "Which artist is credited with developing linear perspective?", choiceA: "Donatello", choiceB: "Brunelleschi", choiceC: "Michelangelo", choiceD: "da Vinci", answer: 2, clue: "Hint: He was an Italian architect."))
        
        list.append(ArtTrivia(questionText: "What note is the highest string of a violin usually tuned to?", choiceA: "C", choiceB: "D", choiceC: "E", choiceD: "F", answer: 3, clue: "Hint: The third note of the C major scale."))
        
        list.append(ArtTrivia(questionText: "What war is taking place in the novel Lord of the Flies?", choiceA: "World War I", choiceB: "World War II", choiceC: "Vietnam War", choiceD: "Cold War", answer: 2, clue: "Hint: Took place from 1939 to 1945."))
        
        list.append(ArtTrivia(questionText: "Which year was the first book in the Harry Potter series published?", choiceA: "1997", choiceB: "2000", choiceC: "2003", choiceD: "2006", answer: 1, clue: "Hint: Same year as the film Titanic."))
        
        list.append(ArtTrivia(questionText: "From what language did English borrow the word zero?", choiceA: "German", choiceB: "Russian", choiceC: "Greek", choiceD: "Arabic", answer: 4, clue: "Hint: The language of Islam."))
    }
}
