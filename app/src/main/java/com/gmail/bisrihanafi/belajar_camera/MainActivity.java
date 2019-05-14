package com.gmail.bisrihanafi.belajar_camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 1 : mengaitkan object dengan komponen view
        Button camera= (Button) findViewById(R.id.open);
        iv=(ImageView)findViewById(R.id.img1);

        //TODO 2 : membuat event untuk tombol open untuk membuka kamera
        camera.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO 3 : membuat intent untuk mengaksesk kamera dengan nilai kembaian berupa gambar bitmap request code 0
                Intent tp=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(tp,0);
            }
        });
    }
    //TODO 4 : membuat method untuk pengembailian nilai
    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data){

        //TODO 5 : mengirimkan data parameter ke super klas
        super.onActivityResult(requestCode,resultCode,data);

        //TODO 6 : menyeleksi kondisi apakah gambar jadi iambil menggunakan kamera atau tidak jika iya maka result ok yang akan tereksekusi jika tidak maka result censle yang akan tereksekusi
        if (resultCode==RESULT_OK) {
            //TODO 7 : tahap penampil gambar
            Bitmap bi = (Bitmap) data.getExtras().get("data");
            iv.setImageBitmap(bi);
        }else if (resultCode==RESULT_CANCELED){
            Toast.makeText(this, "kamera tidak jadi digunakan", Toast.LENGTH_LONG).show();
        }
    }


}
