package com.example.ejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.academiaandroid.demodb.MyOpenHelper;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.GoogleMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity<rs, i> extends AppCompatActivity {
    RelativeLayout relativeLayout;
    EditText usuario, contrasena, chistes;
    Button botonlogin;
    private String url;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = findViewById(R.id.correo);
        contrasena = findViewById(R.id.contrasena);
        botonlogin = findViewById(R.id.botonlogin);
        chistes = findViewById(R.id.chistes);

        MyOpenHelper dbHelper = new MyOpenHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if (db != null) {
            db.execSQL("INSERT INTO comments (comment, user) VALUES ('hola','hola')");
        }
        db.close();

        final String questions[] = {
                "¿Cuál es el último animal que subió al arca de Noé? El del-fin.",
                "¿Cómo se dice pañuelo en japonés? Saka-moko.",
                "¿Cómo se dice disparo en árabe? Ahí-va-la-bala.",
                "¿Qué le dice un gusano a otro gusano? Voy a dar una vuelta a la manzana.",
                "¿Cuál es el colmo de Aladdín?  Tener mal genio.",
                "Si se muere una pulga, ¿a dónde va? Al pulgatorio.",
                "¿Cómo se dice pelo sucio en chino? Chin cham pu.",
                "¿Cómo se llama el primo de Bruce Lee? Broco Lee."
        };
        Random rand = new Random();
        int Questions = rand.nextInt(8);
        chistes.setText(questions[Questions]);

        botonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Pagina_principal.class);

                startActivity(intent);
            }
        });
    }


}