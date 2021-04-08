package viettu.pvt.kotlin_sqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper (context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VER) {
    companion object{
        val  DATABASE_NAME :String = "person.db"
        val  DATABASE_VER:Int = 1
        val TABLE_NAME :String = "Persion"
        val  COL_ID: String = "ID"
        val  COL_NAME :String ="NAME"
        val  COL_EMAIL :String = "EMAIL"

    }

    override fun onCreate(db: SQLiteDatabase?) {
       val sql:String = ("CREATE TABLE $TABLE_NAME($COL_ID INTEGER PRIMARY KEY, $COL_NAME TEXT, $COL_EMAIL TEXT)")
        db!!.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val sql : String = ("DROP TABLE IF EXITS $TABLE_NAME")
        db!!.execSQL(sql)
        onCreate(db)
    }

    val  allPerson:List<Person>
        get() {
         val  listPerSon = ArrayList<Person>()
            val  selectQuery = " SELECT * FROM $TABLE_NAME"
            val  db: SQLiteDatabase = this.writableDatabase
            val  cursor: Cursor = db.rawQuery(selectQuery, null)
            if (cursor.moveToFirst()){
                do {
                    val  person = Person()
                    person.Id = cursor.getInt(cursor.getColumnIndex(COL_ID))
                    person.Name = cursor.getString(cursor.getColumnIndex(COL_NAME))
                    person.Email = cursor.getString(cursor.getColumnIndex(COL_EMAIL))
                    listPerSon.add(person)
                }while (cursor.moveToNext())
            }
            return listPerSon

        }

    fun  addPerSon(person: Person){
       val db: SQLiteDatabase = this.writableDatabase
       val content:ContentValues = ContentValues()
       content.put(COL_ID, person.Id)
       content.put(COL_NAME, person.Name)
       content.put(COL_EMAIL, person.Email)
       db.insert(TABLE_NAME,null, content)
       db.close()

   }
    fun  updatePerSon(person: Person){
        val db: SQLiteDatabase = this.writableDatabase
        val values :ContentValues = ContentValues()
        values.put(COL_ID, person.Id)
        values.put(COL_NAME, person.Name)
        values.put(COL_EMAIL, person.Email)
        db.update(TABLE_NAME,values, "$COL_ID = ?", arrayOf(person.Id.toString()))
        db.close()

    }
    fun  DeletePerSon(person: Person){
        val db = this.writableDatabase
        db.delete(TABLE_NAME, "$COL_ID = ?", arrayOf(person.Id.toString()))
        db.close()
    }


}