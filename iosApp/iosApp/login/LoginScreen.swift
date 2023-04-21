//
//  LoginScreen.swift
//  iosApp
//
//  Created by Valeriy Timofeev on 21.04.23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct LoginScreen: View {
    @StateObject var viewModel = LoginScreenViewModel()

    var body: some View {
        VStack {
            TextField("Email address", text: $viewModel.email)
                .textFieldStyle(RoundedBorderTextFieldStyle())
                .padding([.leading, .trailing], 16)
            SecureField("Password", text: $viewModel.password)
                .textFieldStyle(RoundedBorderTextFieldStyle())
                .padding([.leading, .trailing], 16)
            Button(action: {
                viewModel.signIn(email: viewModel.email, password: viewModel.password)
            }) {
                Text("Sign in")
            }
            .padding()
            NavigationLink(destination: FirebaseEmailRegForm()) {
                Text("Sign up")
            }
        }
        Spacer()
    }
}
