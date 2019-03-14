//
//  Movie.swift
//  midterm
//
//  Created by Rachel Slagle on 3/14/19.
//  Copyright © 2019 Rachel Slagle. All rights reserved.
//

import Foundation

struct Movie: Decodable{
    var name: String
    let url: String
}

class MovieDataModelController{
    var allData = [Movie]()
    let fileName = "movies"
    
    func loadData(){
        if let pathURL = Bundle.main.url(forResource: fileName, withExtension: "plist"){
            //creates a property list decoder object
            let plistdecoder = PropertyListDecoder()
            do {
                let data = try Data(contentsOf: pathURL)
                //decodes the property list
                allData = try plistdecoder.decode([Movie].self, from: data)
            } catch {
                // handle error
                print(error)
            }
        }
    }
    
    func getMovies() -> [String]{
        var movies = [String]()
        for movie in allData{
            movies.append(movie.name)
        }
        return movies
    }
    
    func getURL(index:Int) -> String {
        return allData[index].url
    }
    
//    func addMovie(index:Int, newMovie:String, newIndex: Int){
//        allData[index].name.insert(newMovie, at: newIndex)
//    }
    
//    func deleteMovie(index:Int, movieIndex: Int){
//        allData[index].name.remove(at: movieIndex)
//    }
    
}
