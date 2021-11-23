package com.example.testesicredi

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import com.squareup.picasso.Picasso

class EventDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail)

        val txtDetailTitle: TextView = findViewById(R.id.txtDetailTitle)
        val imgDetailEvent: ImageView = findViewById(R.id.imgDetail)
        val txtDetailDesc: TextView = findViewById(R.id.txtDetailDesc)
        val btnDetail: Button = findViewById(R.id.btnDetail)

//        btnDetail.setOnClickListener{
//            onClickButton(btnDetail)
//        }

        btnDetail.setOnClickListener{
            val dialog = EventDialogForm()
            dialog.show(supportFragmentManager, "EventDialogForm")
        }

        ///

        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        var intent = intent
        val iTitle = intent.getStringExtra("title")
        val iDesc = intent.getStringExtra("desc")
        val iDate = intent.getStringExtra("date")
        val iPrice = intent.getStringExtra("price")
        val iImage = intent.getStringExtra("image")

        txtDetailDesc.text = iDesc
        txtDetailTitle.text = iTitle
        if(iPrice.count() < 5){
            var i:StringBuffer = StringBuffer(iPrice)
            i.insert(3, "0")
            btnDetail.text = "R$" + i
        }else{
            btnDetail.text = "R$" + iPrice
        }


        val img = iImage
        if("http:" in img!!){
            var i: StringBuffer = StringBuffer(img)
            i.insert(4, "s")
            Picasso.get().load(i.toString()).into(imgDetailEvent)
        }else{
            Picasso.get().load(img).into(imgDetailEvent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.share_menu, menu)
        return true
    }

   override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.Share -> {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra("Compartilhe este evento", intent.getStringExtra("title"))
                val chooser = Intent.createChooser(intent, "Compatilhar usando...")
                startActivity(chooser)
                return true
            } else -> super.onOptionsItemSelected(item)
        }
    }

//    fun btnSendForm(){
//        val btnDetail: Button = findViewById(R.id.btnDetail)
//        btnDetail.setOnClickListener{
//            val mDialogView = LayoutInflater.from(this).inflate(R.layout.layout_form, null)
//
//            val mBuilder = AlertDialog.Builder(this)
//                .setView(mDialogView)
//                .setTitle("Participar do Evento")
//
//            val mAlertDialog = mBuilder.show()
//
//
//            }
//        }
//    }

//    fun onClickButton(view: View) {
//        EventDialogForm().show(supportFragmentManager, "EventDialogForm")
//
//    }


}