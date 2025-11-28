package com.track.union.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.track.union.presentation.auth.CreateProfileScreen
import com.track.union.presentation.auth.LoginScreen
import com.track.union.presentation.auth.OtpVerificationScreen
import com.track.union.presentation.dashboard.ChatScreen
import com.track.union.presentation.dashboard.DepositMoneyScreen
import com.track.union.presentation.dashboard.HelpSupportScreen
import com.track.union.presentation.dashboard.HistoryViewDetailScreen
import com.track.union.presentation.dashboard.HomeScreen
import com.track.union.presentation.dashboard.NotificationScreen
import com.track.union.presentation.dashboard.PrivacyPolicyScreen
import com.track.union.presentation.dashboard.ProfileScreen
import com.track.union.presentation.dashboard.SelectLocationScreen
import com.track.union.presentation.dashboard.TermsConditionScreen
import com.track.union.presentation.dashboard.TripHistoryScreen
import com.track.union.presentation.dashboard.WalletScreen

@Composable
fun AppNavHost(navController : NavHostController = rememberNavController(), startDestination: String) {
    NavHost(navController=navController,startDestination=startDestination){
        composable(Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(Screen.Verification.route) {
            OtpVerificationScreen(navController)
        }
        composable(Screen.CreateProfileScreen.route) {
            CreateProfileScreen(navController)
        }
        composable(Screen.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(Screen.SelectLocationScreen.route) {
            SelectLocationScreen(navController)
        }
        composable(Screen.HistoryScreen.route) {
            TripHistoryScreen(navController)
        }
        composable(Screen.HistoryDetailScreen.route) {
            HistoryViewDetailScreen(navController)
        }
        composable(Screen.ProfileScreen.route) {
           ProfileScreen(navController)
        }
        composable(Screen.WalletScreen.route) {
           WalletScreen(navController)
        }
        composable(Screen.DepositMoneyScreen.route) {
          DepositMoneyScreen(navController)
        }
        composable(Screen.NotificationScreen.route) {
            NotificationScreen(navController)
        }
        composable(Screen.PrivacyPolicy.route) {
            PrivacyPolicyScreen(navController)
        }
        composable(Screen.TermsConditionScreen.route) {
           TermsConditionScreen(navController)
        }
        composable(Screen.HelpSupportScreen.route) {
            HelpSupportScreen(navController)
        }
        composable(Screen.ChatScreen.route) {
           ChatScreen(navController)
        }
    }

}