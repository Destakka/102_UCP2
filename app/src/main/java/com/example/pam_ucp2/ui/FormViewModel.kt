package com.example.pam_ucp2.ui

import androidx.lifecycle.ViewModel
import com.example.pam_ucp2.data.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FormViewModel: ViewModel() {
    private val _stateUI = MutableStateFlow(UIState())
    val stateUI: StateFlow<UIState> = _stateUI.asStateFlow()

    fun setData(ListContact: MutableList<String>) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                nama = ListContact[0],
            )
        }
    }
    fun setSAYUR(Sayur1: String) {
        _stateUI.update { stateSaatIni -> stateSaatIni.copy(sayur = Sayur1) }
    }
    fun setBUAH(Buah1: String) {
        _stateUI.update { stateSaatIni -> stateSaatIni.copy(buah = Buah1) }
    }

}