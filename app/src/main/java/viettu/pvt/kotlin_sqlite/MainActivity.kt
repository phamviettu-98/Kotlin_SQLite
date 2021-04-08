package viettu.pvt.kotlin_sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    internal  lateinit var db:DatabaseHelper
    internal  var lstPerson: List<Person> = ArrayList<Person>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = DatabaseHelper(this)
        refreshDATA()
        btn_add.setOnClickListener {
            val  person = Person(
                Integer.parseInt(edt_id.text.toString()),
                edt_name.text.toString(), edt_email.text.toString())
            db.addPerSon(person)
            refreshDATA()
        }
        btn_update.setOnClickListener {
            val  person = Person(
                Integer.parseInt(edt_id.text.toString()),
                edt_name.text.toString(), edt_email.text.toString())
            db.addPerSon(person)
            refreshDATA()
        }
        btn_detele.setOnClickListener {
            val  person = Person(
                Integer.parseInt(edt_id.text.toString()),
                edt_name.text.toString(), edt_email.text.toString())
            db.DeletePerSon(person)
            refreshDATA()
        }
    }
    private fun refreshDATA() {
        lstPerson = db.allPerson
        val  adapter  = ListPersonAdapter(this,lstPerson, edt_id,edt_name, edt_email )
        listPerson.adapter = adapter
    }
}