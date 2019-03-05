//
//  DetailViewController.swift
//  pokedexV2
//
//  Created by Rachel Slagle on 3/4/19.
//  Copyright © 2019 Rachel Slagle. All rights reserved.
//

import UIKit
import WebKit

class DetailViewController: UIViewController, WKNavigationDelegate {
    
    @IBOutlet weak var webView: WKWebView!
    @IBOutlet weak var webSpinner: UIActivityIndicatorView!
    
    var detailItem: String?
    
    func configureView(){
        if let url = detailItem{
            if url != "null"{
                loadWebPage(url)
            }
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        webView.navigationDelegate = self
        configureView()
    }
    
    func loadWebPage(_ urlString: String){
        let myurl = URL(string: urlString)
        let request = URLRequest(url: myurl!)
        webView.load(request)
    }
    
    //WKNavigationDelegate method that is called when a web page begins to load
    func webView(_ webView: WKWebView, didStartProvisionalNavigation navigation: WKNavigation!) {
        webSpinner.startAnimating()
    }
    
    //WKNavigationDelegate method that is called when a web page loads successfully
    func webView(_ webView: WKWebView, didFinish navigation: WKNavigation!) {
        webSpinner.stopAnimating()
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
}
