package quaroline.instalynne;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    private Button btnMaSignIn;
    private Button btnMaSignUp;
    private EditText etMaUsername;
    private EditText etMaPassword;
    Context context;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        context = this.getApplicationContext();
        sharedPref = context.getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMaSignIn = findViewById(R.id.ma_btn_signin);
        btnMaSignUp = findViewById(R.id.ma_btn_signup);
        etMaUsername = findViewById(R.id.ma_et_username);
        etMaPassword = findViewById(R.id.ma_et_password);

        btnMaSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPref.edit();

                editor.putString(getString(R.string.ma_et_username), etMaUsername.getText().toString());
                editor.putString(getString(R.string.ma_et_password), etMaPassword.getText().toString());

                editor.apply();

            }
        });

        btnMaSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), sharedPref.getString(getString(R.string.ma_et_username), etMaUsername.getText().toString()) + "\n" + sharedPref.getString(getString(R.string.ma_et_password), etMaPassword.getText().toString()), Toast.LENGTH_LONG).show();
            }
        });
    }
}
