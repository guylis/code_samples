//
//  ViewUtilities.swift
//  CheckViewOnScreen
//
//  Created by Guy Lis on 13/06/2022.
//

import Foundation

import Foundation
import UIKit

extension UIWindow {
    func presentingViewController() -> UIViewController? {
        var top = self.rootViewController
        while true {
            if let presented = top?.presentedViewController {
                top = presented
            } else if let nav = top as? UINavigationController {
                top = nav.visibleViewController
            } else if let tab = top as? UITabBarController {
                top = tab.selectedViewController
            } else {
                break
            }
        }
        return top
    }
}


extension UIView {
    func findMatchingViewController() -> UIViewController? {
        if let nextResponder = self.next as? UIViewController {
            return nextResponder
        } else if let nextResponder = self.next as? UIView {
            return nextResponder.findMatchingViewController()
        } else {
            return nil
        }
    }
}
