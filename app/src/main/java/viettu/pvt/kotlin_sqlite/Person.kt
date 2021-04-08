package viettu.pvt.kotlin_sqlite

class Person {
    var Id:Int = 0
    var Name:String?=null
    var Email : String? =null
    constructor()
    constructor( Id : Int,Name :String , Email: String ){
        this.Id = Id
        this.Name = Name
        this.Email = Email

    }
}