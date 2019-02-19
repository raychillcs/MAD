//
//  DetailViewController.swift
//  boxoffice
//
//  Created by Rachel Slagle on 2/19/19.
//  Copyright © 2019 Rachel Slagle. All rights reserved.
//

import UIKit

class DetailViewController: UITableViewController {
    var genresData = GenresDataModelController()
    var selectedGenre = 0
    var movieList = [String]()
    var searchController = UISearchController()
    
    override func viewWillAppear(_ animated: Bool) {
        movieList = genresData.getMovies(index: selectedGenre)
    }

    override func viewDidLoad() {
        super.viewDidLoad()
        genresData.loadData()
        movieList = genresData.getMovies(index: selectedGenre)

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
        
        //Search results
        let resultsController = SearchResultsController()
        resultsController.allwords = movieList
        searchController = UISearchController(searchResultsController: resultsController)
        
        searchController.searchBar.placeholder = "Enter a search term"
        
        // For iOS 11 and later, place the search bar in the navigation bar.
        //navigationItem.searchController = searchController
        
        // Make the search bar always visible.
        //navigationItem.hidesSearchBarWhenScrolling = false
        
        //iOS 10 and earlier
        tableView.tableHeaderView=searchController.searchBar //install the search bar as the table header
        searchController.searchResultsUpdater = resultsController //sets the instance to update search results
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
        // #warning Incomplete implementation, return the number of sections
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // #warning Incomplete implementation, return the number of rows
        return movieList.count
    }

    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "MovieIdentifier", for: indexPath)
        cell.textLabel?.text = movieList[indexPath.row]
        return cell
    }

    // Override to support conditional editing of the table view.
    override func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the specified item to be editable.
        return true
    }

    // Override to support editing the table view.
    override func tableView(_ tableView: UITableView, commit editingStyle: UITableViewCell.EditingStyle, forRowAt indexPath: IndexPath) {
        if editingStyle == .delete {
            movieList.remove(at: indexPath.row)
            genresData.deleteMovie(index: selectedGenre, movieIndex: indexPath.row)
            tableView.deleteRows(at: [indexPath], with: .fade)
        } else if editingStyle == .insert {
            // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
        }
    }

    // Override to support rearranging the table view.
    override func tableView(_ tableView: UITableView, moveRowAt fromIndexPath: IndexPath, to toIndexPath: IndexPath) {
        let fromRow = fromIndexPath.row
        let toRow = toIndexPath.row
        let moveMovie = movieList[fromRow]
        movieList.remove(at: fromRow)
        movieList.insert(moveMovie, at: toRow)
        genresData.deleteMovie(index: selectedGenre, movieIndex: fromRow)
        genresData.addMovie(index: selectedGenre, newMovie: moveMovie, newIndex: toRow)
    }

    // Override to support conditional rearranging of the table view.
    override func tableView(_ tableView: UITableView, canMoveRowAt indexPath: IndexPath) -> Bool {
        // Return false if you do not want the item to be re-orderable.
        return true
    }
    
    @IBAction func unwindSegue(_ segue:UIStoryboardSegue) {
        if segue.identifier=="doneSegue"{
            let source = segue.source as! AddMovieViewController
            if ((source.addedMovie.isEmpty) == false){
                genresData.addMovie(index: selectedGenre, newMovie: source.addedMovie, newIndex: movieList.count)
                movieList.append(source.addedMovie)
                tableView.reloadData()
            }
        }
    }

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
