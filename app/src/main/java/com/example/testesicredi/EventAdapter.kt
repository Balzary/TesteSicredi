package com.example.testesicredi

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*
import kotlin.coroutines.coroutineContext

class EventAdapter(val eventModel:MutableList<EventModel>):RecyclerView.Adapter<EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.event_cell, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        return holder.bindView(eventModel[position])


    }

    override fun getItemCount(): Int {
        return eventModel.size
    }


}

class EventViewHolder(itemView: View) : RecyclerView.ViewHolder (itemView){

    private val txtEventTitle: TextView = itemView.findViewById(R.id.eventName)
    private val imgEvent: ImageView = itemView.findViewById(R.id.eventImage)
    private val txtEventDate: TextView = itemView.findViewById(R.id.eventObs)

//    val mainLayout : LinearLayout = itemView.findViewById(R.id.mainLayout)

    private fun getDateTime(s: String): String? {
        try {
            val sdf = SimpleDateFormat("dd/MM/yyyy")
            val netDate = Date(s.toLong())
            return sdf.format(netDate)
        } catch (e: Exception) {
            return e.toString()
        }
    }

    fun bindView(eventModel: EventModel){
        txtEventTitle.text = eventModel.title

//        val stamp = Timestamp(System.currentTimeMillis())
//        val date = Date(stamp.getTime())
//        println(date)

        txtEventDate.text = getDateTime(eventModel.date.toString())

        val img = eventModel.image
        if("http:" in img!!){
            var i: StringBuffer = StringBuffer(img)
            i.insert(4, "s")
            Picasso.get().load(i.toString()).into(imgEvent)
        }else{
            Picasso.get().load(img).into(imgEvent)
        }

        itemView.setOnClickListener {
            val model = eventModel
            var eTitle : String = model.title.toString()
            var eDesc : String = model.description.toString()
            //modificar data
            var eDate : String = model.date.toString()
            var ePrice : String = model.price.toString()
            var eImage : String = model.image.toString()

            val intent = Intent(itemView.context, EventDetailActivity::class.java)
            intent.putExtra("title", eTitle)
            intent.putExtra("desc", eDesc)
            intent.putExtra("date", eDate)
            intent.putExtra("price", ePrice)
            intent.putExtra("image", eImage)
            itemView.context.startActivity(intent)
       }

    }
}