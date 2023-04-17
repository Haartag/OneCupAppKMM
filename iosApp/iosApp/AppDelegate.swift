//
//  AppDelegate.swift
//  iosApp
//
//  Created by Valeriy Timofeev on 17.04.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import UIKit
import Firebase

class AppDelegate: NSObject, UIApplicationDelegate {
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
        FirebaseApp.configure()
        return true
    }
}
