//
//  ViewController.swift
//  CheckViewOnScreen
//
//  Created by Guy Lis on 12/06/2022.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var label: UILabel!
    
    var timer : Timer?
    
    let kTimerIntervalToCheckView = 3.0

    let kOpenNewScreenMode1 : UIModalPresentationStyle = .fullScreen
    let kOpenNewScreenMode2 : UIModalPresentationStyle = .overFullScreen

    override func viewDidLoad() {
        super.viewDidLoad()
        
        timer = Timer.scheduledTimer(timeInterval: kTimerIntervalToCheckView,
                                     target: self,
                                     selector:#selector(startTimerToCheckIfViewIsVisible),
                                     userInfo: nil,
                                     repeats: true)

    }

    @IBAction func screen2Option1Pressed(_ sender: Any) {
        let vc = ViewController2()
        vc.modalPresentationStyle = kOpenNewScreenMode1
        self.present(vc, animated: true,completion: {})
    }
    
    @IBAction func screen2Option2Pressed(_ sender: Any) {
        let vc = ViewController2()
        vc.modalPresentationStyle = kOpenNewScreenMode2
        self.present(vc, animated: true,completion: {})

    }
    @objc
    func startTimerToCheckIfViewIsVisible() {
        

        var viewIsVisible = true
        
        if !(view.window?.isKeyWindow ?? false) {
            NSLog("view is not in the key window")
            viewIsVisible = false
        }
        else if let lvc = view.findMatchingViewController(),
            let pvc = UIApplication.shared.windows.filter({$0.isKeyWindow}).first?.presentingViewController() {

            if (pvc != lvc) {
                NSLog("the view controller matching the view is not the presenting view controller")

                viewIsVisible = false
            }
            
        }
        
        NSLog(viewIsVisible ? "view is visible" : "view is not visible")
    }
    
}

