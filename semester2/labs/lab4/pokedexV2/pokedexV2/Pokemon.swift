//
//  Pokemon.swift
//  pokedexV2
//
//  Created by Rachel Slagle on 3/4/19.
//  Copyright © 2019 Rachel Slagle. All rights reserved.
//

import Foundation

struct Pokemon: Decodable{
    let name: String
    let url : String
}

struct PokemonData: Decodable {
    var results = [Pokemon]()
}
