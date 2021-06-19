package viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import model.Apod
import model.ApodService
import javax.inject.Inject

class ApodViewModel : ViewModel() {

    @Inject
    lateinit var apodService:ApodService

    val apod= MutableLiveData<Apod>()
    val loadError= MutableLiveData<Boolean>()
}