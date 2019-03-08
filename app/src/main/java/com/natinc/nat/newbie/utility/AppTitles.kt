package com.natinc.nat.newbie.utility

enum class AppTitles {
    Explore,
    Trends,
    Search,
    Library
}

enum class LibraryTitles(val s: String) {
    Downloads("Downloads"),
    Tracks("Favourite tracks"),
    Artists("Artists"),
    Albums("Albums")
}