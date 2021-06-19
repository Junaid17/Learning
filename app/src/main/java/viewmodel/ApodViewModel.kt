package viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learning.di.DaggerAPIComponent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import model.Apod
import model.ApodService
import javax.inject.Inject

class ApodViewModel : ViewModel() {

    @Inject
    lateinit var apodService:ApodService

    val apod= MutableLiveData<Apod>()
    val loadError= MutableLiveData<Boolean>()
    private val disposable= CompositeDisposable()
    val loading= MutableLiveData<Boolean>()

    init {
        DaggerAPIComponent.create().inject(this)
    }

    fun refresh(){
        fetchCountries()
    }

    private fun fetchCountries() {
        loading.value=true
        disposable.add(
            apodService.getApod()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Apod>(){
                    override fun onSuccess(apodlist: Apod) {
                        apod.value=apodlist
                        loadError.value=false
                        loading.value=false
                    }

                    override fun onError(e: Throwable) {
                        loadError.value=true
                        loading.value=false
                    }

                })
        )


    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}