package com.gofootball.football.util

import android.text.TextUtils
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.gofootball.football.R
import java.text.SimpleDateFormat
import java.util.*
import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import java.util.*
import kotlin.math.floor


@BindingAdapter("android:backgroundLeagueState")
fun setBackgroundLeagueState(textView: TextView, url: String?) {
    if (url == "Promotion - Champions League (Group Stage)") {
        textView.setBackgroundColor(textView.resources.getColor(R.color.colorChampionsLeagueGroup))
    } else if (url == "Promotion - Champions League (Qualification)") {
        textView.setBackgroundColor(textView.resources.getColor(R.color.colorChampionsLeagueQualification))
    } else if (url == "Promotion - Europa League (Group Stage)") {
        textView.setBackgroundColor(textView.resources.getColor(R.color.colorEuropaLeagueGroup))
    } else if (url == "Promotion - Europa League (Qualification)") {
        textView.setBackgroundColor(textView.resources.getColor(R.color.colorEuropaLeagueQualification))
    } else if (url == "Promotion - Eredivisie (Europa League - Play Offs)") {
        textView.setBackgroundColor(textView.resources.getColor(R.color.colorEredivisie))
    } else if (url == null) {
        textView.setBackgroundColor(textView.resources.getColor(android.R.color.transparent))
    }
}

@BindingAdapter("convertDate")
fun TextView.convertDate(date: String) {
    //Creating a SimpleDateFormat in api pattern
    var dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())

    //Set the timezone to the api timezone
    dateFormat.timeZone = TimeZone.getTimeZone("UTC")
    val dateFormatted = dateFormat.parse(date)

    //Setting a new pattern to match the expected format
    dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

    //Setting the timezone to match the local timezone
    dateFormat.timeZone = TimeZone.getDefault()
    if (TextUtils.isEmpty(date)) {
        text = ""
        return
    }
    val convertedDate = dateFormat.format(dateFormatted!!)
    text = convertedDate
}

fun getShortDate(ts: Long?): String {
    if (ts == null) return ""
    //Get instance of calendar
    val calendar = Calendar.getInstance(Locale.getDefault())
    //get current date from ts
    calendar.timeInMillis = ts
    //return formatted date
    return android.text.format.DateFormat.format("E, dd MMM yyyy", calendar).toString()
}

@BindingAdapter("shortDate")
fun TextView.shortDate(ts: String? = "") {
    if (TextUtils.isEmpty(ts)) {
        text = ""
        return
    }
    val date = ts?.toLongOrNull() ?: System.currentTimeMillis()
    text = getShortDate(date)
}
@BindingAdapter("stringValue")
fun TextView.stringValue(ts: Int?) {
    if (TextUtils.isEmpty(ts.toString())) {
        text = "0"
        return
    }

    text = ts.toString()
}

@BindingAdapter("android:dayConverter")
fun convertToDay(view: TextView, value: Long) {
    var converter = SimpleDateFormat("EEE, d MMM yyyy hh:mm a")
    var convertedDay = converter.format(Date(value * 1000))
    view.text = convertedDay
}
