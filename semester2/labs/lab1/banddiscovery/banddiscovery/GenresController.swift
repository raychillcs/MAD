//
//  GenresController.swift
//  banddiscovery
//
//  Created by Rachel Slagle on 2/4/19.
//  Copyright © 2019 Rachel Slagle. All rights reserved.
//

import Foundation

class GenresController {
    var allData = [Genres]()
    let fileName = "genres"
    
    func loadData(){
        if let pathURL = Bundle.main.url(forResource: fileName, withExtension: "plist"){
            //creates a property list decoder object
            let plistdecoder = PropertyListDecoder()
            do {
                let data = try Data(contentsOf: pathURL)
                //decodes the property list
                allData = try plistdecoder.decode([Genres].self, from: data)
            } catch {
                // handle error
                print(error)
            }
        }
    }
    
    func getGenres() -> [String]{
        var genres = [String]()
        for genre in allData{
            genres.append(genre.name)
        }
        return genres
    }
    
    func getSubgenres(index:Int) -> [String] {
        return allData[index].subgenres
    }
}
