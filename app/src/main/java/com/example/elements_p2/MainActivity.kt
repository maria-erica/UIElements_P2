package com.example.elements_p2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*

class MainActivity : AppCompatActivity() {
    val queueListView = ArrayList<String>()
    val songsArray = arrayOf(
            "Part of Me",
            "One More Night",
            "Pretty Hurts",
            "Holy",
            "Livin\' On A Prayer",
            "Teenage Dream",
            "Nver Say Goodbye",
            "Girls Like You","She Will Be Loved",
            "Drunk In Love", "Listen",
            "Company",
            "Daylight",
            "Last Friday Night(T.G.I.F)",
            "Partition","Halo",
            "Wild in the Streets","I\'d Die for you",
            "Lucky Strike","Memories",
            "The One That Got Away","Dark Horse",
            "Love Yourself",
            "Thinking of You","Roar",
            "Payphone",
            "Sorry",
            "What Do You Mean?","10,000 Hours")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Song List View Adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, songsArray)
        val songsListView = findViewById<ListView>(R.id.songsListView)
        songsListView.adapter = adapter

        val listView = findViewById<ListView>(R.id.songsListView)
        registerForContextMenu(listView)
    }

    //Context Menu
    override fun onCreateContextMenu(
            menu: ContextMenu?,
            v: View?,
            menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.songs_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val menuInfo = item.menuInfo as AdapterView.AdapterContextMenuInfo
        return when (item.itemId) {
            R.id.add_queue -> {
                queueListView.add(songsArray[menuInfo.position])
                true
            }
            else -> {
                return super.onContextItemSelected(item)
            }

        }

    }

    //Main Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.go_to_album -> {
                startActivity(Intent(this, albums::class.java))
                true
            }
            R.id.go_to_songs -> {
                startActivity(Intent(this, MainActivity::class.java))
                true
            }
            R.id.go_to_queue -> {
                val intent = Intent(this, songs_queue::class.java)
                intent.putStringArrayListExtra("songs", queueListView)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

