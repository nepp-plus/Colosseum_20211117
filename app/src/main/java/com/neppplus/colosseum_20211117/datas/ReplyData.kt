package com.neppplus.colosseum_20211117.datas

import org.json.JSONObject

class ReplyData {

    var id = 0
    var content = ""

    var writer = UserData()  // 사용자데이터가 들어올거라고 명시.

//    어느 진영에 대한 댓글?
    var selectedSide = SideData()


    companion object {

        fun getReplyDataFromJson( jsonObj:  JSONObject ) : ReplyData {

            val replyData = ReplyData()

            replyData.id = jsonObj.getInt("id")
            replyData.content = jsonObj.getString("content")

            val userObj = jsonObj.getJSONObject("user")
            replyData.writer = UserData.getUserDataFromJson(userObj)

            val sideObj = jsonObj.getJSONObject("selected_side")
            replyData.selectedSide =  SideData.getSideDataFromJson(sideObj)

            return replyData

        }

    }

}