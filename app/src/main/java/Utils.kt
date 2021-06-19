import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.net.ConnectivityManager

object Utils {

    fun Context.isconnected(): Boolean {
        val connectivityManager =
            this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectivityManager.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }


     fun Context.showErrorDialog(message: String) {
         val builder = AlertDialog.Builder(this)
         builder.setTitle("Loading Error")
         builder.setMessage(message)
//builder.setPositiveButton("OK", DialogInterface.OnClickListener(function = x))

         builder.setPositiveButton(android.R.string.yes) { dialog, which ->

         }

         builder.setNegativeButton(android.R.string.no) { dialog, which ->

         }

         builder.setNeutralButton("Maybe") { dialog, which ->

         }
         builder.show()

    }
}