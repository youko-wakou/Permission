package techacademy.wakou.youko.permission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CODE=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                        Log.d("ANDROID","許可されている");
                    }else{
                        Log.d("ANDROID","許可されていない");
                        requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},PERMISSION_REQUEST_CODE);
                    }
                }
            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[],int[] grantResults){
        switch(requestCode){
            case PERMISSION_REQUEST_CODE:
            if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
                Log.d("ANDROID","許可された");
            }else{
                Log.d("ANDROID","許可されなかった");
            }
            break;
            default:
                break;
        }
    }
}
