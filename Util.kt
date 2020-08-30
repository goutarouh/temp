package com.example.sample

import android.util.Log


fun <T> T.easyLog() = Log.i("hasegawa", this.toString())