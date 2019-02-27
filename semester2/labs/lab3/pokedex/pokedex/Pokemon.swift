//
//  Pokemon.swift
//  pokedex
//
//  Created by Rachel Slagle on 2/26/19.
//  Copyright © 2019 Rachel Slagle. All rights reserved.
//

import Foundation

struct Pokemon: Decodable{
    let name : String
    let url : String
}

class PokemonDataModelController{
    var allData = [Pokemon]()
    let fileName = "pokemon"
    
    func loadData(){
        if let pathURL = Bundle.main.url(forResource: fileName, withExtension: "plist"){
            //creates a property list decoder object
            let plistdecoder = PropertyListDecoder()
            do {
                let data = try Data(contentsOf: pathURL)
                //decodes the property list
                allData = try plistdecoder.decode([Pokemon].self, from: data)
            } catch {
                // handle error
                print(error)
            }
        }
    }
    
    func getPokemon() -> [String]{
        var pokemons = [String]()
        for pokemon in allData{
            pokemons.append(pokemon.name)
        }
        return pokemons
    }
    
    func getURL(index:Int) -> String {
        return allData[index].url
    }
}
