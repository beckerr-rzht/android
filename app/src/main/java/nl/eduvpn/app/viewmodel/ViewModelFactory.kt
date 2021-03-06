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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import nl.eduvpn.app.service.*

class ViewModelFactory(
        private val context: Context,
        private val apiService: APIService,
        private val serializerService: SerializerService,
        private val configurationService: ConfigurationService,
        private val historyService: HistoryService,
        private val preferencesService: PreferencesService,
        private val connectionService: ConnectionService,
        private val vpnService: VPNService,
        private val organizationService: OrganizationService
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ConnectionViewModel::class.java) -> ConnectionViewModel(
                    context,
                    apiService,
                    serializerService,
                    historyService,
                    preferencesService,
                    connectionService,
                    vpnService
            ) as T
            modelClass.isAssignableFrom(ProviderSelectionViewModel::class.java) -> ProviderSelectionViewModel(
                    context,
                    apiService,
                    serializerService,
                    historyService,
                    preferencesService,
                    connectionService,
                    vpnService,
                    organizationService
            ) as T
            modelClass.isAssignableFrom(ServerSelectionViewModel::class.java) -> ServerSelectionViewModel(
                    context,
                    apiService,
                    serializerService,
                    configurationService,
                    historyService,
                    preferencesService,
                    connectionService,
                    vpnService,
                    organizationService
            ) as T
            modelClass.isAssignableFrom(OrganizationSelectionViewModel::class.java) -> OrganizationSelectionViewModel(
                    organizationService,
                    preferencesService
            ) as T
            modelClass.isAssignableFrom(CustomProviderViewModel::class.java) -> CustomProviderViewModel(
                    context,
                    apiService,
                    serializerService,
                    historyService,
                    preferencesService,
                    connectionService,
                    vpnService
            ) as T
            else -> throw RuntimeException("Unexpected model class: ${modelClass::class.java.name}")
        }
    }
}