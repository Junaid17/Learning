package model

import com.google.gson.annotations.SerializedName


/*{
    "copyright": "Justin Anderson",
    "date": "2021-06-19",
    "explanation": "Nights grow shorter and days grow longer as the summer solstice approaches in the north. Usually seen at high latitudes in summer months, noctilucent or night shining clouds begin to make their appearance.  Drifting near the edge of space about 80 kilometers above the Earth's surface, these icy clouds were still reflecting the sunlight on June 14. Though the Sun was below the horizon as seen north of Forrest, Manitoba, Canada, they were caught in a single exposure of a near midnight twilight sky. Multiple exposures of the foreground track the lower altitude flash of fireflies, another fleeting apparition shining in the summer night.",
    "hdurl": "https://apod.nasa.gov/apod/image/2106/IMG_1088_resize.jpg",
    "media_type": "image",
    "service_version": "v1",
    "title": "Northern Summer Twilight",
    "url": "https://apod.nasa.gov/apod/image/2106/IMG_1088_resize1024.jpg"
}*/
data class Apod(
    @SerializedName("copyright")
    val copyright:String,
    @SerializedName("date")
    val date:String,
    @SerializedName("explanation")
    val explanation:String,
    @SerializedName("title")
    val title:String,
    @SerializedName("hdurl")
    val hdurl:String,
    @SerializedName("url")
    val url:String
)
