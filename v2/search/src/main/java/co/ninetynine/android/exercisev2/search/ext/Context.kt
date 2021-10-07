package co.ninetynine.android.exercisev2.search.ext

import android.content.Context
import android.view.LayoutInflater

fun Context.getLayoutInflater() = getSystemService(
    Context.LAYOUT_INFLATER_SERVICE
) as LayoutInflater