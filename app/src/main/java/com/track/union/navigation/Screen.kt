package com.track.union.navigation

sealed class Screen(val route:String){
    data object Login :Screen("login")
    data object Verification :Screen("verification")
    data object CreateProfileScreen :Screen("create_profile")
    data object HomeScreen :Screen("home")
    data object SelectLocationScreen :Screen("location")
    data object HistoryScreen :Screen("history")
    data object HistoryDetailScreen :Screen("history_detail")
    data object ProfileScreen :Screen("profile")
    data object WalletScreen :Screen("wallet")
    data object DepositMoneyScreen :Screen("deposit_money")
    data object NotificationScreen :Screen("notification")
    data object PrivacyPolicy :Screen("privacy")
    data object TermsConditionScreen :Screen("terms_condition")
    data object HelpSupportScreen :Screen("help_support")
    data object ChatScreen :Screen("chat")

}