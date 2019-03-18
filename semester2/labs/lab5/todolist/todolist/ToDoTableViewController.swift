//
//  ToDoTableViewController.swift
//  todolist
//
//  Created by Rachel Slagle on 3/18/19.
//  Copyright © 2019 Rachel Slagle. All rights reserved.
//

import UIKit

class ToDoTableViewController: UITableViewController {
    
    var todoData = ToDoDataController()
    var todoList = [ToDo]()
    
    func render(){
        todoList = todoData.getToDo()
        tableView.reloadData()
    }

    override func viewDidLoad() {
        super.viewDidLoad()
        
        todoData.dbSetup()
        todoList = todoData.getToDo()

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
        
        // self.navigationController?.navigationBar.prefersLargeTitles = true
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return todoList.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "cell", for: indexPath)
        let item = todoList[indexPath.row]
        cell.textLabel!.text = item.action
        cell.accessoryType = item.done ? .checkmark : .none
        return cell
    }
    
    @IBAction func addToDoItem(_ sender: UIBarButtonItem) {
        let addalert = UIAlertController(title: "New Item", message: "Add a new item to your to-do list.", preferredStyle: .alert)
        addalert.addTextField(configurationHandler: {(UITextField) in
        })
        let cancelAction = UIAlertAction(title: "Cancel", style: .cancel, handler: nil)
        addalert.addAction(cancelAction)
        let addItemAction = UIAlertAction(title: "Add", style: .default, handler: {(UIAlertAction)in
            let newitem = addalert.textFields![0]
            let newToDoItem = ToDo()
            newToDoItem.action = newitem.text!
            newToDoItem.done = false
            self.todoData.addItem(newItem: newToDoItem)
            self.render()
        })
        addalert.addAction(addItemAction)
        present(addalert, animated: true, completion: nil)
    }
    
    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let doneItem = todoList[indexPath.row]
        todoData.doneItem(item: doneItem)
        render()
    }

    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            let item = todoList[indexPath.row]
            todoData.deleteItem(item: item)
            render()
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }
    }

    /*
    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to: IndexPath) {

    }
    */

    /*
    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    */

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
