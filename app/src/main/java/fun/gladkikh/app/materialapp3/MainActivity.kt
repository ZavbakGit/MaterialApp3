package `fun`.gladkikh.app.materialapp3

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list =(0..100).map {
            when {
                it % 3 == 0 -> return@map Game(
                    title = "FIFA 20 (PC-цифровая версия)",
                    image = R.drawable.image1
                )

                it % 2 == 0 -> return@map Game(
                    title = "FIFA 20 Ultimate Team - 100 FUT Points",
                    image = R.drawable.image2
                )
                else -> return@map Game(
                    title = "The Sims 4: Мир магии (PC-цифровая версия)",
                    image = R.drawable.image3
                )
            }
        }


        val adapter = MyAdapter(list,this)

        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
    }


    class MyAdapter(val items: List<Game>, val context: Context) :
        RecyclerView.Adapter<ViewHolder>() {
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(items[position])
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
        }

        override fun getItemCount(): Int = items.size
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private val image = v.findViewById<ImageView>(R.id.image)
        private val info = v.findViewById<TextView>(R.id.tvInfo)

        fun bind(game: Game) {
            image.setImageResource(game.image)
            info.text = game.title
        }

    }

}
