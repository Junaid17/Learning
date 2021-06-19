package viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import model.Apod

class ApodViewModel : ViewModel() {

    val apod= MutableLiveData<Apod>()
    val loadError= MutableLiveData<Boolean>()
}