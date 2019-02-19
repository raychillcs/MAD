//
//  ViewController.swift
//  boxoffice
//
//  Created by Rachel Slagle on 2/19/19.
//  Copyright © 2019 Rachel Slagle. All rights reserved.
//

import UIKit

class ViewController: UITableViewController {
    var genreList = [String]()
    var genresData = GenresDataModelController()

    override func viewDidLoad() {
        super.viewDidLoad()
        genresData.loadData()
        genreList=genresData.getGenres()
        
        navigationController?.navigationBar.prefersLargeTitles = true
        
        let app = UIApplication.shared
        NotificationCenter.default.addObserver(self, selector: #selector(ViewController.applicationWillResignActive(_:)), name: UIApplication.willResignActiveNotification, object: app)
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return genreList.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "MovieIdentifier", for: indexPath)
        cell.textLabel?.text = genreList[indexPath.row]
        return cell
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "moviesegue" {
            let detailVC = segue.destination as! DetailViewController
            let indexPath = tableView.indexPath(for: sender as! UITableViewCell)!
            detailVC.title = genreList[indexPath.row]
            detailVC.genresData = genresData
            detailVC.selectedGenre = indexPath.row
        }
        else if segue.identifier == "genresegue"{
            let infoVC = segue.destination as! MovieInfoTableViewController
            let editingCell = sender as! UITableViewCell
            let indexPath = tableView.indexPath(for: editingCell)
            infoVC.name = genreList[indexPath!.row]
            let movieList = genresData.getMovies(index: (indexPath?.row)!)
            infoVC.number = String(movieList.count)
        }
    }
    
    @objc func applicationWillResignActive(_ notification: NSNotification){
        genresData.writeData()
    }

}

