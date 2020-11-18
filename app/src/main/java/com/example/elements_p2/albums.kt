package com.example.elements_p2

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class albums : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)

            val GridView = findViewById<GridView>(R.id.albumView) as GridView
            GridView.adapter = albumAdapter(applicationContext)
            GridView.onItemClickListener = AdapterView.OnItemClickListener{parent, v, position, id ->
                val intent = Intent(this, albumsDetail::class.java)
                var songsToBeDisplay = arrayListOf<String>()
                var uri: String = ""

                if (position ==0){
                    uri = "@drawable/maroon"
                    songsToBeDisplay.clear()
                    songsToBeDisplay.addAll(resources.getStringArray(R.array.Overexposed))

                } else if(position == 1) {
                    uri = "@drawable/katy_perry"
                    songsToBeDisplay.clear()
                    songsToBeDisplay.addAll(resources.getStringArray(R.array.Teenage_Dream))

                } else if(position == 2){
                    uri = "@drawable/yonce"
                    songsToBeDisplay.clear()
                    songsToBeDisplay.addAll(resources.getStringArray(R.array.Yonce))

                } else if(position == 3) {
                    uri = "@drawable/justin_bieber"
                    songsToBeDisplay.clear()
                    songsToBeDisplay.addAll(resources.getStringArray(R.array.Purpose))

                }else{
                    uri = "@drawable/bon_jovi"
                    songsToBeDisplay.clear()
                    songsToBeDisplay.addAll(resources.getStringArray(R.array.Jovi))

                }

                intent.putStringArrayListExtra("songs", songsToBeDisplay)
                intent.putExtra("imageUri", uri)
                intent.putExtra("position",position)
                startActivity(intent)

            }
    }
}