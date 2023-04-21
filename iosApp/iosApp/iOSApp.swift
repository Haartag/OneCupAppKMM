import SwiftUI
import shared
import Firebase

@main
struct iOSApp: App {
    @UIApplicationDelegateAdaptor(AppDelegate.self) var appDelegate
    
	var body: some Scene {
		WindowGroup {
            NavigationView{
                LoginScreen()
            }
		}
	}
}
