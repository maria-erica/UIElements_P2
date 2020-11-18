package com.example.elements_p2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView

class albumsDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums_detail)

        //Intents from the previous activity
        val uri = intent.getStringExtra("imageUri")
        val songsToBeDisplayed = intent.getStringArrayListExtra("songs")

        //Convertion of the intent into array because it is a type of Array List
        var songsArray = songsToBeDisplayed!!.toTypedArray()

        //Mapping the ImageView
        val AlbumCover = findViewById<ImageView>(R.id.viewImage)
        //Mapping the List View
        val albumDetailsListView = findViewById<ListView>(R.id.listView)


        var imageResource = getResources().getIdentifier(
                uri,
                null,
                getPackageName()
        ) //Resource using the URI
        var res =
                getResources().getDrawable(imageResource) //Converting the image resource into a drawable file
        AlbumCover.setImageDrawable(res) //Attach/set the drawable to the Image view


        val adapter =
                ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsArray)
        albumDetailsListView.adapter = adapter

        Log.i("try", songsToBeDisplayed.toString())
    }
}