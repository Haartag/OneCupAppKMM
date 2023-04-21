//
//  LoginScreenViewModel.swift
//  iosApp
//
//  Created by Valeriy Timofeev on 21.04.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

extension LoginScreen {
    @MainActor class LoginScreenViewModel: ObservableObject {
        private let firebaseManager = FirebaseManager()
        
        @Published var email: String = ""
        @Published var password: String = ""
        @Published var isLoading: Bool = false
        @Published var isSnackbarVisible: Bool = false
        @Published var snackbarMessage: String = ""
        
        
        
        func signIn(email: String, password: String) {
            firebaseManager.signInWithEmail(email: email, password: password) { (result, error) in
                guard let result = result else {
                    // TODO: Handle error if needed
                    return
                }
                
                switch result.status {
                case .success:
                    self.isLoading = false
                    // TODO: Navigation
                case .error:
                    self.isLoading = false
                    // TODO: Error handling
                default:
                    self.isLoading = false
                }
            }
        }
    }
}
