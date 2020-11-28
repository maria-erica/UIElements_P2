package com.example.elements_p2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView

var albumSongs = ArrayList<String>()
var albumURI = String

class albums : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)

        //Map the Grid View
        val GridView = findViewById<GridView>(R.id.albumView) as GridView
        //Attach the adapter to the Grid View
        GridView.adapter = albumAdapter(applicationContext)
        //Item click listener for the Grid View
        GridView.onItemClickListener = AdapterView.OnItemClickListener{parent, v, position, id ->
            val intent = Intent(this, albumsDetail::class.java)
            var uri: String
            if (position == 0) {
                uri = "@drawable/maroon"
                albumSongs.clear()
                albumSongs.addAll(resources.getStringArray(R.array.Overexposed))
            } else if (position == 1) {
                uri = "@drawable/katy_perry"
                albumSongs.clear()
                albumSongs.addAll(resources.getStringArray(R.array.Teenage_Dream))
            }else if (position == 2) {
                uri = "@drawable/yonce"
                albumSongs.clear()
                albumSongs.addAll(resources.getStringArray(R.array.Yonce))
            }else if (position == 3){
                uri = "@drawable/justin_bieber"
                albumSongs.clear()
                albumSongs.addAll(resources.getStringArray(R.array.Purpose))
            } else {
                uri = "@drawable/bon_jovi"
                albumSongs.clear()
                albumSongs.addAll(resources.getStringArray(R.array.Jovi))
            }
            intent.putExtra("imageUri",  uri)
            startActivity(intent)


        }

    }




}



