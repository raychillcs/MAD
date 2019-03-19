//
//  WebViewController.swift
//  giftregistry
//
//  Created by Rachel Slagle on 3/18/19.
//  Copyright © 2019 Rachel Slagle. All rights reserved.
//

import UIKit
import WebKit

class WebViewController: UIViewController, WKNavigationDelegate {
    
    @IBOutlet weak var webView: WKWebView!
    @IBOutlet weak var webSpinner: UIActivityIndicatorView!
    
    var webpage: String?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        webView.navigationDelegate = self
        loadWebPage()
        // Do any additional setup after loading the view.
    }
    
    func loadWebPage(){
        guard let weburl = webpage
            else {
                print("No webpage found.")
                return
        }
        let url = URL(string: weburl)
        let request = URLRequest(url: url!)
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

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
