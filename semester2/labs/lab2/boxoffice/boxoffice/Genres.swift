//
//  Genres.swift
//  boxoffice
//
//  Created by Rachel Slagle on 2/19/19.
//  Copyright © 2019 Rachel Slagle. All rights reserved.
//

import Foundation

struct GenresDataModel : Codable {
    var genre : String
    var movies : [String]
}

class GenresDataModelController {
    var allData = [GenresDataModel]()
    let fileName = "genres2"
    let datafilename = "data.plist"
    
    func getDataFile(datafile: String) -> URL {
        let dirPath = FileManager.default.urls(for: .documentDirectory, in: .userDomainMask)
        let docDir = dirPath[0]
        print(docDir)
        
        return docDir.appendingPathComponent(datafile)
    }
    
    func loadData(){
        let pathURL:URL?
        
        let dataFileURL = getDataFile(datafile: datafilename)
        print(dataFileURL)
        
        if FileManager.default.fileExists(atPath: dataFileURL.path){
            pathURL = dataFileURL
        }
        else {
            pathURL = Bundle.main.url(forResource: fileName, withExtension: "plist")
        }
        
            let plistdecoder = PropertyListDecoder()
            do {
                let data = try Data(contentsOf: pathURL!)
                allData = try plistdecoder.decode([GenresDataModel].self, from: data)
            } catch {
                print(error)
            }
    }
    
    func getGenres() -> [String]{
        var genres = [String]()
        for item in allData{
            genres.append(item.genre)
        }
        return genres
    }
    
    func getMovies(index:Int) -> [String] {
        return allData[index].movies
    }
    
    func addMovie(index:Int, newMovie:String, newIndex: Int){
        allData[index].movies.insert(newMovie, at: newIndex)
    }
    
    func deleteMovie(index:Int, movieIndex: Int){
        allData[index].movies.remove(at: movieIndex)
    }
    
    func writeData(){
        let dataFileURL = getDataFile(datafile: datafilename)
        print(dataFileURL)
        let plistencoder = PropertyListEncoder()
        plistencoder.outputFormat = .xml
        do {
            let data = try plistencoder.encode(allData.self)
            try data.write(to: dataFileURL)
        } catch {
            print(error)
        }
    }
    
}
