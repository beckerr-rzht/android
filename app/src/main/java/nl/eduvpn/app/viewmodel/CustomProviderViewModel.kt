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
package nl.eduvpn.app.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import nl.eduvpn.app.R
import nl.eduvpn.app.entity.Instance
import nl.eduvpn.app.entity.Organization
import nl.eduvpn.app.service.*

class CustomProviderViewModel(context: Context,
                              apiService: APIService,
                              serializerService: SerializerService,
                              historyService: HistoryService,
                              preferencesService: PreferencesService,
                              connectionService: ConnectionService,
                              vpnService: VPNService) : ConnectionViewModel(
        context,
        apiService,
        serializerService,
        historyService,
        preferencesService,
        connectionService,
        vpnService) {

    val customProviderUrl = MutableLiveData<String>()
    val enableSignInButton = MutableLiveData<Boolean>(false)

    fun validate() {
        val customProviderUrlString = customProviderUrl.value

        enableSignInButton.value = customProviderUrlString?.isNotBlank() == true
    }
}
