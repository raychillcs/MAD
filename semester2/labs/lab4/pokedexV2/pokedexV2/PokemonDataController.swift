//
//  PokemonDataController.swift
//  pokedexV2
//
//  Created by Rachel Slagle on 3/4/19.
//  Copyright © 2019 Rachel Slagle. All rights reserved.
//

import Foundation

class PokemonDataController {
    var pokemonData = PokemonData()

    var onDataUpdate: ((_ data: [Pokemon]) -> Void)?
    
    func loadjson(){
        let urlPath = "https://pokeapi.co/api/v2/pokemon/?limit=100"
        guard let url = URL(string: urlPath)
            else {
                print("URL error.")
                return
        }
        
        let session = URLSession.shared.dataTask(with: url, completionHandler: {(data, response, error) in
            let httpResponse = response as! HTTPURLResponse
            let statusCode = httpResponse.statusCode
            guard statusCode == 200
                else {
                    print("File download error.")
                    return
            }
            print("Download complete.")
            DispatchQueue.main.async {self.parsejson(data!)}
        })
        session.resume()
    }
    
    func parsejson(_ data: Data){
        do
        {
            let api = try JSONDecoder().decode(PokemonData.self, from: data)
            for pokemon in api.results
            {
                pokemonData.results.append(pokemon)
            }
        }
        catch let jsonErr
        {
            print("JSON error.")
            print(jsonErr.localizedDescription)
            return
        }
        print("JSON parsing done.")
        onDataUpdate?(pokemonData.results)
    }
    
    func getPokemons()->[Pokemon]{
        return pokemonData.results
    }
    
}
