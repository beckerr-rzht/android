/*
 * This file is part of eduVPN.
 *
 * eduVPN is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * eduVPN is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with eduVPN.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package nl.eduvpn.app.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager


/**
 * Extension method to get inputManager for Context.
 */
inline val Context.inputManager: InputMethodManager
    get() = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager


/**
 * Extension method to provide show keyboard for [View].
 */
fun View.showKeyboard() {
    this.requestFocus()
    context.inputManager.showSoftInput(this, 0)
}

/**
 * Extension method to provide hide keyboard for [View].
 */
fun View.hideKeyboard(clearFocus: Boolean = true) {
    if (clearFocus) {
        this.clearFocus()
    }
    context.inputManager.hideSoftInputFromWindow(windowToken, 0)
}