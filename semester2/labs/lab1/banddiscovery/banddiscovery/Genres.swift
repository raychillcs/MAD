//
//  Genres.swift
//  banddiscovery
//
//  Created by Rachel Slagle on 2/4/19.
//  Copyright © 2019 Rachel Slagle. All rights reserved.
//

import Foundation

struct Genres: Decodable {
    let name : String
    let subgenres : [String]
}
