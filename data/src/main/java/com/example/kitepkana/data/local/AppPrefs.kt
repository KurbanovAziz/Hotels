package com.example.kitepkana.data.local

import android.content.Context

class AppPrefs(context: Context) {

    private val prefs = context.getSharedPreferences(ARGS_PREFS, Context.MODE_PRIVATE)


    fun saveImage(image: String) {
        prefs.edit().putString(IMAGE_KEY, image).apply()
    }

    fun getImage(): String {
        return prefs.getString(IMAGE_KEY,"").toString()
    }

    var id:Int
        get() = prefs.getInt(ARGS_IS_ID,0)
        set(value) = prefs.edit().putInt(ARGS_IS_ID,value).apply()

    var page:Int
        get() = prefs.getInt(ARGS_IS_FAVORITE,1)
        set(value) = prefs.edit().putInt(ARGS_IS_FAVORITE,value).apply()

    var jwtAccess: String?
        get() = prefs.getString(ARGS_JWT_ACCESS,"")
        set(access) = prefs.edit().putString(ARGS_JWT_ACCESS, access).apply()
    var jwtRefresh: String?
        get() = prefs.getString(ARGS_JWT_REFRESH,"JWT")
        set(refresh) = prefs.edit().putString(ARGS_JWT_REFRESH,"JWT $refresh").apply()

    var onBoard:Boolean
        get() = prefs.getBoolean(ARGS_ON_BOARD,false)
        set(value) = prefs.edit().putBoolean(ARGS_ON_BOARD,value).apply()

    companion object{
        const val IMAGE_KEY = "image.key"
        const val ARGS_PREFS = "prefs"
        const val ARGS_ON_BOARD = "onBoard"
        const val ARGS_IS_FAVORITE = "isFavorite"
        const val ARGS_IS_ID = "ID"
        const val ARGS_JWT_ACCESS = "access"
        const val ARGS_JWT_REFRESH = "refresh"
    }
}