package com.example.music_mixing_v1

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG : String = "MainActivity"
    var mediaplayer1 : MediaPlayer?= null
    var mediaplayer2 : MediaPlayer?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //문제1. 음원 시작 타이밍이 다른 음원이나 전체 길이를 직접 다 맞춰야함. 다르면 이 파일처럼 안맞는 소리가 나옴.
        //문제2. BPM, 분위기 등 어울리는 샘플 조합을 인공지능을 쓸 수 없기 때문에 우리가 직접 다 골라내고 맞춰야함
        //문제3. 감정, 날씨, 시간, 계절, 위치 분류에서 조합되는 카테고리가 너무 많음 -> 그 음원 파일을 다 직접 다듬기가 사실상 불가능
        //문제4. 그 분류에 맞춰서 다듬고 분류를 한다해도 사용자가 완성음원을 들었을 때 겹치는 음악이 상당수 나올것으로 예상됨
        //문제5. 코틀린 내장 음원플레이인 미디어플레이어 사용시 음질이 심히 깨진다.

        mediaplayer1 = MediaPlayer.create(this, R.raw.drum)
        mediaplayer2 = MediaPlayer.create(this, R.raw.piano)


        //버튼을 클릭하면 음원 재생
        buttonPlay.setOnClickListener {
            //재생할 파일을 준비
            mediaplayer1?.start()
            mediaplayer2?.start()
        }
    }

    override fun onDestroy () {
        super.onDestroy ()
        mediaplayer1?.release ()
        mediaplayer2?.release ()
    }
}