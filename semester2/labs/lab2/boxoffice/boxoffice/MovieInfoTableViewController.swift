//
//  MovieInfoTableViewController.swift
//  boxoffice
//
//  Created by Rachel Slagle on 2/19/19.
//  Copyright © 2019 Rachel Slagle. All rights reserved.
//

import UIKit

class MovieInfoTableViewController: UITableViewController {
    @IBOutlet weak var genreName: UILabel!
    @IBOutlet weak var movieNumber: UILabel!
    
    var name = String()
    var number = String()
    
    override func viewWillAppear(_ animated: Bool) {
        genreName.text=name
        movieNumber.text=number
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        navigationItem.largeTitleDisplayMode = .never

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
    }

}
