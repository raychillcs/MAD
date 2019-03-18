//
//  ToDoDataController.swift
//  todolist
//
//  Created by Rachel Slagle on 3/18/19.
//  Copyright © 2019 Rachel Slagle. All rights reserved.
//

import Foundation
import RealmSwift

class ToDoDataController{
    var todoRealm : Realm!
    var todoData: Results<ToDo>
    {
        get {
            return todoRealm.objects(ToDo.self)
        }
    }
    
    func dbSetup(){
        do {
            todoRealm = try Realm()
        } catch let error {
            print(error.localizedDescription)
        }
        print(Realm.Configuration.defaultConfiguration.fileURL!)
    }
    
    func getToDo() -> [ToDo]{
        return Array(todoData)
    }
    
    func addItem(newItem: ToDo){
        do {
            try self.todoRealm.write({
                self.todoRealm.add(newItem)
            })
        } catch let error{
            print(error.localizedDescription)
        }
    }
    
    func doneItem(item: ToDo){
        do {
            try self.todoRealm.write ({
                item.done = !item.done
            })
        }catch let error{
            print(error.localizedDescription)
        }
    }
    
    func deleteItem(item: ToDo){
        do {
            try self.todoRealm.write ({
                self.todoRealm.delete(item)
            })
        } catch let error{
            print(error.localizedDescription)
        }
    }
    
}
