//
//  DetailViewController.swift
//  midterm
//
//  Created by Rachel Slagle on 3/14/19.
//  Copyright © 2019 Rachel Slagle. All rights reserved.
//

import UIKit
import WebKit

class DetailViewController: UIViewController, WKNavigationDelegate {

    @IBOutlet weak var detailDescriptionLabel: UILabel!
    @IBOutlet weak var webView: WKWebView!
    @IBOutlet weak var webSpinner: UIActivityIndicatorView!
    
    var detailItem: String?
    //    {
    //        didSet {
    //            // Update the view.
    //            configureView()
    //        }
    //    }

    func configureView() {
        // Update the user interface for the detail item.
        if let detail = detailItem {
            if let label = detailDescriptionLabel {
                label.text = detail.description
                loadWebPage(detail.description)
            }
        }
    }

    override func viewDidLoad() {
        super.viewDidLoad()
        webView.navigationDelegate = self
        navigationItem.largeTitleDisplayMode = .never
        // Do any additional setup after loading the view, typically from a nib.
        configureView()
    }
    
    func loadWebPage(_ urlString: String){
        let myurl = URL(string: urlString)
        let request = URLRequest(url: myurl!)
        webView.load(request)
    }
    
    func webView(_ webView: WKWebView, didStartProvisionalNavigation navigation: WKNavigation!) {
        webSpinner.startAnimating()
    }
    
    func webView(_ webView: WKWebView, didFinish navigation: WKNavigation!) {
        webSpinner.stopAnimating()
    }

}

