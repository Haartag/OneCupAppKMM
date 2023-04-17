//
//  RegistrationScreen.swift
//  iosApp
//
//  Created by Valeriy Timofeev on 17.04.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct FirebaseEmailRegForm: View {
    @StateObject var viewModel = RegistrationScreenViewModel()
    
    var body: some View {
        VStack(alignment: .center, spacing: 24) {
            TextField("Email address", text: $viewModel.email)
                .textFieldStyle(RoundedBorderTextFieldStyle())
                .padding([.leading, .trailing], 16)
            SecureField("Password", text: $viewModel.password)
                .textFieldStyle(RoundedBorderTextFieldStyle())
                .padding([.leading, .trailing], 16)
            SecureField("Confirm password", text: $viewModel.confirmPassword)
                .textFieldStyle(RoundedBorderTextFieldStyle())
                .padding([.leading, .trailing], 16)
            if viewModel.isLoading {
                ProgressView()
            } else {
                Button(action: {
                    viewModel.createAccount(email: viewModel.email, password: viewModel.password)
                }) {
                    Text("Registration")
                }
                .disabled(!viewModel.isFormValid)
                .frame(maxWidth: .infinity, alignment: .center)
                .padding([.leading, .trailing], 16)
            }
        }
        .padding(.top, 24)
    }
}
