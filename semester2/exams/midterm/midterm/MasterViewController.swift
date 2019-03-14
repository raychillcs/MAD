//
//  MasterViewController.swift
//  midterm
//
//  Created by Rachel Slagle on 3/14/19.
//  Copyright © 2019 Rachel Slagle. All rights reserved.
//

import UIKit

class MasterViewController: UITableViewController {
    
    var detailViewController: DetailViewController? = nil
    var movies = [String]()
    var movieData = MovieDataModelController()
    var selectedMovie = 0
    var searchController = UISearchController()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        //        navigationItem.leftBarButtonItem = editButtonItem
        //
        //        let addButton = UIBarButtonItem(barButtonSystemItem: .add, target: self, action: #selector(insertNewObject(_:)))
        //        navigationItem.rightBarButtonItem = addButton
        
        navigationController?.navigationBar.prefersLargeTitles = true
        
        movieData.loadData()
        movies = movieData.getMovies()
        
        if let split = splitViewController {
            let controllers = split.viewControllers
            detailViewController = (controllers[controllers.count-1] as! UINavigationController).topViewController as? DetailViewController
        }
        
        //search results
        let resultsController = SearchResultsController() //create an instance of our SearchResultsController class
        resultsController.allwords = movies //set the allwords property to our words array
        searchController = UISearchController(searchResultsController: resultsController) //initialize our search controller with the resultsController when it has search results to display
        
        //search bar configuration
        searchController.searchBar.placeholder = "Enter a search term" //place holder text
        //searchController.searchBar.sizeToFit() //sets appropriate size for the search bar
        
        // For iOS 11 and later, place the search bar in the navigation bar.
        //navigationItem.searchController = searchController
        
        // Make the search bar always visible.
        //navigationItem.hidesSearchBarWhenScrolling = false
        
        //iOS 10 and earlier
        tableView.tableHeaderView=searchController.searchBar //install the search bar as the table header
        searchController.searchResultsUpdater = resultsController //sets the instance to update search results
    }
    
    override func viewWillAppear(_ animated: Bool) {
        self.clearsSelectionOnViewWillAppear = self.splitViewController!.isCollapsed
        super.viewWillAppear(animated)
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    //    @objc
    //    func insertNewObject(_ sender: Any) {
    //        objects.insert(NSDate(), at: 0)
    //        let indexPath = IndexPath(row: 0, section: 0)
    //        tableView.insertRows(at: [indexPath], with: .automatic)
    //    }
    
    // MARK: - Segues
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "showDetail" {
            if let indexPath = self.tableView.indexPathForSelectedRow {
                let url = movieData.getURL(index: indexPath.row)
                let name = movies[indexPath.row]
                let controller = (segue.destination as! UINavigationController).topViewController as! DetailViewController
                controller.detailItem = url
                controller.title = name
                controller.navigationItem.leftBarButtonItem = self.splitViewController?.displayModeButtonItem
                controller.navigationItem.leftItemsSupplementBackButton = true
            }
        }
    }
    
    // MARK: - Table View
    
    override func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return movies.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "Cell", for: indexPath)
        cell.textLabel!.text = movies[indexPath.row]
        return cell
    }
    
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }
    
    
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            movies.remove(at: indexPath.row)
            // Delete from the data model instance
//            moviesData.deleteMovie(index: selectedMovie, movieIndex: indexPath.row)
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }
    }
    
    @IBAction func unwindSegue(_ segue:UIStoryboardSegue){
        if segue.identifier=="doneSegue"{
            let source = segue.source as! AddMovieViewController
            //only add a country if there is text in the textfield
            if ((source.addedMovieName.isEmpty) == false){
                //add country to our data model instance
//                movieData.addMovie(index: selectedMovie, newMovie: source.addedMovieName, newIndex: movies.count)
                movies.append(source.addedMovieName)
                tableView.reloadData()
                
            }
//            if ((source.addedMovieURL.isEmpty) == false){
//                //add country to our data model instance
//                movieData.addMovie(index: selectedMovie, newMovie: source.addedMovieURL, newIndex: movies.count)
//                movies.append(source.addedMovieURL)
//                tableView.reloadData()
//
//            }
        }
    }
    
}

