package com.example.movielist

import android.os.Parcel
import android.os.Parcelable


data class MyData(
    val drawable: Int,
    val title: String,
    var isBookmarked: Boolean):
    Parcelable {
    constructor(parcel: Parcel) : this(
        (parcel.readInt() ?: "") as Int,
        parcel.readString() ?: "",
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(drawable)
        parcel.writeString(title)
        parcel.writeByte(if (isBookmarked) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MyData> {
        override fun createFromParcel(parcel: Parcel): MyData {
            return MyData(parcel)
        }

        override fun newArray(size: Int): Array<MyData?> {
            return arrayOfNulls(size)
        }
    }
    }
