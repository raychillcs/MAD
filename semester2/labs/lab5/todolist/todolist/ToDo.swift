//
//  ToDo.swift
//  todolist
//
//  Created by Rachel Slagle on 3/18/19.
//  Copyright © 2019 Rachel Slagle. All rights reserved.
//

import Foundation
import RealmSwift

class ToDo: Object {
    @objc dynamic var action = ""
    @objc dynamic var done = false
}
