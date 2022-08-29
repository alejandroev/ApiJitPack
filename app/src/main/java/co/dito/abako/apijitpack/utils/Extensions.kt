package co.dito.abako.apijitpack.utils

import android.util.Patterns
import java.util.regex.Pattern

fun String.validateEmail() : Boolean = Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun String.validateNumber(): Boolean =
    Pattern.compile("(3)[ -]*([0-9][ -]*){9}").matcher(this).matches() ||
            Pattern.compile("(60)[ -]*([0-9][ -]*){8}").matcher(this).matches()