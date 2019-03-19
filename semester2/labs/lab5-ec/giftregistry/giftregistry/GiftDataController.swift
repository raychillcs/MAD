//
//  GiftDataController.swift
//  giftregistry
//
//  Created by Rachel Slagle on 3/18/19.
//  Copyright © 2019 Rachel Slagle. All rights reserved.
//

import Foundation
import Firebase

class GiftDataController {
    var ref: DatabaseReference!
    var giftData = [Gift]()
    
    var onDataUpdate: ((_ data: [Gift]) -> Void)?
    
    func setupFirebaseListener(){
        ref = Database.database().reference().child("gifts")
        ref.observe(DataEventType.value, with: {snapshot in
            self.giftData.removeAll()
            for snap in snapshot.children.allObjects as! [DataSnapshot]{
                let giftID = snap.key
                if let giftDict = snap.value as? [String: String],
                    let giftName = giftDict["name"],
                    let giftURL = giftDict["url"]
                {
                    let newGift = Gift(id: giftID, name: giftName, url: giftURL)
                    self.giftData.append(newGift)
                }
            }
            self.onDataUpdate?(self.giftData)
        })
    }
    
    func getGifts() -> [Gift]{
        return giftData
    }
    
    func addGift(name:String, url:String){
        let newGiftDict = ["name": name, "url": url]
        let giftref = ref.childByAutoId()
        giftref.setValue(newGiftDict)
    }
    
    func deleteGift(giftID: String){
        ref.child(giftID).removeValue()
    }
}
