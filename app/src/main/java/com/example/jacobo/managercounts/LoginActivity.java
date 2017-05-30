package com.example.jacobo.managercounts;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthCredential;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FacebookAuthProvider;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private LoginButton loginButton;
    private CallbackManager callbackManager;

  //  private FirebaseAuth firebaseAuth;
  //  private FirebaseAuth.AuthStateListener firebaseAuthListener;

    //private ProgressBar progressBar;

    Button bLIniciar;
    TextView tLRegistrarse;

    EditText eLUsuario, eLClave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        callbackManager = CallbackManager.Factory.create();

        loginButton = (LoginButton) findViewById(R.id.bLoginFacebbok);

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                //handleFacebookAccesToken (loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), R.string.cancel_login, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), R.string.error_login, Toast.LENGTH_SHORT).show();
            }
        });

       /* firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    goMainScreen();
                }
            }
        };*/

        bLIniciar = (Button) findViewById(R.id.bLIniciar);              //Botón Iniciar que esta en la actividad Login, al presionarse debe direccionar .
        tLRegistrarse = (TextView) findViewById(R.id.tLRegistrarse);    //El TextView REGISTRARSE funciona como un botón el cual direcciona a la actividad REGISTRO.

        eLUsuario = (EditText) findViewById(R.id.eLUsuario);
        eLClave = (EditText) findViewById(R.id.eLClave);

        tLRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivityForResult(intent,1234);
            }
        });

    }
/*
    private void handleFacebookAccesToken(AccessToken accessToken) {

        //progressBar.setVisibility(View.VISIBLE);
        //progressBar.setVisibility(View.GONE);

        AuthCredential credential = FacebookAuthProvider.getCredential(accessToken.getToken());
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),R.string.firebase_error_login, Toast.LENGTH_LONG).show();;
                }
                //progressBar.setVisibility(View.GONE);
                //progressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(firebaseAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        firebaseAuth.removeAuthStateListener(firebaseAuthListener);
    }
*/
    private void goMainScreen() {
        Intent intent = new Intent(this, DrawerClienteActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == 1234 && resultCode == RESULT_OK){

        } else if (requestCode == 1234 && resultCode == RESULT_CANCELED){
            Toast.makeText(this, "ERROR en Registro", Toast.LENGTH_SHORT).show();
        }else{
            super.onActivityResult(requestCode, resultCode, data);
            callbackManager.onActivityResult(requestCode, resultCode, data);
        }
    }


    public void Inicio(View view){
        if(eLUsuario.getText().toString().matches("Admin")) {
            Intent intent = new Intent(this, DrawerVendActivity.class);
            startActivity(intent);
            finish();
        }
        else if(eLUsuario.getText().toString().matches("Cliente")) {
            Intent intent = new Intent(this, DrawerClienteActivity.class);
            startActivity(intent);
            finish();
        }

        else{
            Toast.makeText(this,"Datos Incorrectos",Toast.LENGTH_SHORT).show();

        }



    }
}
