//
//  FirstViewController.swift
//  banddiscovery
//
//  Created by Rachel Slagle on 2/4/19.
//  Copyright © 2019 Rachel Slagle. All rights reserved.
//

import UIKit

class FirstViewController: UIViewController, UIPickerViewDelegate, UIPickerViewDataSource {

    @IBOutlet weak var genrePicker: UIPickerView!
    @IBOutlet weak var choiceLabel: UILabel!
    @IBOutlet weak var suggestLabel: UILabel!
    
    let genreComponent = 0
    let subgenreComponent = 1
    
    var genresSubgenres = GenresController()
    var genres = [String]()
    var subgenres = [String]()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        genresSubgenres.loadData()
        genres=genresSubgenres.getGenres()
        subgenres=genresSubgenres.getSubgenres(index: 0)
        choiceLabel.text = "You like Bluegrass within the Country genre"
        suggestLabel.text = "You should listen to Alison Krauss"
    }
    
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 2
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        if component == genreComponent {
            return genres.count
        } else {
            return subgenres.count
        }
    }
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        if component == genreComponent {
            return genres[row]
        } else {
            return subgenres[row]
        }
    }
    
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        if component == genreComponent {
            subgenres = genresSubgenres.getSubgenres(index: row)
            genrePicker.reloadComponent(subgenreComponent)
            genrePicker.selectRow(0, inComponent: subgenreComponent, animated: true)
        }
        let genrerow = pickerView.selectedRow(inComponent: genreComponent)
        let subgenrerow = pickerView.selectedRow(inComponent: subgenreComponent)
        
        choiceLabel.text = "You like \(subgenres[subgenrerow]) within the \(genres[genrerow]) genre"
        switch subgenres[subgenrerow] {
        case "Bluegrass":
            suggestLabel.text = "You should listen to Alison Krauss"
            break
        case "Bro-country":
            suggestLabel.text = "You should listen to Jason Aldean"
            break
        case "Honky-tonk":
            suggestLabel.text = "You should listen to Hank Williams"
            break
        case "Southern Rock":
            suggestLabel.text = "You should listen to ZZ Top"
            break
        case "Chiptune":
            suggestLabel.text = "You should listen to C418"
            break
        case "Electronica":
            suggestLabel.text = "You should listen to Daft Punk"
            break
        case "Techno":
            suggestLabel.text = "You should listen to Darude"
            break
        case "New Wave":
            suggestLabel.text = "You should listen to Duran Duran"
            break
        case "Bebop":
            suggestLabel.text = "You should listen to Charlie Parker"
            break
        case "Cool Jazz":
            suggestLabel.text = "You should listen to Miles Davis"
            break
        case "Dixieland":
            suggestLabel.text = "You should listen to Louis Armstrong"
            break
        case "Swing":
            suggestLabel.text = "You should listen to Duke Ellington"
            break
        case "Alt. Rock":
            suggestLabel.text = "You should listen to RHCP"
            break
        case "Heavy Metal":
            suggestLabel.text = "You should listen to Metallica"
            break
        case "Prog. Rock":
            suggestLabel.text = "You should listen to Pink Floyd"
            break
        case "Punk Rock":
            suggestLabel.text = "You should listen to Green Day"
            break
        default:
            suggestLabel.text = ""
            break
        }
    }

}

