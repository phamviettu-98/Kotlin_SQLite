package viettu.pvt.kotlin_sqlite

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import kotlinx.android.synthetic.main.row_layout.view.*

class ListPersonAdapter(internal var activity: Activity, internal  var lstPerson:List<Person>,
                        internal  var edt_id: EditText, internal  var edt_name: EditText,
                        internal  var edt_email: EditText)  :BaseAdapter() {
    internal var inflater : LayoutInflater
    init {
        inflater= activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
    override fun getCount(): Int {

        return  lstPerson.size
    }

    override fun getItem(position: Int): Any {

        return  lstPerson[position]
    }

    override fun getItemId(position: Int): Long {

        return  lstPerson[position].Id.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val  rowview: View

        rowview = inflater.inflate(R.layout.row_layout,null)

        rowview.txt_row_id.text = lstPerson[position].Id.toString()
        rowview.txt_name.text = lstPerson[position].Name.toString()
        rowview.txt_email.text = lstPerson[position].Email.toString()
        rowview.setOnClickListener {
            edt_id.setText(rowview.txt_row_id.text.toString())
            edt_name.setText(rowview.txt_name.text.toString())
            edt_email.setText(rowview.txt_email.text.toString())

        }
        return  rowview



    }
}