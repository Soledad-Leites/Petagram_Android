package leites.sole.petagram.menues;

import android.app.ProgressDialog;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.loader.content.AsyncTaskLoader;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import leites.sole.petagram.R;

public class contactoForm extends AppCompatActivity {

    AppCompatEditText ingNombre, ingEmail, ingComentario;
    AppCompatButton btnEnviar;
    String sEmail, sContrasenia;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto_formulario);

        //ASIGNAR VARIABLES

        ingNombre = findViewById(R.id.ingNombre);
        ingEmail = findViewById(R.id.ingEmail);
        ingComentario = findViewById(R.id.ingComentario);
        btnEnviar = findViewById(R.id.btnEnviar);

        //CREDENCIALES

        sEmail = "Por favor ingrese su dirección de correo: ";
        sContrasenia = "Ahora ingrese su contraseña:";

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Properties properties = new Properties();
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.starttls.enable", "true");
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.port", "587");



  /*BLOQUE QUE TE REDIRECCIONA A GMAIL PARA QUE ENVIES EL MENSAJE SIN UTILIZAR JAVAMAIL
                                         @Override
                                         public void onClick(View v) {
                                             Intent intent = new Intent(Intent.ACTION_VIEW,
                                                     Uri.parse("mailto: " + ingEmail.getText().toString()));
                                             intent.putExtra(Intent.EXTRA_SUBJECT, ingNombre.getText().toString());
                                             intent.putExtra(Intent.EXTRA_TEXT, ingComentario.getText().toString());
                                             startActivity(intent);
                                         }*/


                //SESION
                Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(sEmail, sContrasenia);
                    }
                });

                try {
                    //INICIALIZAR EL ENVIO DE MAIL
                    Message mensaje = new MimeMessage(session);
                    //REMITENTE DEL MENSAJE
                    mensaje.setFrom(new InternetAddress(sEmail));
                    //RECEPTOR DEL MENSAJE
                    mensaje.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(ingEmail.getText().toString().trim()));
                    //ASUNTO DEL MAIL QUE PARA LA OCACION SERIA EL NOMBRE DEL REMITENTE
                    mensaje.setSubject(ingNombre.getText().toString().trim());
                    //CONTENIDO DEL MAIL O EN ESTE CASO COMENTARIO
                    mensaje.setText(ingComentario.getText().toString().trim());
                    //ENVIO DEL MAIL
                    Transport.send(mensaje);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}


  /*  private class SendMail extends AsyncTask<Message, String, String> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            progressDialog = ProgressDialog.show(contactoForm.this, "Aguarde un momento",
                    "Enviando su comentario", true, false);
        }

        @Override
        protected String doInBackground(Message... messages) {
            try{
                Transport.send(messages[0]);
                return "Enviado";
            }catch (MessagingException e ){
                e.printStackTrace();
                return "Ocurrió un error al enviar su mensaje.";
            }
        }

        @Override   // ok en cuadro de dialogo
        protected void onPostExecute(String s){
            super.onPostExecute(s);
            progressDialog.dismiss();
            if (s.equals("Enviado")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(contactoForm.this);
                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<font color='#0097A7>Enviado...</font>"));
                builder.setMessage("Gracias por tu comentario!");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        //limpiar campos
                        ingNombre.setText("");
                        ingEmail.setText("");
                        ingComentario.setText("");
                    }
                });
                //activar dialog
                builder.show();
            }else{
                Toast.makeText(getApplicationContext(),
                        "Algo anda mal con el contenido de alguno de los campos...", Toast.LENGTH_LONG).show();
            }
        }

    }
}
*/