package com.example.enviarsms;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mobil_no,message;
    Button Enviarmensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mobil_no=(EditText)findViewById(R.id.editTexto1);
        message=(EditText)findViewById(R.id.editTexto2);

        Enviarmensaje =(Button)findViewById(R.id.button1);

      Enviarmensaje.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
                String  no=mobil_no.getText().toString();
                String msg= message.getText().toString();

              Intent intent = new Intent(getApplicationContext(),MainActivity.class);
              PendingIntent pi= PendingIntent.getActivity(getApplicationContext(),0,intent,0);

              SmsManager sms= SmsManager.getDefault();
              sms.sendTextMessage(no,null, msg,pi,null);

              Toast.makeText(getApplicationContext(),"Mensaje enviado correctamente!",Toast.LENGTH_LONG).show();
          }
        });


    }
}
