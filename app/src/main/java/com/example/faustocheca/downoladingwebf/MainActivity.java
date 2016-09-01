package com.example.faustocheca.downoladingwebf;

import android.graphics.Bitmap;
import android.graphics.Path;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String url = "http://www.hrsanroque.com/galeria/slider/18.jpg";
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*

        Abrir tarea / método en clase Asíncrona, excluye okhttp etc
            medir el tiempo inicial http://stackoverflow.com/questions/7965065/android-to-measure-the-time-betweeen-the-two-button-clicks
            bajar la imagen de Internet http://stackoverflow.com/questions/18210700/best-method-to-download-image-from-url-in-android
            obtener un resultado
            medir el tiempo final


        convertir la response en algo almacenable
        Dibujar en imageview

        */

        Button buttonDown = (Button) findViewById(R.id.button_download);

        buttonDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Operation operation = new Operation();
                Bitmap bitmap = operation.getBitmap();
                long timeDifference = operation.getTimeDifference();
                textView = (TextView) findViewById(R.id.textview_result);
                textView.setText(String.valueOf(timeDifference));
                imageToImageView (bitmap);




            }
        });



    }

    private void imageToImageView(Bitmap bitmap) {

        imageView = (ImageView) findViewById(R.id.imageView_photo);
        imageView.setImageBitmap(bitmap);




    }

}
