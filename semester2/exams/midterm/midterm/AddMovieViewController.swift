//
//  AddMovieViewController.swift
//  midterm
//
//  Created by Rachel Slagle on 3/14/19.
//  Copyright © 2019 Rachel Slagle. All rights reserved.
//

import UIKit

class AddMovieViewController: UIViewController {

    @IBOutlet weak var addMovieName: UITextField!
    @IBOutlet weak var addMovieURL: UITextField!
    
    var addedMovieName = String()
    var addedMovieURL = String()
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "doneSegue"{
            if ((addMovieName.text?.isEmpty) == false){
                addedMovieName=addMovieName.text!
            }
            if ((addMovieURL.text?.isEmpty) == false){
                addedMovieURL=addMovieURL.text!
            }
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
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
