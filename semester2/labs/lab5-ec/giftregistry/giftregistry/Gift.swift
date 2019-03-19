//
//  Gift.swift
//  giftregistry
//
//  Created by Rachel Slagle on 3/18/19.
//  Copyright © 2019 Rachel Slagle. All rights reserved.
//

import Foundation
import Firebase

struct Gift {
    var id: String
    var name: String
    var url: String
    
    init(id: String, name: String, url: String){
        self.id = id
        self.name = name
        self.url = url
    }
}
