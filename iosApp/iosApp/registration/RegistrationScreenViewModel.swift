//
//  RegistrationScreenViewModel.swift
//  iosApp
//
//  Created by Valeriy Timofeev on 17.04.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

extension FirebaseEmailRegForm {
    @MainActor class RegistrationScreenViewModel: ObservableObject {
        private let firebaseManager = FirebaseManager()
        
        @Published var email: String = ""
        @Published var password: String = ""
        @Published var confirmPassword: String = ""
        @Published var isLoading: Bool = false
        
        var isFormValid: Bool {
            return !email.isEmpty && !password.isEmpty && !confirmPassword.isEmpty && password == confirmPassword
        }
        
        func createAccount(email: String, password: String) {
                isLoading = true
                firebaseManager.signUpWithEmail(email: email, password: password) { (result, error) in
                    guard let result = result else {
                        self.isLoading = false
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
